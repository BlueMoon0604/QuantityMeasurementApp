package com.feetmeasurement;

public class QuantityMeasurementApp {
    public static void main(String[] args) {
        Feet f1 = new Feet(1.0);
        Feet f2 = new Feet(1.0);
        boolean result = f1.equals(f2);

        if(result) {
            System.out.println("Equal (true)");
        }else {
 
        	System.out.println("Not Equal (false)");
        }
    }
        
}
