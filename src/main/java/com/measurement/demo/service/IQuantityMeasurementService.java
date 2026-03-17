package com.measurement.demo.service;

import com.measurement.demo.dto.QuantityInputDTO;
import com.measurement.demo.entity.QuantityMeasurementEntity;

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