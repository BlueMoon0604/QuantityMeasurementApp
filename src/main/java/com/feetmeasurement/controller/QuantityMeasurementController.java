package com.feetmeasurement.controller;

import com.feetmeasurement.IMeasurable;
import com.feetmeasurement.dto.QuantityDTO;
import com.feetmeasurement.service.IQuantityMeasurementService;

public class QuantityMeasurementController {
    private IQuantityMeasurementService service;

    public QuantityMeasurementController(IQuantityMeasurementService service) {
        this.service = service;
    }

    public <U extends IMeasurable> QuantityDTO<U> performCompare(QuantityDTO<U> q1, QuantityDTO<U> q2) {
        return service.compare(q1, q2);
    }

    public <U extends IMeasurable> QuantityDTO<U> performAdd(QuantityDTO<U> q1, QuantityDTO<U> q2) {
        return service.add(q1, q2);
    }

    public <U extends IMeasurable> QuantityDTO<U> performSubtract(QuantityDTO<U> q1, QuantityDTO<U> q2) {
        return service.subtract(q1, q2);
    }

    public <U extends IMeasurable> QuantityDTO<U> performDivide(QuantityDTO<U> q1, QuantityDTO<U> q2) {
        return service.divide(q1, q2);
    }

    public <U extends IMeasurable> QuantityDTO<U> performConvert(QuantityDTO<U> q, U targetUnit) {
        return service.convert(q, targetUnit);
    }
}