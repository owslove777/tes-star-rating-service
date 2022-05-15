package com.skcc.tes.starrating.infrastructure.adapters.jpa;

import com.skcc.tes.starrating.domain.data.StarRateDto;
import com.skcc.tes.starrating.domain.ports.spi.StarRatePersistencePort;
import com.skcc.tes.starrating.infrastructure.entity.StarRate;
import com.skcc.tes.starrating.infrastructure.mappers.StarRateMapper;
import com.skcc.tes.starrating.infrastructure.repository.StarRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StarRateJpaAdapter implements StarRatePersistencePort {

    @Autowired
    private StarRateRepository starRateRepository;

    @Override
    public StarRateDto addStarRate(StarRateDto starRateDto) {

        StarRate book = StarRateMapper.INSTANCE.starRateDtoToStarRate(starRateDto);

        StarRate bookSaved = starRateRepository.save(book);

        return StarRateMapper.INSTANCE.starRateToStarRateDto(bookSaved);
    }

    @Override
    public void deleteStarRateById(Long id) {
        starRateRepository.deleteById(id);
    }

    @Override
    public StarRateDto updateStarRate(StarRateDto src) {
        return addStarRate(src);
    }

    @Override
    public List<StarRateDto> getStarRates() {
        List<StarRate> starRateList = starRateRepository.findAll();
        return StarRateMapper.INSTANCE.starRateListToStarRateDtoList(starRateList);
    }

    @Override
    public StarRateDto getStarRateById(Long id) {
        Optional<StarRate> starRate = starRateRepository.findById(id);

        return starRate.map(StarRateMapper.INSTANCE::starRateToStarRateDto).orElse(null);

    }
}
