package com.example.apiplanetastestesautomatizados.domain;

import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.DoubleStream;

@Service
public class PlanetaService {

    private PlanetaRepository planetaRepository;

    public PlanetaService(PlanetaRepository planetaRepository) {
        this.planetaRepository = planetaRepository;
    }

    public Planeta create(Planeta planeta){
        return planetaRepository.save(planeta);
    }

    public Optional<Planeta> get(Long id) {
        return planetaRepository.findById(id);
    }
}
