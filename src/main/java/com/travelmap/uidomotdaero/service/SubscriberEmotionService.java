package com.travelmap.uidomotdaero.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelmap.uidomotdaero.repository.SubscriberEmotionRepository;
import com.travelmap.uidomotdaero.vo.SubscriberEmotion;
import com.travelmap.uidomotdaero.vo.SubscriberEmotionDTO;

@Service
public class SubscriberEmotionService {

    @Autowired
    private SubscriberEmotionRepository subscriberEmotionRepository;

    // 모든 승인된 구독자 감정 조회
    public List<SubscriberEmotionDTO> getAllApprovedEmotions() {
        List<SubscriberEmotion> emotions = subscriberEmotionRepository.findByIsApprovedOrderByCreatedDateDesc(true);
        return emotions.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
	// 모든 미승인 구독자 감정 조회 (관리자용)
	public List<SubscriberEmotionDTO> getAllPendingEmotions() {
	    List<SubscriberEmotion> emotions = subscriberEmotionRepository.findByIsApprovedOrderByCreatedDateDesc(false);
	    return emotions.stream()
	            .map(this::convertToDTO)
	            .collect(Collectors.toList());
	}

	// 구독자 감정 저장 (이메일이나 폼으로 제출된 데이터)
	public SubscriberEmotionDTO saveSubscriberEmotion(SubscriberEmotionDTO emotionDTO) {
	    SubscriberEmotion emotion = convertToEntity(emotionDTO);
	    emotion.setCreatedDate(LocalDateTime.now());
//	    emotion.setApproved(false); // 기본적으로 승인되지 않은 상태로 저장
	    SubscriberEmotion savedEmotion = subscriberEmotionRepository.save(emotion);
	    return convertToDTO(savedEmotion);
	}

	// 구독자 감정 승인 (관리자 기능)
	public SubscriberEmotionDTO approveEmotion(Long id, String approvedBy) {
	    Optional<SubscriberEmotion> optionalEmotion = subscriberEmotionRepository.findById(id);
	    if (optionalEmotion.isPresent()) {
	        SubscriberEmotion emotion = optionalEmotion.get();
//	        emotion.setApproved(true);
	        emotion.setApprovedDate(LocalDateTime.now());
	        emotion.setApprovedBy(approvedBy);
	        return convertToDTO(subscriberEmotionRepository.save(emotion));
	    }
	    return null; // 또는 예외 처리
	}

	// 구독자 감정 거절 (관리자 기능 - 선택적)
	public void rejectEmotion(Long id) {
	    subscriberEmotionRepository.deleteById(id);
	}

	// DTO -> Entity 변환
	private SubscriberEmotion convertToEntity(SubscriberEmotionDTO dto) {
	    SubscriberEmotion entity = new SubscriberEmotion();
	    entity.setId(dto.getId());
	    entity.setMeName(dto.getMeName());
	    entity.setEmail(dto.getEmail());
	    entity.setLatitude(dto.getLatitude());
	    entity.setLongitude(dto.getLongitude());
	    entity.setLocationName(dto.getLocationName());
	    entity.setEmotionType(dto.getEmotionType());
	    entity.setReviewText(dto.getReviewText());
	    entity.setImageUrl(dto.getImageUrl());
	    entity.setCreatedDate(dto.getCreatedDate());
//	    entity.setApproved(dto.isApproved());
	    entity.setApprovedDate(dto.getApprovedDate());
	    entity.setApprovedBy(dto.getApprovedBy());
	    return entity;
	}

	// Entity -> DTO 변환
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
	    dto.setYoutubeUrl(entity.getYoutubeUrl());
	    dto.setImageUrl(entity.getImageUrl());
	    dto.setCreatedDate(entity.getCreatedDate());
//	    dto.setApproved(entity.isApproved());
	    dto.setApprovedDate(entity.getApprovedDate());
	    dto.setApprovedBy(entity.getApprovedBy());
	    return dto;
	}
}