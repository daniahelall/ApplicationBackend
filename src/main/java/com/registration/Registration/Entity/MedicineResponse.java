package com.registration.Registration.Entity;


public class MedicineResponse {


    private String message;
    private boolean isExpired;
    private Medicine medicine;

    // Constructor
    public MedicineResponse(String message, boolean isExpired, Medicine medicine) {
        this.message = message;
        this.isExpired = isExpired;
        this.medicine = medicine;
    }

    // Getters and Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isExpired() {
        return isExpired;
    }

    public void setExpired(boolean expired) {
        isExpired = expired;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    // Optional: toString method for logging purposes
    @Override
    public String toString() {
        return "MedicineResponse{" +
                "message='" + message + '\'' +
                ", isExpired=" + isExpired +
                ", medicine=" + medicine +
                '}';
    }
}


