package com.feetmeasurement;

import com.feetmeasurement.controller.QuantityMeasurementController;
import com.feetmeasurement.dto.QuantityDTO;
import com.feetmeasurement.repository.IQuantityMeasurementRepository;
import com.feetmeasurement.repository.QuantityMeasurementCacheRepository;
import com.feetmeasurement.service.QuantityMeasurementServiceImpl;
import com.feetmeasurement.service.IQuantityMeasurementService;

public class QuantityMeasurementApp {

    public static void main(String[] args) {
        IQuantityMeasurementRepository repository = QuantityMeasurementCacheRepository.getInstance();
        IQuantityMeasurementService service = new QuantityMeasurementServiceImpl(repository);
        QuantityMeasurementController controller = new QuantityMeasurementController(service);

        System.out.println("=== Quantity Measurement Application ===");
        QuantityDTO<LengthUnit> length1 = new QuantityDTO<>(5.0, LengthUnit.FEET);
        QuantityDTO<LengthUnit> length2 = new QuantityDTO<>(60.0, LengthUnit.INCH);

        QuantityDTO<LengthUnit> compareResult = controller.performCompare(length1, length2);
        System.out.println("Compare Result: " + compareResult.getValue());

        QuantityDTO<WeightUnit> weight1 = new QuantityDTO<>(2.0, WeightUnit.KILOGRAM);
        QuantityDTO<WeightUnit> weight2 = new QuantityDTO<>(500.0, WeightUnit.GRAM);

        QuantityDTO<WeightUnit> addResult = controller.performAdd(weight1, weight2);
        System.out.println("Addition Result: " + addResult.getValue() + " " + addResult.getUnit().getUnitName());

        QuantityDTO<LengthUnit> lengthInMeters = controller.performConvert(length1, LengthUnit.METER);
        System.out.println("Conversion Result: " + lengthInMeters.getValue() + " " + lengthInMeters.getUnit().getUnitName());

        QuantityDTO<LengthUnit> subtractResult = controller.performSubtract(length1, length2);
        System.out.println("Subtraction Result: " + subtractResult.getValue() + " " + subtractResult.getUnit().getUnitName());

        QuantityDTO<LengthUnit> divideResult = controller.performDivide(length1, length2);
        System.out.println("Division Result: " + divideResult.getValue());
    }
}