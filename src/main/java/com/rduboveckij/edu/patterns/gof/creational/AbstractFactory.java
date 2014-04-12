package com.rduboveckij.edu.patterns.gof.creational;

import java.util.HashMap;
import java.util.Map;

/**
 * author: Ruslan Duboveckij
 */
public class AbstractFactory {
    public static interface BaseVehicle {
        String getMessage();
    }

    public static class VehicleFactory {
        private final static Map<String, BaseVehicle> vehicles = new HashMap<>();

        static {
            vehicles.put("car", () -> "I am car");
            vehicles.put("airplane", () -> "I am airplane");
        }

        public static BaseVehicle getVehicle(String name) throws Exception {
            final BaseVehicle vehicle = vehicles.get(name);
            if (vehicle == null) throw new Exception("Not found vehicle with name: " + name);
            return vehicle;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(VehicleFactory.getVehicle("car").getMessage());
        System.out.println(VehicleFactory.getVehicle("airplane").getMessage());
        System.out.println(VehicleFactory.getVehicle("not found name").getMessage());
    }
}
