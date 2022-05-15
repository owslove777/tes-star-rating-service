package com.skcc.tes.starrating.application.config;

import com.skcc.tes.starrating.domain.ports.api.StarRateServiceImpl;
import com.skcc.tes.starrating.domain.ports.api.StarRateServicePort;
import com.skcc.tes.starrating.domain.ports.spi.StarRatePersistencePort;
import com.skcc.tes.starrating.infrastructure.adapters.jpa.StarRateJpaAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StarRateConfig {
    @Bean
    public StarRatePersistencePort bookPersistence(){
        return new StarRateJpaAdapter();
    }

    @Bean
    public StarRateServicePort bookService(){
        return new StarRateServiceImpl(bookPersistence());
    }
}
