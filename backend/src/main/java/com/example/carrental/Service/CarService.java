package com.example.carrental.Service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.carrental.model.Car;
import com.example.carrental.Repository.CarRepository;


@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    public List<Car> getAllCars() {
        return carRepository.findAll(); // Ensure this method exists
    }
    public Car getCarById(String carId) {
        return carRepository.findById(carId).orElse(null); // Ensure this method exists
    }
    
    public void deleteCar(String carId) {
        carRepository.deleteById(carId); // Ensure this method exists
    }

    public Car updateCarPrice(String carId, double newPrice) {
        Car car = carRepository.findById(carId)
                .orElseThrow(() -> new RuntimeException("Car not found with id: " + carId));
        car.setPricePerDay(newPrice);
        return carRepository.save(car);
    }

    public Car cloneCar(String carId) {
        Car originalCar = carRepository.findById(carId)
                .orElseThrow(() -> new RuntimeException("Car not found with id: " + carId));
        Car clonedCar = originalCar.clone(); // Use the clone method from the Car class
        clonedCar.setBookings(new ArrayList<>()); // Clear bookings for the cloned car
        clonedCar.setId(null); // Set ID to null to create a new entry in the database
        carRepository.save(clonedCar);
        return clonedCar;
    }
}
