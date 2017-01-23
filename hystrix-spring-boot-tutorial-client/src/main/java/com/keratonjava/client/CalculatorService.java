package com.keratonjava.client;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class CalculatorService {

    private final RestTemplate restTemplate;

    @Autowired
    public CalculatorService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "fakeRandom")
    public String calculateRandom() {
        URI uri = URI.create("http://localhost:8080/random");
        return this.restTemplate.getForObject(uri, String.class);
    }

    public String fakeRandom() {
        return "fake-2e8d-4565-a4a7-9cb5bb8a4c42";
    }
}
