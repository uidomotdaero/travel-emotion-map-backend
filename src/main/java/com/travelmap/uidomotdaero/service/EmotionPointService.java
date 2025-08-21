package com.travelmap.uidomotdaero.service;

import java.util.List;
import java.util.Map;

public interface EmotionPointService {
	
	List<Map<String, Object>> getAllRegions();
	List<Map<String, Object>> getRegionsByParent(Long parentId);
	

}
