package com.travelmap.uidomotdaero.service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelmap.uidomotdaero.ResourceNotFoundException;
import com.travelmap.uidomotdaero.repository.SubscriberEmotionRepository;
import com.travelmap.uidomotdaero.repository.TravelEmotionRepository;
import com.travelmap.uidomotdaero.vo.SubscriberEmotion;
import com.travelmap.uidomotdaero.vo.SubscriberEmotionDTO;
import com.travelmap.uidomotdaero.vo.TravelEmotionDTO;
import com.travelmap.uidomotdaero.vo.TravelEmotionLog;

@Service
public class EmotionService {
    
    @Autowired
    private TravelEmotionRepository emotionRepository;
    @Autowired
    private SubscriberEmotionRepository subScriberEmotionRepository;
    
    public List<TravelEmotionDTO> findAllEmotions() {
        List<TravelEmotionLog> emotions = emotionRepository.findAll();
        return emotions.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public TravelEmotionDTO findEmotionById(Long id) {
    	TravelEmotionLog emotion = emotionRepository.findById(id)
    			.orElseThrow(() -> new ResourceNotFoundException("TravelEmotion not found with id: " + id));
        return convertToDTO(emotion);
    }
    
    public List<TravelEmotionDTO> findEmotionsByLocation(Double latitude, Double longitude, Double radius) {
        // 위도/경도 기준으로 반경 내 감정 데이터 찾기
        List<TravelEmotionLog> emotions = emotionRepository.findByLocationNear(latitude, longitude, radius);
        return emotions.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    private TravelEmotionDTO convertToDTO(TravelEmotionLog emotion) {
        TravelEmotionDTO dto = new TravelEmotionDTO();
        dto.setId(emotion.getLogId());
        dto.setMeName(emotion.getMeName());
        dto.setTitle(emotion.getTitle());
        dto.setLocationName(emotion.getLocationName());
        dto.setLatitude(emotion.getLatitude());
        dto.setLongitude(emotion.getLongitude());
        dto.setTravelDate(emotion.getTravelDate());
        dto.setEmotionRating(emotion.getEmotionRating());
        dto.setEmotionTags(emotion.getEmotionTags());
        dto.setReviewText(emotion.getReviewText());
        dto.setYoutubeUrl(emotion.getYoutubeUrl());
        dto.setImageUrl(emotion.getImageUrl());
        return dto;
    }
    
    // 구독자 감정 조회 (새로 추가)
    public List<SubscriberEmotionDTO> findSubscriberEmotions() {
        // 나중에 구현할 때는 아래처럼:
         return subScriberEmotionRepository.findByIsApprovedOrderByCreatedDateDesc(true)
             .stream()
             .map(this::convertToDTO)
             .collect(Collectors.toList());
    }

    // 구독자 감정 저장 (새로 추가)
    public TravelEmotionDTO saveSubscriberEmotion(TravelEmotionDTO emotion) {
        // 임시 구현 (나중에 실제 저장 로직 추가)
        emotion.setId(generateRandomId()); // 임의의 ID 생성
        return emotion;
        
        // 나중에 구현할 때는 아래처럼:
        // SubscriberEmotion entity = convertToEntity(emotion);
        // entity.setApproved(false); // 승인 전 상태로 저장
        // entity.setCreatedDate(LocalDateTime.now());
        // return convertToDTO(subscriberEmotionRepository.save(entity));
    }

    // 임의의 ID 생성 (임시용)
    private Long generateRandomId() {
        return new Random().nextLong(10000) + 1;
    }
    
    //convert 용
    private SubscriberEmotionDTO convertToDTO(SubscriberEmotion entity) {
        SubscriberEmotionDTO dto = new SubscriberEmotionDTO();
        dto.setId(entity.getId());
        dto.setMeName(entity.getMeName());
        dto.setEmail(entity.getEmail());
        dto.setLatitude(entity.getLatitude());
        dto.setLongitude(entity.getLongitude());
        dto.setLocationName(entity.getLocationName());
        dto.setEmotionType(entity.getEmotionType());
        dto.setReviewText(entity.getReviewText());
        dto.setImageUrl(entity.getImageUrl());        
        dto.setYoutubeUrl(entity.getYoutubeUrl());
        dto.setCreatedDate(entity.getCreatedDate());
//        dto.setApproved(entity.isApproved());
        dto.setApprovedDate(entity.getApprovedDate());
        dto.setApprovedBy(entity.getApprovedBy());
        return dto;
    }
}

