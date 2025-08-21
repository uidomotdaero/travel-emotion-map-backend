package com.travelmap.uidomotdaero.service;

import org.springframework.stereotype.Service;

@Service
public class EmotionPointServiceImpl {

//	 @Autowired
//	    private EmotionPointRepository emotionPointRepository;
//	    
//	    @Autowired
//	    private RegionRepository regionRepository;
//	    
//	    public List<Map<String, Object>> getAllRegions() {
//	        // 전국 시/도 목록을 조회하고 각 지역별 감정 통계 데이터 추가
//	        List<Map<String, Object>> regions = regionRepository.findAllProvinces();
//	        
//	        // 각 지역에 감정 통계 데이터 추가
//	        for (Map<String, Object> region : regions) {
//	            Long regionId = (Long) region.get("id");
//	            Map<String, Integer> emotionSummary = calculateEmotionSummary(regionId);
//	            region.put("emotionSummary", emotionSummary);
//	            
//	            // 자식 지역(시/군/구) 수 추가 (옵션)
//	            Integer childrenCount = regionRepository.countChildrenByParentId(regionId);
//	            region.put("childrenCount", childrenCount);
//	        }
//	        
//	        return regions;
//	    }
//	    
//	    public List<Map<String, Object>> getRegionsByParent(Long parentId) {
//	        // 특정 부모 지역(도)에 속한 시/군/구 목록 조회
//	        List<Map<String, Object>> childRegions = regionRepository.findByParentId(parentId);
//	        
//	        // 각 하위 지역에 감정 통계 데이터 추가
//	        for (Map<String, Object> region : childRegions) {
//	            Long regionId = (Long) region.get("id");
//	            Map<String, Integer> emotionSummary = calculateEmotionSummary(regionId);
//	            region.put("emotionSummary", emotionSummary);
//	        }
//	        
//	        return childRegions;
//	    }
//	    
//	    public List<EmotionPoint> getEmotionPoints(Long regionId, String level, String name) {
//	        // 지역 ID, 레벨, 이름 기준으로 감정 포인트 조회
//	        if (regionId != null) {
//	            return emotionPointRepository.findByRegionId(regionId);
//	        } else if (level != null && name != null) {
//	            return emotionPointRepository.findByRegionLevelAndRegionKoreanNameContaining(level, name);
//	        } else 
//	            // 필터 없이 전체 조회 (기본값)
//	            return emotionPointRepository.findAll();
//	        }
//	    }
//	    
//	    public EmotionPoint saveEmotionPoint(EmotionPoint emotionPoint) {
//	        // 새로운 감정 포인트 저장
//	        return emotionPointRepository.save(emotionPoint);
//	    }
//	    
//	    // 특정 지역의 감정 태그 통계 계산 (예: "신남": 5, "고요": 2)
//	    private Map<String, Integer> calculateEmotionSummary(Long regionId) {
//	        List<EmotionPoint> points = emotionPointRepository.findByRegionId(regionId);
//	        
//	        Map<String, Integer> emotionCounts = new HashMap<>();
//	        for (EmotionPoint point : points) {
//	            String emotionTag = point.getEmotionTag();
//	            emotionCounts.put(emotionTag, emotionCounts.getOrDefault(emotionTag, 0) + 1);
//	        }
//	        
//	        return emotionCounts;
//	    }
}
