package com.skcc.tes.starrating.application.controller;

import com.skcc.tes.starrating.domain.data.StarRateDto;
import com.skcc.tes.starrating.domain.ports.api.StarRateServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin( methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.OPTIONS})
public class StarRateController {

//    private final StarRateRepository repository;
    private final StarRateServicePort starRateServicePort;

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World! This is Star Rate Service";
    }

    // Create
    @PostMapping("/star-rate")
    public StarRateDto createNewStarRate(@RequestBody StarRateDto src) {
        src.setId(null);
        return starRateServicePort.addStarRate(src);
    }

    // Select All
    @GetMapping("/star-rates")
    public List<StarRateDto> getAllStarRates() {
        return starRateServicePort.getStarRates();
    }

    // Select By ID
    @GetMapping("/star-rate/{id}")
    public StarRateDto getStarRateById(@PathVariable Long id) {
        return starRateServicePort.getStarRateById(id);
    }

    @DeleteMapping("/star-rate/{id}")
    public Boolean  deleteStarRate(@PathVariable Long id){
        return starRateServicePort.deleteStarRateById(id);
    }
}
