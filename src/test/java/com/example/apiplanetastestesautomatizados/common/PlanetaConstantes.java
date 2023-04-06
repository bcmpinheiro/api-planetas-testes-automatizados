package com.example.apiplanetastestesautomatizados.common;

import com.example.apiplanetastestesautomatizados.domain.Planeta;

public class PlanetaConstantes {

    public static final Planeta PLANETA = new Planeta("name", "clima", "terreno");
    public static final Planeta PLANETA_INVALIDO = new Planeta(" ", " ", " ");
}
