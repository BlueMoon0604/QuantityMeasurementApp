package com.spring.measurementservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.measurementservice.entity.QuantityMeasurementEntity;

@Repository
public interface QuantityMeasurementRepository extends JpaRepository<QuantityMeasurementEntity, Long> {

    List<QuantityMeasurementEntity> findByOperation(String operation);

    List<QuantityMeasurementEntity> findByThisMeasurementType(String measurementType);

    long countByOperationAndErrorFalse(String operation);

    List<QuantityMeasurementEntity> findByErrorTrue();

    List<QuantityMeasurementEntity> findByUserEmail(String userEmail);

    long countByUserEmail(String userEmail);

    long countByUserEmailAndOperation(String userEmail, String operation);

    List<QuantityMeasurementEntity> findByUserEmailAndOperation(String userEmail, String operation);
}