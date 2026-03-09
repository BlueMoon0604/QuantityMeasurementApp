package com.feetmeasurement.repository;

import java.util.ArrayList;
import java.util.List;

import com.feetmeasurement.entity.QuantityMeasurementEntity;

public class QuantityMeasurementCacheRepository implements IQuantityMeasurementRepository {
    private static QuantityMeasurementCacheRepository instance;
    private List<QuantityMeasurementEntity> cache;

    private QuantityMeasurementCacheRepository() {
        cache = new ArrayList<>();
    }

    public static QuantityMeasurementCacheRepository getInstance() {
        if (instance == null) instance = new QuantityMeasurementCacheRepository();
        return instance;
    }

    public void save(QuantityMeasurementEntity entity) { cache.add(entity); }

    public List<QuantityMeasurementEntity> findAll() { return cache; }
}
