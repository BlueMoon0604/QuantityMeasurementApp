package com.spring.measurementservice.service;



import com.spring.measurementservice.dto.QuantityInputDTO;
import com.spring.measurementservice.entity.QuantityMeasurementEntity;

import java.util.List;

public interface IQuantityMeasurementService {

    QuantityMeasurementEntity add(QuantityInputDTO input);
    QuantityMeasurementEntity subtract(QuantityInputDTO input);
    QuantityMeasurementEntity multiply(QuantityInputDTO input);
    QuantityMeasurementEntity divide(QuantityInputDTO input);
    QuantityMeasurementEntity compare(QuantityInputDTO input);
    QuantityMeasurementEntity convert(QuantityInputDTO input);

    List<QuantityMeasurementEntity> getHistoryByOperation(String operation);
    List<QuantityMeasurementEntity> getHistoryByType(String type);
    long getOperationCount(String operation);
}