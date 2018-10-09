package pl.coderslab.models;

import java.util.Date;

public class Car {
    private int id;
    private String model;
    private String brand;
    private int year;
    private String plate;
    private Date next_check;
    private int customer_id;

    public Car (String model, String brand, int year, String plate, Date next_check, int customer_id) {
        this.model = model;
        this.brand = brand;
        this.year = year;
        this.plate = plate;
        this.next_check = next_check;
        this.customer_id = customer_id;
    }

    public Car (){

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public int getId() {
        return id;
    }

    public String getPlate() {
        return plate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getNext_check() {
        return next_check;
    }

    public void setNext_check(Date next_check) {
        this.next_check = next_check;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", year=" + year +
                ", plate='" + plate + '\'' +
                ", next_check=" + next_check +
                ", customer_id=" + customer_id +
                '}';
    }
}
