package com.example.carrental.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
// import com.example.carrental.model.Rental;
import java.util.List;

@Document(collection = "cars")
public class Car implements Cloneable {
    @Id
    private String id;
    private String model;
    private List<Rental> bookings;
    
    private double pricePerHour;
    private String image;

    public Car() {}

    public Car(String model,List<Rental> bookings,  double pricePerHour,String image) {
        this.model = model;
        this.bookings=bookings;
        this.pricePerHour = pricePerHour;
        this.image=image;

    }

    public String getId() { return id; }
    public String getModel() { return model; }
    public List<Rental> getBookings(){ return bookings;}
    public double getPricePerDay() { return pricePerHour; }
    public String getImage(){ return image;}

    public void setId(String id) { this.id = id; }
    public void setModel(String model) { this.model = model; }
    public void setBookings(List<Rental> bookings){ this.bookings=bookings;}
    public void setImage(String image){ this.image=image;}
    public void setPricePerDay(double pricePerHour) { this.pricePerHour = pricePerHour;}

    @Override
    public Car clone() {
        try {
            Car cloned = (Car) super.clone();
            // Note: Shallow copy – bookings list is shared!
            // For deep copy: clone each Rental object if needed
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Cloning failed", e);
        }
    }

}
