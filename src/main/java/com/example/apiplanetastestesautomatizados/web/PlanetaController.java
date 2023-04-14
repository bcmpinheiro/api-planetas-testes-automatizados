package com.example.apiplanetastestesautomatizados.web;

import com.example.apiplanetastestesautomatizados.domain.Planeta;
import com.example.apiplanetastestesautomatizados.domain.PlanetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/planetas")
public class PlanetaController {

    @Autowired
    private PlanetaService planetaService;

    @PostMapping
    public ResponseEntity<Planeta> create(@RequestBody Planeta planeta) {
        Planeta planetaCreated = planetaService.create(planeta);
        return ResponseEntity.status(HttpStatus.CREATED).body(planetaCreated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Planeta> get(@PathVariable("id") Long id) {
        return planetaService.get(id).map(planeta -> ResponseEntity.ok(planeta))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


}
