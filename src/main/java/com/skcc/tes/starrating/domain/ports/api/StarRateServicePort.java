package com.skcc.tes.starrating.domain.ports.api;

import com.skcc.tes.starrating.domain.data.StarRateDto;

import java.util.List;

public interface StarRateServicePort {
    StarRateDto addStarRate(StarRateDto src);

    void deleteStarRateById(Long id);

    StarRateDto updateStarRate(StarRateDto bookDto);

    List<StarRateDto> getStarRates();

    StarRateDto getStarRateById(Long bookId);
}
