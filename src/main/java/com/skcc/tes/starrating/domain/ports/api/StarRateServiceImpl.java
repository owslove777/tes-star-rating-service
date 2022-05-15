package com.skcc.tes.starrating.domain.ports.api;

import com.skcc.tes.starrating.domain.data.StarRateDto;
import com.skcc.tes.starrating.domain.ports.spi.StarRatePersistencePort;

import java.util.List;

public class StarRateServiceImpl implements StarRateServicePort{

    private StarRatePersistencePort starRatePersistencePort;
    public StarRateServiceImpl(StarRatePersistencePort starRatePersistencePort) {
        this.starRatePersistencePort = starRatePersistencePort;
    }

    @Override
    public StarRateDto addStarRate(StarRateDto src) {
        return starRatePersistencePort.addStarRate(src);
    }

    @Override
    public void deleteStarRateById(Long id) {
        starRatePersistencePort.deleteStarRateById(id);
    }

    @Override
    public StarRateDto updateStarRate(StarRateDto src) {
        return starRatePersistencePort.updateStarRate(src);
    }

    @Override
    public List<StarRateDto> getStarRates() {
        return starRatePersistencePort.getStarRates();
    }

    @Override
    public StarRateDto getStarRateById(Long id) {
        return starRatePersistencePort.getStarRateById(id);
    }
}
