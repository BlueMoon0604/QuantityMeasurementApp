package com.feetmeasurement;

public class Quantity<U extends Enum<U> & IMeasurable> {

    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }
    private enum ArithmeticOperation {
        ADD((a, b) -> a + b),
        SUBTRACT((a, b) -> a - b),
        DIVIDE((a, b) -> {
            if (b == 0) throw new ArithmeticException("Division by zero");
            return a / b;
        });

        private final java.util.function.DoubleBinaryOperator operator;

        ArithmeticOperation(java.util.function.DoubleBinaryOperator operator) {
            this.operator = operator;
        }

        double compute(double a, double b) {
            return operator.applyAsDouble(a, b);
        }
    }
    private double performBaseArithmetic(Quantity<U> other, ArithmeticOperation op) {
        validateArithmeticOperands(other);
        double thisBase = unit.convertToBaseUnit(value);
        double otherBase = other.unit.convertToBaseUnit(other.value);
        return op.compute(thisBase, otherBase);
    }

    private void validateArithmeticOperands(Quantity<U> other) {
        if (other == null) {
            throw new IllegalArgumentException("Operand cannot be null");
        }
        if (!unit.getClass().equals(other.unit.getClass())) {
            throw new IllegalArgumentException("Units are not of the same category");
        }
        if (Double.isNaN(value) || Double.isInfinite(value) ||
            Double.isNaN(other.value) || Double.isInfinite(other.value)) {
            throw new IllegalArgumentException("Values must be finite numbers");
        }
    }
    public Quantity<U> add(Quantity<U> other) {
        double baseResult = performBaseArithmetic(other, ArithmeticOperation.ADD);
        double result = unit.convertFromBaseUnit(baseResult);
        return new Quantity<>(round(result), unit);
    }

    public Quantity<U> subtract(Quantity<U> other) {
        double baseResult = performBaseArithmetic(other, ArithmeticOperation.SUBTRACT);
        double result = unit.convertFromBaseUnit(baseResult);
        return new Quantity<>(round(result), unit);
    }

    public double divide(Quantity<U> other) {
        return performBaseArithmetic(other, ArithmeticOperation.DIVIDE);
    }
    public Quantity<U> convertTo(U targetUnit) {
        double base = unit.convertToBaseUnit(value);
        double converted = targetUnit.convertFromBaseUnit(base);
        return new Quantity<>(round(converted), targetUnit);
    }
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Quantity)) {
        	return false;
        }
        Quantity<?> other = (Quantity<?>) obj;
        if (!unit.getClass().equals(other.unit.getClass())) {
        	return false;
        }
        double base1 = unit.convertToBaseUnit(value);
        double base2 = other.unit.convertToBaseUnit(other.value);
        return Math.abs(base1 - base2) < 0.0001;
    }

    @Override
    public String toString() {
        return value + " " + unit.getUnitName();
    }
    private double round(double val) {
        return Math.round(val * 100.0) / 100.0;
    }
}