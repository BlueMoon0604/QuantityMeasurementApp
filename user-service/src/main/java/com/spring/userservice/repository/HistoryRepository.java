package com.spring.userservice.repository;


import com.spring.userservice.entity.ConversionHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoryRepository extends JpaRepository<ConversionHistory, Long> {
    List<ConversionHistory> findByUserIdOrderByTimestampDesc(Long userId);
}
