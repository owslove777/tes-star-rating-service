package com.skcc.tes.starrating.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StarRateCreated extends AbstractEvent{
    private String status; // created
    private Long starRateId;
    private Double rate;
    private String comment;
    private Long talentCategoryId;
}
