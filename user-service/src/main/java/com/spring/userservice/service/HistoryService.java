package com.spring.userservice.service;

import com.spring.userservice.dto.ConversionHistoryRequest;
import com.spring.userservice.dto.ConversionHistoryResponse;
import com.spring.userservice.entity.ConversionHistory;
import com.spring.userservice.repository.HistoryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class HistoryService {

    private final HistoryRepository historyRepository;

    public HistoryService(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    public ConversionHistoryResponse saveHistory(Long userId, ConversionHistoryRequest request) {
        ConversionHistory history = new ConversionHistory();
        history.setUserId(userId);
        history.setType(request.getType());
        history.setFromUnit(request.getFromUnit());
        history.setToUnit(request.getToUnit());
        history.setInputValue(request.getInputValue());
        history.setOutputValue(request.getOutputValue());
        history.setTimestamp(LocalDateTime.now());

        ConversionHistory saved = historyRepository.save(history);
        return mapToResponse(saved);
    }

    public List<ConversionHistoryResponse> getUserHistory(Long userId) {
        return historyRepository.findByUserIdOrderByTimestampDesc(userId)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    private ConversionHistoryResponse mapToResponse(ConversionHistory history) {
        return new ConversionHistoryResponse(
                history.getId(),
                history.getUserId(),
                history.getType(),
                history.getFromUnit(),
                history.getToUnit(),
                history.getInputValue(),
                history.getOutputValue(),
                history.getTimestamp()
        );
    }
}