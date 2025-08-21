package com.travelmap.uidomotdaero.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class TravelPhoto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String photoUrl;
    
    // 이 부분 추가
    @ManyToOne
    @JoinColumn(name = "emotion_log_id")
    private TravelEmotionLog emotionLog;
    
    // 기본 생성자
    public TravelPhoto() {
    }
    
    // getter와 setter 추가
    public TravelEmotionLog getEmotionLog() {
        return emotionLog;
    }
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public void setEmotionLog(TravelEmotionLog emotionLog) {
        this.emotionLog = emotionLog;
    }
    
    // 기존 getter와 setter들...
}