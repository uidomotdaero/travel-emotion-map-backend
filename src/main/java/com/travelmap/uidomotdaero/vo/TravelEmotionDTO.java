package com.travelmap.uidomotdaero.vo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TravelEmotionDTO {
    private Long id;
    private String meName;
	private String title;
    private String locationName;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private LocalDate travelDate;
	private Integer emotionRating;  // 1-5 점 감정 점수
    private String emotionTags;     // 쉼표로 구분된 감정 태그들
    private String reviewText;      // 감상평
    private String youtubeUrl;      // 유튜브 URL
	private String imageUrl; // 사진 URL 목록
    private LocalDateTime createdAt;
	private String weatherCondition; // 날씨
    
    public String getWeatherCondition() {
		return weatherCondition;
	}

	public void setWeatherCondition(String weatherCondition) {
		this.weatherCondition = weatherCondition;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getMeName() {
			return meName;
	}

	public void setMeName(String meName) {
		this.meName = meName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public LocalDate getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(LocalDate travelDate) {
		this.travelDate = travelDate;
	}

	public Integer getEmotionRating() {
		return emotionRating;
	}

	public void setEmotionRating(Integer emotionRating) {
		this.emotionRating = emotionRating;
	}

	public String getEmotionTags() {
		return emotionTags;
	}

	public void setEmotionTags(String emotionTags) {
		this.emotionTags = emotionTags;
	}

	public String getReviewText() {
		return reviewText;
	}

	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}

	public String getYoutubeUrl() {
		return youtubeUrl;
	}

	public void setYoutubeUrl(String youtubeUrl) {
		this.youtubeUrl = youtubeUrl;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public String getEmotionColor() {
		return emotionColor;
	}

	public void setEmotionColor(String emotionColor) {
		this.emotionColor = emotionColor;
	}

	public String getEmotionIcon() {
		return emotionIcon;
	}

	public void setEmotionIcon(String emotionIcon) {
		this.emotionIcon = emotionIcon;
	}

    
    // 오토바이 감정 지도에 표시할 때 필요한 추가 필드
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String emotionColor;    // 감정에 따른 색상 (예: "#FF5733")
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String emotionIcon;     // 감정 아이콘 (예: "😊", "🏍️")
}