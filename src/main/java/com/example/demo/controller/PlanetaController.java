package com.example.demo.controller;

import com.mashape.unirest.http.*;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PlanetaController {


    List<String> listaPaginas = new ArrayList<>();

    @GetMapping
    public List<String> listaPlanetas() throws UnirestException {

        for(int pagina = 1; pagina < 7; pagina++) {
            HttpResponse<JsonNode> jsonResponse =
                    Unirest.get("https://swapi.dev/api/planets/?page=" + pagina).asJson();
            JSONObject json = jsonResponse.getBody().getObject();

            listaPaginas.add(json.toString());

        }

        //JSONObject json = jsonResponse.getBody().getObject();

        return listaPaginas;
    }
}
