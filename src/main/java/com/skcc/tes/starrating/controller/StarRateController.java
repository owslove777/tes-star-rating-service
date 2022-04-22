package com.skcc.tes.starrating.controller;

import com.skcc.tes.starrating.domain.StarRate;
import com.skcc.tes.starrating.domain.StarRateRepository;
import com.skcc.tes.starrating.dto.StarRateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class StarRateController {

    private final StarRateRepository repository;

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World! This is Star Rate Service";
    }

    // Create
    @PostMapping("/star-rate")
    public StarRateDto createNewStarRate(@RequestBody StarRate src) {
        src.setId(null);
        StarRate saved = repository.save(src);
        return saved.toDto();
    }

    // Select All
    @GetMapping("/star-rates")
    public List<StarRateDto> getAllStarRates() {
        return repository.findAll().stream().map(StarRate::toDto).collect(Collectors.toList());
    }

    // Select By ID
    @GetMapping("/star-rate/{id}")
    public StarRateDto getStarRateById(@PathVariable Long id) {
        Optional<StarRate> byId = repository.findById(id);
        return byId.map(StarRate::toDto).orElse(null);
    }
}
