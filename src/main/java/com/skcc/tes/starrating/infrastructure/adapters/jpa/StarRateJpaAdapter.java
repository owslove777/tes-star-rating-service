package com.skcc.tes.starrating.infrastructure.adapters.jpa;

import com.skcc.tes.starrating.domain.data.StarRateDto;
import com.skcc.tes.starrating.domain.ports.spi.StarRatePersistencePort;
import com.skcc.tes.starrating.infrastructure.entity.StarRate;
import com.skcc.tes.starrating.infrastructure.mappers.StarRateMapper;
import com.skcc.tes.starrating.infrastructure.repository.StarRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StarRateJpaAdapter implements StarRatePersistencePort {

    @Autowired
    private StarRateRepository starRateRepository;

    @Override
    public StarRateDto addStarRate(StarRateDto starRateDto) {

        StarRate starRateSaved = starRateRepository.save(StarRate.toDto(starRateDto));
        System.out.println("====1 addStarRate==================" + starRateDto);
        return starRateSaved.toDto();
    }

    @Override
    public Boolean deleteStarRateById(Long id) {
        starRateRepository.deleteById(id);
        System.out.println("====1 deleteById==================" + id);
        return true;
    }

//    @Override
//    public StarRateDto updateStarRate(StarRateDto src) {
//        return addStarRate(src);
//    }
//
    @Override
    public List<StarRateDto> getStarRates() {
        List<StarRate> starRateList = starRateRepository.findAll();
        System.out.println("====getStarRates==================" + starRateList);
        return StarRate.toDtoList(starRateList);
    }

    @Override
    public StarRateDto getStarRateById(Long id) {
        Optional<StarRate> starRate = starRateRepository.findById(id);
        System.out.println("====getStarRateById==================" + starRate);
        return starRate.map(StarRate::toDto).orElse(null);

    }

}
