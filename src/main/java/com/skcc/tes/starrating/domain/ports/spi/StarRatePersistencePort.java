package com.skcc.tes.starrating.domain.ports.spi;

import com.skcc.tes.starrating.domain.data.StarRateDto;
import com.skcc.tes.starrating.infrastructure.entity.StarRate;

import java.util.List;

public interface StarRatePersistencePort {

      StarRateDto addStarRate(StarRateDto src);

      Boolean deleteStarRateById(Long id);

//    StarRate updateStarRate(StarRate src);

      List<StarRateDto> getStarRates();

      StarRateDto getStarRateById(Long id);
}
