package com.travelmap.uidomotdaero.vo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TRAVEL_EMOTION_SUBSCRIBER_LOG")
public class SubscriberEmotion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "log_id")
    private Long id;
    
    @Column(nullable = false)
    private Double latitude;
    
    @Column(name = "submitter_name")
    private String submitterName;
    
    @Column(nullable = false)
    private Double longitude;
    
    @Column(name = "location_name")
    private String locationName;
    
    @Column(name = "emotion_type", nullable = false, length = 20)
    private String emotionType;
    
    @Column(name = "review_text", columnDefinition = "TEXT")
    private String reviewText;
    
    @Column(name = "title")
    private String title;
    
    @Column(name = "travel_date")
    private LocalDate travelDate;
    
    @Column(name = "youtube_url")
    private String youtubeUrl;
    
    @Column(name = "created_date")
    private LocalDateTime createdDate;
    
    @Column(name = "emotion_rating")
    private Integer emotionRating;
    
    @Column(name = "emotion_tags")
    private String emotionTags;
    
    @Column(name = "me_name", nullable = false)
    private String meName;
    
    @Column(nullable = false)
    private String email;
    
    @Column(name = "is_approved")
    private Boolean isApproved = false;
    
    @Column(name = "approved_date")
    private LocalDateTime approvedDate;
    
    @Column(name = "image_url")
    private String imageUrl;
    
	@Column(name = "photo_url1")
    private String photoUrl1;
    
    @Column(name = "photo_url2")
    private String photoUrl2;
    
    @Column(name = "photo_url3")
    private String photoUrl3;
    
    @Column(name = "photo_url4")
    private String photoUrl4;
    
    @Column(name = "photo_url5")
    private String photoUrl5;
    
    @Column(name= "approved_by")
    private String approvedBy;
    
    @Column(name= "weather_condition")
    private String weatherCondition;
    

    public String getSubmitterName() {
		return submitterName;
	}

	public void setSubmitterName(String submitterName) {
		this.submitterName = submitterName;
	}

	public String getWeatherCondition() {
		return weatherCondition;
	}

	public void setWeatherCondition(String weatherCondition) {
		this.weatherCondition = weatherCondition;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
    public String getPhotoUrl1() {
		return photoUrl1;
	}

	public void setPhotoUrl1(String photoUrl1) {
		this.photoUrl1 = photoUrl1;
	}

	public String getPhotoUrl2() {
		return photoUrl2;
	}

	public void setPhotoUrl2(String photo_url2) {
		this.photoUrl2 = photoUrl2;
	}

	public String getPhotoUrl3() {
		return photoUrl3;
	}

	public void setPhotoUrl3(String photoUrl3) {
		this.photoUrl3 = photoUrl3;
	}

	public String getPhotoUrl4() {
		return photoUrl4;
	}

	public void setPhotoUrl4(String photoUrl4) {
		this.photoUrl4 = photoUrl4;
	}

	public String getPhotoUrl5() {
		return photoUrl5;
	}

	public void setPhotoUrl5(String photoUrl5) {
		this.photoUrl5 = photoUrl5;
	}

	// 기본 생성자
    public SubscriberEmotion() {
    }
    
    // Getter와 Setter 메서드들
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getEmotionType() {
        return emotionType;
    }

    public void setEmotionType(String emotionType) {
        this.emotionType = emotionType;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(LocalDate travelDate) {
        this.travelDate = travelDate;
    }

    public String getYoutubeUrl() {
        return youtubeUrl;
    }

    public void setYoutubeUrl(String youtubeUrl) {
        this.youtubeUrl = youtubeUrl;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
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

    public String getMeName() {
        return meName;
    }

    public void setMeName(String meName) {
        this.meName = meName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(Boolean isApproved) {
        this.isApproved = isApproved;
    }

    public LocalDateTime getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(LocalDateTime approvedDate) {
        this.approvedDate = approvedDate;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }
}