// ./carrental/factory/CarFactory.java
package com.example.carrental.factory;

import com.example.carrental.model.Car;

/**
 * Interface for creating Car objects.
 * Decouples car creation logic from services.
 */
public interface CarFactory {
    /**
     * Creates a new Car instance.
     *
     * @param model The model name of the car.
     * @param pricePerHour The rental price per hour (or day, check consistency).
     * @param image URL or identifier for the car's image.
     * @return A new Car object, ready to be saved.
     */
    Car createCar(String model, double pricePerHour, String image);
}