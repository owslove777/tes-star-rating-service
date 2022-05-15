package com.skcc.tes.starrating.infrastructure.repository;

import com.skcc.tes.starrating.infrastructure.entity.StarRate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StarRateRepository extends JpaRepository<StarRate, Long>{
    
}
