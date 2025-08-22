package com.travelmap.uidomotdaero.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.travelmap.uidomotdaero.vo.TravelEmotionLog;

@Repository
public interface TravelEmotionRepository extends JpaRepository<TravelEmotionLog, Long> {
    
    // 커스텀 쿼리 - 위치 기반 검색
    @Query(value = 
    		"SELECT *, e.me_name, e.weather_condition FROM TRAVEL_EMOTION_LOG e " +
    		        "WHERE " +
    		        "  (6371 * acos(cos(radians(CAST(:latitude AS double precision))) * cos(radians(CAST(e.LATITUDE AS double precision))) * " +
    		        "  cos(radians(CAST(e.LONGITUDE AS double precision)) - radians(CAST(:longitude AS double precision))) + " +
    		        "  sin(radians(CAST(:latitude AS double precision))) * sin(radians(CAST(e.LATITUDE AS double precision))))) <= :radius " +
    		        "ORDER BY " +
    		        "  (6371 * acos(cos(radians(CAST(:latitude AS double precision))) * cos(radians(CAST(e.LATITUDE AS double precision))) * " +
    		        "  cos(radians(CAST(e.LONGITUDE AS double precision)) - radians(CAST(:longitude AS double precision))) + " +
    		        "  sin(radians(CAST(:latitude AS double precision))) * sin(radians(CAST(e.LATITUDE AS double precision)))))",
        nativeQuery = true)
    List<TravelEmotionLog> findByLocationNear(
        @Param("latitude") Double latitude, 
        @Param("longitude") Double longitude, 
        @Param("radius") Double radiusInKm);
}