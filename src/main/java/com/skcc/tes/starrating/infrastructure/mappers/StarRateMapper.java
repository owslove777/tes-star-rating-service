package com.skcc.tes.starrating.infrastructure.mappers;

import com.skcc.tes.starrating.domain.data.StarRateDto;
import com.skcc.tes.starrating.infrastructure.entity.StarRate;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StarRateMapper {
    StarRateMapper INSTANCE = Mappers.getMapper(StarRateMapper.class);

    StarRateDto starRateToStarRateDto(StarRate book);

    StarRate starRateDtoToStarRate(StarRateDto bookDto);

    List<StarRateDto> starRateListToStarRateDtoList(List<StarRate> bookList);

    List<StarRate> starRateDtoListToStarRateList(List<StarRateDto> BookDtoList);
}
