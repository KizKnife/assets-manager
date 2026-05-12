package com.pluralsight;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Asset> Assets = new ArrayList<>();

        Assets.add(new House(
                "My house",
                "2026-05-12",
                250000,
                "123 Main St",
                1,
                2000,
                8000
        ));

        Assets.add(new House(
                "Their house",
                "2020-12-24",
                25000,
                "321 Alt Ally",
                3,
                1800,
                2000
        ));

        Assets.add(new Vehicle(
                "Tom's truck",
                "2026-05-10",
                35000,
                "Ford",
                2026,
                80
        ));

        Assets.add(new Vehicle(
                "Kiz's Car",
                "2018-06-01",
                18600,
                "Toyota",
                2018,
                76000
        ));

        for (Asset asset : Assets) {
            String message = "";

            if (asset instanceof House house) {
                message = house.getDescription() + " at " + house.getAddress();
            } else if (asset instanceof Vehicle vehicle) {
                message = "Vehicle: " + vehicle.getYear() + " " + vehicle.getMakeModel();
            }

            System.out.println(message);
        }
    }
}
