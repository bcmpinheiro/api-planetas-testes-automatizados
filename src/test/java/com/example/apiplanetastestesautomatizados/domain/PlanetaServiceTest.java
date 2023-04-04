package com.example.apiplanetastestesautomatizados.domain;

import static com.example.apiplanetastestesautomatizados.common.PlanetaConstantes.PLANETA;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

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


}
