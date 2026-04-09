package com.spring.measurementservice.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.spring.measurementservice.dto.QuantityInputDTO;
import com.spring.measurementservice.entity.QuantityMeasurementEntity;
import com.spring.measurementservice.service.IQuantityMeasurementService;
import com.spring.measurementservice.repository.QuantityMeasurementRepository;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/quantities")
public class QuantityMeasurementController {

    @Autowired
    private IQuantityMeasurementService service;

    @Autowired
    private QuantityMeasurementRepository repository;
    @PostMapping("/compare")
    public QuantityMeasurementEntity compare(@Valid @RequestBody QuantityInputDTO input) {
        return service.compare(input);
    }

    @PostMapping("/convert")
    public QuantityMeasurementEntity convert(@Valid @RequestBody QuantityInputDTO input) {
        return service.convert(input);
    }

    @PostMapping("/add")
    public QuantityMeasurementEntity add(@Valid @RequestBody QuantityInputDTO input) {
        return service.add(input);
    }

    @PostMapping("/divide")
    public QuantityMeasurementEntity divide(@Valid @RequestBody QuantityInputDTO input) {
        return service.divide(input);
    }

    @PostMapping("/subtract")
    public QuantityMeasurementEntity subtract(@Valid @RequestBody QuantityInputDTO input) {
        return service.subtract(input);
    }

    @PostMapping("/multiply")
    public QuantityMeasurementEntity multiply(@Valid @RequestBody QuantityInputDTO input) {
        return service.multiply(input);
    }

    @GetMapping("/history/type/{type}")
    public List<QuantityMeasurementEntity> getHistoryByType(@PathVariable String type) {
        return service.getHistoryByType(type);
    }

    @GetMapping("/history/operation/{operation}")
    public List<QuantityMeasurementEntity> getHistoryByOperation(@PathVariable String operation) {
        return service.getHistoryByOperation(operation);
    }

    @GetMapping("/count/{operation}")
    public long getCount(@PathVariable String operation) {
        return service.getOperationCount(operation);
    }
    @GetMapping("/history/my")
    public List<QuantityMeasurementEntity> getMyHistory(@RequestParam String userEmail) {
        return repository.findByUserEmail(userEmail);
    }

    @GetMapping("/history/my/count")
    public long getMyTotalCount(@RequestParam String userEmail) {
        return repository.countByUserEmail(userEmail);
    }

    @GetMapping("/history/my/count/{operation}")
    public long getMyOperationCount(@RequestParam String userEmail,
                                   @PathVariable String operation) {
        return repository.countByUserEmailAndOperation(userEmail, operation.toUpperCase());
    }

    @GetMapping("/history/my/{operation}")
    public List<QuantityMeasurementEntity> getMyOperationHistory(@RequestParam String userEmail,
                                                                 @PathVariable String operation) {
        return repository.findByUserEmailAndOperation(userEmail, operation.toUpperCase());
    }

    @GetMapping("/history/my/summary")
    public Map<String, Object> getMySummary(@RequestParam String userEmail) {

        long total = repository.countByUserEmail(userEmail);

        long add = repository.countByUserEmailAndOperation(userEmail, "ADD");
        long subtract = repository.countByUserEmailAndOperation(userEmail, "SUBTRACT");
        long multiply = repository.countByUserEmailAndOperation(userEmail, "MULTIPLY");
        long divide = repository.countByUserEmailAndOperation(userEmail, "DIVIDE");
        long compare = repository.countByUserEmailAndOperation(userEmail, "COMPARE");
        long convert = repository.countByUserEmailAndOperation(userEmail, "CONVERT");

        return Map.of(
                "userEmail", userEmail,
                "totalOperations", total,
                "ADD", add,
                "SUBTRACT", subtract,
                "MULTIPLY", multiply,
                "DIVIDE", divide,
                "COMPARE", compare,
                "CONVERT", convert
        );
    }
}