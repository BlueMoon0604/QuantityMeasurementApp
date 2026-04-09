package com.spring.measurementservice.service;

import org.springframework.stereotype.Service;

import com.spring.measurementservice.dto.QuantityDTO;
import com.spring.measurementservice.dto.QuantityInputDTO;
import com.spring.measurementservice.entity.QuantityMeasurementEntity;
import com.spring.measurementservice.enums.IMeasurable;
import com.spring.measurementservice.enums.LengthUnit;
import com.spring.measurementservice.enums.TemperatureUnit;
import com.spring.measurementservice.enums.VolumeUnit;
import com.spring.measurementservice.enums.WeightUnit;
import com.spring.measurementservice.repository.QuantityMeasurementRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class QuantityMeasurementServiceImpl implements IQuantityMeasurementService {

    private final QuantityMeasurementRepository repository;

    public QuantityMeasurementServiceImpl(QuantityMeasurementRepository repository) {
        this.repository = repository;
    }

    @Override
    public QuantityMeasurementEntity compare(QuantityInputDTO input) {
        QuantityDTO thisQty = input.getThisQuantityDTO();
        QuantityDTO thatQty = input.getThatQuantityDTO();

        IMeasurable thisUnit = getUnit(thisQty.getMeasurementType(), thisQty.getUnit());
        IMeasurable thatUnit = getUnit(thatQty.getMeasurementType(), thatQty.getUnit());

        thisUnit.validateOperationSupport("COMPARE");
        thatUnit.validateOperationSupport("COMPARE");

        double thisBase = thisUnit.toBaseUnit(thisQty.getValue());
        double thatBase = thatUnit.toBaseUnit(thatQty.getValue());

        String result;
        if (Double.compare(thisBase, thatBase) == 0) {
            result = "EQUAL";
        } else if (thisBase > thatBase) {
            result = "GREATER";
        } else {
            result = "LESSER";
        }

        QuantityMeasurementEntity entity = createBaseEntity(input, "COMPARE");
        entity.setResultString(result);
        entity.setError(false);

        return repository.save(entity);
    }

    @Override
    public QuantityMeasurementEntity convert(QuantityInputDTO input) {
        QuantityDTO thisQty = input.getThisQuantityDTO();
        QuantityDTO thatQty = input.getThatQuantityDTO();

        IMeasurable thisUnit = getUnit(thisQty.getMeasurementType(), thisQty.getUnit());
        IMeasurable thatUnit = getUnit(thatQty.getMeasurementType(), thatQty.getUnit());

        thisUnit.validateOperationSupport("CONVERT");
        thatUnit.validateOperationSupport("CONVERT");

        double baseValue = thisUnit.toBaseUnit(thisQty.getValue());
        double convertedValue = thatUnit.fromBaseUnit(baseValue);

        QuantityMeasurementEntity entity = createBaseEntity(input, "CONVERT");
        entity.setResultValue(convertedValue);
        entity.setResultUnit(thatQty.getUnit());
        entity.setError(false);

        return repository.save(entity);
    }

    @Override
    public QuantityMeasurementEntity add(QuantityInputDTO input) {
        QuantityDTO thisQty = input.getThisQuantityDTO();
        QuantityDTO thatQty = input.getThatQuantityDTO();

        IMeasurable thisUnit = getUnit(thisQty.getMeasurementType(), thisQty.getUnit());
        IMeasurable thatUnit = getUnit(thatQty.getMeasurementType(), thatQty.getUnit());

        thisUnit.validateOperationSupport("ADD");
        thatUnit.validateOperationSupport("ADD");

        double thisBase = thisUnit.toBaseUnit(thisQty.getValue());
        double thatBase = thatUnit.toBaseUnit(thatQty.getValue());

        double resultBase = thisBase + thatBase;
        double resultValue = thisUnit.fromBaseUnit(resultBase);

        QuantityMeasurementEntity entity = createBaseEntity(input, "ADD");
        entity.setResultValue(resultValue);
        entity.setResultUnit(thisQty.getUnit());
        entity.setError(false);

        return repository.save(entity);
    }

    @Override
    public QuantityMeasurementEntity subtract(QuantityInputDTO input) {
        QuantityDTO thisQty = input.getThisQuantityDTO();
        QuantityDTO thatQty = input.getThatQuantityDTO();

        IMeasurable thisUnit = getUnit(thisQty.getMeasurementType(), thisQty.getUnit());
        IMeasurable thatUnit = getUnit(thatQty.getMeasurementType(), thatQty.getUnit());

        thisUnit.validateOperationSupport("SUBTRACT");
        thatUnit.validateOperationSupport("SUBTRACT");

        double thisBase = thisUnit.toBaseUnit(thisQty.getValue());
        double thatBase = thatUnit.toBaseUnit(thatQty.getValue());

        double resultBase = thisBase - thatBase;
        double resultValue = thisUnit.fromBaseUnit(resultBase);

        QuantityMeasurementEntity entity = createBaseEntity(input, "SUBTRACT");
        entity.setResultValue(resultValue);
        entity.setResultUnit(thisQty.getUnit());
        entity.setError(false);

        return repository.save(entity);
    }

    @Override
    public QuantityMeasurementEntity multiply(QuantityInputDTO input) {
        QuantityDTO thisQty = input.getThisQuantityDTO();
        QuantityDTO thatQty = input.getThatQuantityDTO();

        IMeasurable thisUnit = getUnit(thisQty.getMeasurementType(), thisQty.getUnit());
        IMeasurable thatUnit = getUnit(thatQty.getMeasurementType(), thatQty.getUnit());

        thisUnit.validateOperationSupport("MULTIPLY");
        thatUnit.validateOperationSupport("MULTIPLY");

        double thisBase = thisUnit.toBaseUnit(thisQty.getValue());
        double thatBase = thatUnit.toBaseUnit(thatQty.getValue());

        double result = thisBase * thatBase;

        QuantityMeasurementEntity entity = createBaseEntity(input, "MULTIPLY");
        entity.setResultValue(result);
        entity.setResultUnit("SQUARE_UNIT");
        entity.setError(false);

        return repository.save(entity);
    }

    @Override
    public QuantityMeasurementEntity divide(QuantityInputDTO input) {
        QuantityDTO thisQty = input.getThisQuantityDTO();
        QuantityDTO thatQty = input.getThatQuantityDTO();

        IMeasurable thisUnit = getUnit(thisQty.getMeasurementType(), thisQty.getUnit());
        IMeasurable thatUnit = getUnit(thatQty.getMeasurementType(), thatQty.getUnit());

        thisUnit.validateOperationSupport("DIVIDE");
        thatUnit.validateOperationSupport("DIVIDE");

        double thisBase = thisUnit.toBaseUnit(thisQty.getValue());
        double thatBase = thatUnit.toBaseUnit(thatQty.getValue());

        if (thatBase == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }

        double result = thisBase / thatBase;

        QuantityMeasurementEntity entity = createBaseEntity(input, "DIVIDE");
        entity.setResultValue(result);
        entity.setResultUnit("RATIO");
        entity.setError(false);

        return repository.save(entity);
    }

    @Override
    public List<QuantityMeasurementEntity> getHistoryByType(String type) {
        return repository.findByThisMeasurementType(type);
    }

    @Override
    public List<QuantityMeasurementEntity> getHistoryByOperation(String operation) {
        return repository.findByOperation(operation);
    }

    @Override
    public long getOperationCount(String operation) {
        return repository.countByOperationAndErrorFalse(operation);
    }

    private QuantityMeasurementEntity createBaseEntity(QuantityInputDTO input, String operation) {
        QuantityDTO thisQty = input.getThisQuantityDTO();
        QuantityDTO thatQty = input.getThatQuantityDTO();

        QuantityMeasurementEntity entity = new QuantityMeasurementEntity();

        entity.setUserEmail(input.getUserEmail());
        entity.setUserName(input.getUserName());

        entity.setThisValue(thisQty.getValue());
        entity.setThisUnit(thisQty.getUnit());
        entity.setThisMeasurementType(thisQty.getMeasurementType());

        entity.setThatValue(thatQty.getValue());
        entity.setThatUnit(thatQty.getUnit());
        entity.setThatMeasurementType(thatQty.getMeasurementType());

        entity.setOperation(operation);
        entity.setCreatedAt(LocalDateTime.now());
        entity.setError(false);

        return entity;
    }

    private IMeasurable getUnit(String measurementType, String unit) {
        if (measurementType == null || unit == null) {
            throw new IllegalArgumentException("Measurement type and unit must not be null");
        }

        return switch (measurementType.toUpperCase()) {
            case "LENGTH" -> LengthUnit.valueOf(unit.toUpperCase());
            case "WEIGHT" -> WeightUnit.valueOf(unit.toUpperCase());
            case "VOLUME" -> VolumeUnit.valueOf(unit.toUpperCase());
            case "TEMPERATURE" -> TemperatureUnit.valueOf(unit.toUpperCase());
            default -> throw new IllegalArgumentException("Unsupported measurement type: " + measurementType);
        };
    }
}