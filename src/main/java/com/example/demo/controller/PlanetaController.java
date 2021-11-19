package com.example.demo.controller;

import com.mashape.unirest.http.*;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PlanetaController {

    @GetMapping
    public String listaPlanetas() throws UnirestException {
        HttpResponse<JsonNode> jsonResponse = Unirest.get("https://swapi.dev/api/planets").asJson();
        JSONObject json = jsonResponse.getBody().getObject();
        return json.toString();
    }
}
