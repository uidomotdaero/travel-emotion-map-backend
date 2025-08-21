package com.travelmap.uidomotdaero.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travelmap.uidomotdaero.service.EmotionService;
import com.travelmap.uidomotdaero.vo.SubscriberEmotionDTO;
import com.travelmap.uidomotdaero.vo.TravelEmotionDTO;


@RestController
@RequestMapping("/api")
public class EmotionPointController {

	@Autowired
    private EmotionService emotionService;
    
    @GetMapping
    public ResponseEntity<List<TravelEmotionDTO>> getAllEmotions() {
        List<TravelEmotionDTO> emotions = emotionService.findAllEmotions();
        System.out.print(emotions.get(0).getEmotionTags());
        System.out.print(emotions.get(0).getImageUrl());
        return ResponseEntity.ok(emotions);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<TravelEmotionDTO> getEmotionById(@PathVariable Long id) {
        TravelEmotionDTO emotion = emotionService.findEmotionById(id);
        System.out.print(emotion.getEmotionTags());
        System.out.print(emotion.getImageUrl());
        return ResponseEntity.ok(emotion);
    }
    
    @GetMapping("/location")
    public ResponseEntity<List<TravelEmotionDTO>> getEmotionsByLocation(
            @RequestParam Double latitude, 
            @RequestParam Double longitude,
            @RequestParam(required = false) Double radius) {
        // 기본 반경 5km
        double searchRadius = (radius != null) ? radius : 5.0;
        List<TravelEmotionDTO> emotions = emotionService.findEmotionsByLocation(latitude, longitude, searchRadius);
        return ResponseEntity.ok(emotions);
    }
    
    @GetMapping("/subscriber-emotions")
    public ResponseEntity<List<SubscriberEmotionDTO>> getSubscriberEmotions() {
        // 지금은 임시로 빈 리스트 반환 (나중에 구독자 데이터 생기면 교체)
    	List<SubscriberEmotionDTO> subscriberEmotionDTO = emotionService.findSubscriberEmotions();
        return ResponseEntity.ok(subscriberEmotionDTO);
    }

    // 구독자 감정 제출용 API (선택사항)
//    @PostMapping("/subscriber-emotions")
//    public ResponseEntity<?> submitSubscriberEmotion(@RequestBody TravelEmotionDTO emotion) {
//        // 이메일이나 폼으로 받은 정보 저장 로직
//        emotionService.saveSubscriberEmotion(emotion);
//        return ResponseEntity.ok("감정이 성공적으로 제출되었습니다!");
//    }
    
    @GetMapping("/travel-emotions")
    public ResponseEntity<List<TravelEmotionDTO>> getMyEmotions() {
        List<TravelEmotionDTO> emotions = emotionService.findAllEmotions();
        return ResponseEntity.ok(emotions);
    }
    
	
	
}
