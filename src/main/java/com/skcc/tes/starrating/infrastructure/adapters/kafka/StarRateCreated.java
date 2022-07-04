package com.skcc.tes.starrating.infrastructure.adapters.kafka;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StarRateCreated extends AbstractKafkaEventAdapter {
    private String status; // created
    private Long starRateId;
    private Double rate;
    private String comment;
    private Long talentId;
    private String title;   // 재능명
    private Long requestUserId; // 요청자 ID
    private Long sellerId;      // 판매자 ID
}
