package com.travelmap.uidomotdaero.vo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EmotionPoint {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	private String title;
	private String description;
	private Double  latitude;
	private Double  longitude;
	private String emotionTag;
	private String mediaUrl;
	private LocalDate  tripDate;
	private String  regionKoreanName;
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public String getEmotionTag() {
		return emotionTag;
	}
	public void setEmotionTag(String emotionTag) {
		this.emotionTag = emotionTag;
	}
	public String getMediaUrl() {
		return mediaUrl;
	}
	public void setMediaUrl(String mediaUrl) {
		this.mediaUrl = mediaUrl;
	}
	public LocalDate getTripDate() {
		return tripDate;
	}
	public void setTripDate(LocalDate tripDate) {
		this.tripDate = tripDate;
	}
	public String getRegionKoreanName() {
		return regionKoreanName;
	}
	public void setRegionKoreanName(String regionKoreanName) {
		this.regionKoreanName = regionKoreanName;
	}
	public String getRegionLevel() {
		return regionLevel;
	}
	public void setRegionLevel(String regionLevel) {
		this.regionLevel = regionLevel;
	}
	private String  regionLevel;
	
}
