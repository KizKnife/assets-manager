package com.pluralsight;

import java.time.Year;

public class Vehicle extends Asset {
    private String makeModel;
    private int year;
    private int odometer;

    public Vehicle(String description, String dateAcquired, double originalCost) {
        super(description, dateAcquired, originalCost);
    }

    public Vehicle(String description, String dateAcquired, double originalCost, String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    @Override
    public double getValue() {
        int currentYear = Year.now().getValue();
        int age = currentYear - this.year;

        double value = getOriginalCost();

        if (age <= 3) {
            // 0-3 years old - 3% reduced value of cost per year
            value = value * (.03 * age);
        }
        else if (age <= 6) {
            // 4-6 years old - 6% reduced value of cost per year
            value = value * (.6 * age);
        }
        else if (age <= 10) {
            // 7-10 years old - 8% reduced value of cost per year
            value = value * (.8 * age);
        }
        else {
            // over 10 years old - $1000.00
            value = 1000;
        }

        // MINUS reduce final value by 25% if over 100,000 miles
        // unless makeModel contains word Honda or Toyota
        if (
                odometer > 1000000 &&
                !makeModel.toLowerCase().contains("honda") &&
                !makeModel.toLowerCase().contains("toyota")) {
            value *= .75;
        }

        return value;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }
}
