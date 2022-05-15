package com.skcc.tes.starrating.domain.ports.spi;

import com.skcc.tes.starrating.domain.data.StarRateDto;

import java.util.List;

public interface StarRatePersistencePort {
    StarRateDto addStarRate(StarRateDto src);

    void deleteStarRateById(Long id);

    StarRateDto updateStarRate(StarRateDto src);

    List<StarRateDto> getStarRates();

    StarRateDto getStarRateById(Long id);
}
