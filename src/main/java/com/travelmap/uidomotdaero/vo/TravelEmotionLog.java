package com.travelmap.uidomotdaero.vo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Entity - 데이터베이스 테이블과 매핑되는 JPA 엔티티
@Entity
@Table(name = "TRAVEL_EMOTION_LOG")
@Getter
@Setter
@NoArgsConstructor
public class TravelEmotionLog {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name = "LOG_ID")
 private Long logId;
 
 @Column(name = "ME_NAME")
 private String meName;
 
 @Column(name = "TITLE", nullable = false, length = 255)
 private String title;
 
 @Column(name = "LOCATION_NAME", nullable = false, length = 500)
 private String locationName;
 
 @Column(name = "LATITUDE", nullable = false)
 private BigDecimal latitude;

@Column(name = "LONGITUDE", nullable = false)
 private BigDecimal longitude;
 
 @Column(name = "TRAVEL_DATE", nullable = false)
 private LocalDate travelDate;
 
 @Column(name = "EMOTION_RATING")
 private Integer emotionRating;
 
 @Column(name = "EMOTION_TAGS", length = 255)
 private String emotionTags;
 
 @Column(name = "REVIEW_TEXT")
 private String reviewText;
 
 @Column(name = "YOUTUBE_URL", length = 1000)
 private String youtubeUrl;
 
 @Column(name = "IMAGE_URL", length = 1000)
 private String imageUrl;
 
 @Column(name = "CREATED_DATE", nullable = false, updatable = false)
 private LocalDateTime createdAt;
 
 
 
public String getImageUrl() {
	return imageUrl;
}

public void setImageUrl(String imageUrl) {
	this.imageUrl = imageUrl;
}
 public Long getLogId() {
	return logId;
}

public void setLogId(Long logId) {
	this.logId = logId;
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

public LocalDateTime getCreatedAt() {
	return createdAt;
}

public void setCreatedAt(LocalDateTime createdAt) {
	this.createdAt = createdAt;
}

public List<TravelPhoto> getPhotos() {
	return photos;
}

public void setPhotos(List<TravelPhoto> photos) {
	this.photos = photos;
}

@PrePersist
 protected void onCreate() {
     createdAt = LocalDateTime.now();
 }
 
 // 사진은 별도 테이블로 관리할 경우
 @OneToMany(mappedBy = "emotionLog", cascade = CascadeType.ALL, orphanRemoval = true)
 private List<TravelPhoto> photos = new ArrayList<>();
 
 // 편의 메서드
 public void addPhoto(TravelPhoto photo) {
     photos.add(photo);
     photo.setEmotionLog(this);
 }
 
 public void removePhoto(TravelPhoto photo) {
     photos.remove(photo);
     photo.setEmotionLog(null);
 }
}
