package com.travelmap.uidomotdaero.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travelmap.uidomotdaero.vo.SubscriberEmotion;

@Repository
public interface SubscriberEmotionRepository extends JpaRepository<SubscriberEmotion, Long> {
    List<SubscriberEmotion> findByIsApproved(boolean isApproved);
    List<SubscriberEmotion> findByIsApprovedOrderByCreatedDateDesc(boolean isApproved);
    List<SubscriberEmotion> findBySubmitterNameContainingIgnoreCase(String submitterName);
}
