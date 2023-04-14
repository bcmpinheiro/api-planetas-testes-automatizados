package com.example.apiplanetastestesautomatizados.domain;

import static com.example.apiplanetastestesautomatizados.common.PlanetaConstantes.PLANETA;
import static com.example.apiplanetastestesautomatizados.common.PlanetaConstantes.PLANETA_INVALIDO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
//@SpringBootTest(classes = PlanetaService.class)-(logs maiores)
public class PlanetaServiceTest {

    //@Autowired -(logs maiores)
    @InjectMocks
    private PlanetaService planetaService;

    //@MockBean -(logs maiores)
    @Mock
    private PlanetaRepository planetaRepository;

    @Test
    //operacao_estado_retorno
    public void criarPlaneta_ComDadosValidos_RetornarPlaneta() {
        // AAA - arrange (arruma os dados para o teste, coloca os stubs)
        when(planetaRepository.save(PLANETA)).thenReturn(PLANETA);

        //act - (agir, fazer a operação de fato)
        // system under test ou planeta
        Planeta sut = planetaService.create(PLANETA);

        //assert - (aferir, verificar se o subtest é o que esperava)
        assertThat(sut).isEqualTo(PLANETA);
    }
    @Test
    public void criarPlaneta_ComDadosInvalidos_ThrowsException() {
        when(planetaRepository.save(PLANETA_INVALIDO)).thenThrow(RuntimeException.class);

        assertThatThrownBy(() -> planetaService.create(PLANETA_INVALIDO)).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void consultarPlaneta_PorIdExistente_RetornaPlaneta() {
        when(planetaRepository.findById(anyLong())).thenReturn(Optional.of(PLANETA));

        Optional<Planeta> sut = planetaService.get(1L);

        assertThat(sut).isNotEmpty();
        assertThat(sut.get()).isEqualTo(PLANETA);
    }

    @Test
    public void consultarPlaneta_PorIdInexistente_RetornaVazio() {
        when(planetaRepository.findById(1L)).thenReturn(Optional.empty());

        Optional<Planeta> sut = planetaService.get(1L);

        assertThat(sut).isEmpty();
    }
}
