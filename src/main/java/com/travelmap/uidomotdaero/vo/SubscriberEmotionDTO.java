package com.travelmap.uidomotdaero.vo;

import java.time.LocalDateTime;

public class SubscriberEmotionDTO {
	    private Long id;
	    private String meName;
	    private String email;
	    private Double latitude;
	    private Double longitude;
	    private String locationName;
	    private String emotionType;
	    private String reviewText;
	    private String youtubeUrl;
		private String imageUrl;
	    private LocalDateTime createdDate;
	    private boolean isApproved;
	    private LocalDateTime approvedDate;
	    private String approvedBy;
	    private String submitterName;
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

		// 생성자, Getter, Setter
	    public SubscriberEmotionDTO() {}

	    // Getter & Setter 메서드들
	    public Long getId() { return id; }
	    public void setId(Long id) { this.id = id; }

	    public String getMeName() { return meName; }
	    public void setMeName(String meName) { this.meName = meName; }

	    public String getEmail() { return email; }
	    public void setEmail(String email) { this.email = email; }

	    public Double getLatitude() { return latitude; }
	    public void setLatitude(Double latitude) { this.latitude = latitude; }

	    public Double getLongitude() { return longitude; }
	    public void setLongitude(Double longitude) { this.longitude = longitude; }

	    public String getLocationName() { return locationName; }
	    public void setLocationName(String locationName) { this.locationName = locationName; }

	    public String getEmotionType() { return emotionType; }
	    public void setEmotionType(String emotionType) { this.emotionType = emotionType; }

	    public String getReviewText() { return reviewText; }
	    public void setReviewText(String reviewText) { this.reviewText = reviewText; }

	    public String getImageUrl() { return imageUrl; }
	    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

	    public LocalDateTime getCreatedDate() { return createdDate; }
	    public void setCreatedDate(LocalDateTime createdDate) { this.createdDate = createdDate; }

	    public boolean isApproved() { return isApproved; }
	    public void setApproved(boolean approved) { isApproved = approved; }

	    public LocalDateTime getApprovedDate() { return approvedDate; }
	    public void setApprovedDate(LocalDateTime approvedDate) { this.approvedDate = approvedDate; }

	    public String getApprovedBy() { return approvedBy; }
	    public void setApprovedBy(String approvedBy) { this.approvedBy = approvedBy; }
	    
	    public String getYoutubeUrl() {
			return youtubeUrl;
		}

		public void setYoutubeUrl(String youtubeUrl) {
			this.youtubeUrl = youtubeUrl;
		}
}
