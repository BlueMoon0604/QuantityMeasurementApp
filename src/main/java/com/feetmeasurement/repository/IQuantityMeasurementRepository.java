package com.feetmeasurement.repository;

import java.util.List;

import com.feetmeasurement.entity.QuantityMeasurementEntity;

public interface IQuantityMeasurementRepository {
    void save(QuantityMeasurementEntity entity);
    List<QuantityMeasurementEntity> findAll();
}