package com.feetmeasurement;


import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.feetmeasurement.controller.QuantityMeasurementController;
import com.feetmeasurement.dto.QuantityDTO;
import com.feetmeasurement.entity.QuantityMeasurementEntity;
import com.feetmeasurement.quantity.Quantity;
import com.feetmeasurement.repository.QuantityMeasurementCacheRepository;
import com.feetmeasurement.service.QuantityMeasurementServiceImpl;
import com.feetmeasurement.unit.LengthUnit;
import com.feetmeasurement.unit.TemperatureUnit;
import com.feetmeasurement.unit.VolumeUnit;
import com.feetmeasurement.unit.WeightUnit;

public class QuantityMeasurementAppTest {

    private QuantityMeasurementCacheRepository cacheRepository;
    private QuantityMeasurementServiceImpl service;
    private QuantityMeasurementController controller;

    @BeforeEach
    void setUp() {
        cacheRepository = new QuantityMeasurementCacheRepository();
        cacheRepository.deleteAll();
        service = new QuantityMeasurementServiceImpl(cacheRepository);
        controller = new QuantityMeasurementController(service);
    }

    // UC1, UC2, UC3, UC4
    @Test
    void shouldCreateAndCompareLengthQuantities() {
        Quantity<LengthUnit> q1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(12.0, LengthUnit.INCH);

        assertEquals(1.0, q1.getValue(), 0.0001);
        assertEquals(LengthUnit.FEET, q1.getUnit());
        assertEquals(q1, q2);
        assertNotEquals(q1, null);
        assertNotEquals(q1, "hello");
    }

    // UC4
    @Test
    void shouldCheckWeightAndVolumeEquality() {
        Quantity<WeightUnit> weight1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> weight2 = new Quantity<>(1000.0, WeightUnit.GRAM);

        Quantity<VolumeUnit> volume1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> volume2 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        assertEquals(weight1, weight2);
        assertEquals(volume1, volume2);
    }

    // UC5
    @Test
    void shouldConvertQuantitiesCorrectly() {
        Quantity<LengthUnit> length = new Quantity<>(2.0, LengthUnit.FEET);
        Quantity<WeightUnit> weight = new Quantity<>(2.0, WeightUnit.KILOGRAM);
        Quantity<VolumeUnit> volume = new Quantity<>(1.0, VolumeUnit.GALLON);

        assertEquals(24.0, length.convertTo(LengthUnit.INCH).getValue(), 0.0001);
        assertEquals(2000.0, weight.convertTo(WeightUnit.GRAM).getValue(), 0.0001);
        assertEquals(3.7854, volume.convertTo(VolumeUnit.LITRE).getValue(), 0.01);
    }

    // UC6, UC7, UC10, UC11, UC12
    @Test
    void shouldPerformLengthOperations() {
        Quantity<LengthUnit> q1 = new Quantity<>(3.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(12.0, LengthUnit.INCH);

        assertEquals(4.0, q1.add(q2).getValue(), 0.0001);
        assertEquals(2.0, q1.subtract(q2).getValue(), 0.0001);
        assertNotNull(q1.divide(new Quantity<>(1.0, LengthUnit.FEET)));

        assertThrows(ArithmeticException.class, () ->
                q1.divide(new Quantity<>(0.0, LengthUnit.FEET)));

        assertThrows(IllegalArgumentException.class, () -> q1.add(null));
        assertThrows(IllegalArgumentException.class, () -> q1.subtract(null));
    }

    // UC7 and UC10
    @Test
    void shouldPerformWeightAndVolumeOperations() {
        Quantity<WeightUnit> weight1 = new Quantity<>(2.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> weight2 = new Quantity<>(500.0, WeightUnit.GRAM);

        Quantity<VolumeUnit> volume1 = new Quantity<>(2.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> volume2 = new Quantity<>(500.0, VolumeUnit.MILLILITRE);

        assertEquals(2.5, weight1.add(weight2).getValue(), 0.0001);
        assertEquals(1.5, weight1.subtract(weight2).getValue(), 0.0001);

        assertEquals(2.5, volume1.add(volume2).getValue(), 0.0001);
        assertEquals(1.5, volume1.subtract(volume2).getValue(), 0.0001);
    }

    // UC8, UC9
    @Test
    void shouldHandleTemperatureRules() {
        Quantity<TemperatureUnit> tempC = new Quantity<>(0.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> tempF = new Quantity<>(32.0, TemperatureUnit.FAHRENHEIT);

        assertEquals(tempC, tempF);

        assertThrows(UnsupportedOperationException.class, () ->
                tempC.add(new Quantity<>(10.0, TemperatureUnit.CELSIUS)));

        assertThrows(UnsupportedOperationException.class, () ->
                tempC.divide(new Quantity<>(10.0, TemperatureUnit.CELSIUS)));
    }

    // UC13
    @Test
    void shouldCreateEntityCorrectly() {
        QuantityMeasurementEntity entity = new QuantityMeasurementEntity(
                1.0, 12.0, "FEET", "INCH", "ADD", 2.0
        );

        assertEquals(1.0, entity.getOperand1(), 0.0001);
        assertEquals(12.0, entity.getOperand2(), 0.0001);
        assertEquals("FEET", entity.getUnit1());
        assertEquals("INCH", entity.getUnit2());
        assertEquals("ADD", entity.getOperation());
        assertEquals(2.0, entity.getResult(), 0.0001);
        assertFalse(entity.hasError());
    }

    // UC13
    @Test
    void shouldCreateErrorEntityCorrectly() {
        QuantityMeasurementEntity entity = new QuantityMeasurementEntity("Invalid operation");

        assertTrue(entity.hasError());
        assertEquals("Invalid operation", entity.getErrorMessage());
    }

    // UC14
    @Test
    void shouldUseServiceForOperations() {
        QuantityDTO<LengthUnit> q1 = new QuantityDTO<>(1.0, LengthUnit.FEET);
        QuantityDTO<LengthUnit> q2 = new QuantityDTO<>(12.0, LengthUnit.INCH);

        QuantityDTO<LengthUnit> addResult = service.add(q1, q2);
        QuantityDTO<LengthUnit> convertResult = service.convert(q1, LengthUnit.INCH);

        assertEquals(2.0, addResult.getValue(), 0.0001);
        assertEquals(12.0, convertResult.getValue(), 0.0001);
    }

    // UC15
    @Test
    void shouldUseControllerForOperations() {
        QuantityDTO<VolumeUnit> q1 = new QuantityDTO<>(1.0, VolumeUnit.LITRE);
        QuantityDTO<VolumeUnit> q2 = new QuantityDTO<>(500.0, VolumeUnit.MILLILITRE);

        QuantityDTO<VolumeUnit> addResult = controller.performAdd(q1, q2);
        QuantityDTO<VolumeUnit> subtractResult = controller.performSubtract(q1, q2);

        assertEquals(1.5, addResult.getValue(), 0.0001);
        assertEquals(0.5, subtractResult.getValue(), 0.0001);
    }

    // UC16
    @Test
    void shouldStoreRecordsWhenServiceMethodsAreCalled() {
        QuantityDTO<LengthUnit> q1 = new QuantityDTO<>(5.0, LengthUnit.FEET);
        QuantityDTO<LengthUnit> q2 = new QuantityDTO<>(60.0, LengthUnit.INCH);

        service.compare(q1, q2);
        service.add(q1, q2);
        service.subtract(q1, q2);
        service.divide(q1, q2);
        service.convert(q1, LengthUnit.METER);

        List<QuantityMeasurementEntity> records = cacheRepository.findAll();

        assertEquals(5, records.size());
        assertEquals("COMPARE", records.get(0).getOperation());
        assertEquals("ADD", records.get(1).getOperation());
        assertEquals("SUBTRACT", records.get(2).getOperation());
        assertEquals("DIVIDE", records.get(3).getOperation());
        assertEquals("CONVERT", records.get(4).getOperation());
    }
}