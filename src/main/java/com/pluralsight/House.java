package com.pluralsight;

public class House extends Asset {
    private String address;
    private int condition; // (1 -excellent, 2 -good, 3 -fair, 4 -poor)
    private int squareFoot;
    private int lotSize;

    public House(String description, String dateAcquired, double originalCost) {
        super(description, dateAcquired, originalCost);
    }

    public House(String description, String dateAcquired, double originalCost, String address, int condition, int squareFoot, int lotSize) {
        super(description, dateAcquired, originalCost);
        this.address = address;
        this.condition = condition;
        this.squareFoot = squareFoot;
        this.lotSize = lotSize;
    }

    @Override
    public double getValue() {
        double valuePerSquareFoot = 0;

        switch (condition) {
            case 1:
                // $180.00 per square foot (excellent)
                valuePerSquareFoot = 180;
                break;
            case 2:
                // $130.00 per square foot (good)
                valuePerSquareFoot = 130;
                break;
            case 3:
                // $90.00 per square foot (fair)
                valuePerSquareFoot = 90;
                break;
            case 4:
                // $80.00 per square foot (poor)
                valuePerSquareFoot = 80;
                break;
        }

        // PLUS 25 cents per square foot of lot size
        return (squareFoot * valuePerSquareFoot) + (lotSize * 0.25);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public int getSquareFoot() {
        return squareFoot;
    }

    public void setSquareFoot(int squareFoot) {
        this.squareFoot = squareFoot;
    }

    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }
}
