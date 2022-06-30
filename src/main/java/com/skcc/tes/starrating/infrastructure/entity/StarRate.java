package com.skcc.tes.starrating.infrastructure.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.skcc.tes.starrating.StarRatingApplication;
import com.skcc.tes.starrating.domain.data.StarRateDto;
import com.skcc.tes.starrating.infrastructure.adapters.kafka.StarRateCreated;
import com.skcc.tes.starrating.infrastructure.repository.StarRateRepository;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity(name = "star_rate")
@Table(name = "star_rate")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StarRate {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;		// 관리번호

	@Column(nullable = false)
	Long talentId;	// 재능 카테고리 아이디

	@Column(nullable = false)
	String title;   // 재능명

	@Column(nullable = false)
	Double rate;	// 평점
	String comment;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	LocalDateTime serviceDate;	// 서비스 일자

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	LocalDateTime rateDate; 	// 평가 일자

	public StarRateDto toDto() {
		return StarRateDto.builder()
				.id(id)
				.talentId(talentId)
				.title(title)
				.comment(comment)
				.rate(rate)
				.serviceDate(serviceDate)
				.rateDate(rateDate)
				.build();
	}
	public static StarRate toDto(StarRateDto starRateDto) {
		return StarRate.builder()
				.id(starRateDto.getId())
				.talentId(starRateDto.getTalentId())
				.title(starRateDto.getTitle())
				.comment(starRateDto.getComment())
				.rate(starRateDto.getRate())
				.serviceDate(starRateDto.getServiceDate())
				.rateDate(starRateDto.getRateDate())
				.build();
	}


	public static List<StarRateDto> toDtoList(List<StarRate> list) {
		return list.stream().map(StarRate::toDto).collect(Collectors.toList());
	}


	public StarRateDto save() {
		StarRateRepository repository = StarRatingApplication.getApplicationContext().getBean(StarRateRepository.class);
		StarRate saved = repository.save(this);
		return saved.toDto();
	}

	@PostPersist
	public void onPostPersist(){
		StarRateCreated starRateCreated = StarRateCreated.builder()
				.status("CREATED")
				.starRateId(id)
				.comment(comment)
				.rate(rate)
				.talentId(talentId)
				.title(title)
				.build();
		starRateCreated.publishAfterCommit();
	}
}
