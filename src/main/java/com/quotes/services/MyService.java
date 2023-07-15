package com.quotes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quotes.models.Quote;

@Service
public class MyService {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;


    @Autowired
    public MyService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public Quote fetchData() {
        String url = "https://zenquotes.io/api/random";
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        String responseBody = response.getBody();
       List<Quote> quotes=null;
        try {
            // Map the JSON array to a list of MyData objects
           quotes= objectMapper.readValue(responseBody, new TypeReference<List<Quote>>() {});

            // Access the mapped data
          System.out.println(quotes.get(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return quotes.get(0);
    }
}