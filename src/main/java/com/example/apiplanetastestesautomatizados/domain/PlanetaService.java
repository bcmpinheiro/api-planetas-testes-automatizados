package com.example.apiplanetastestesautomatizados.domain;

import org.springframework.stereotype.Service;

@Service
public class PlanetaService {

    private PlanetaRepository planetaRepository;

    public PlanetaService(PlanetaRepository planetaRepository) {
        this.planetaRepository = planetaRepository;
    }

    public Planeta create(Planeta planeta){
        return planetaRepository.save(planeta);
    }

}
