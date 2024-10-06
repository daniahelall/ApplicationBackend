package com.registration.Registration.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "survey")
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double temperature;
    private boolean humidityControlled;
    private boolean unopenedSealed;

    @ManyToOne
    @JoinColumn(name = "medicine_barcode", referencedColumnName = "barcode")
    private Medicine medicine;

    @OneToOne
    @JoinColumn(name = "id")
    private User user;

    private boolean eligibleForDonation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public boolean isHumidityControlled() {
        return humidityControlled;
    }

    public void setHumidityControlled(boolean humidityControlled) {
        this.humidityControlled = humidityControlled;
    }

    public boolean isUnopenedSealed() {
        return unopenedSealed;
    }

    public void setUnopenedSealed(boolean unopenedSealed) {
        this.unopenedSealed = unopenedSealed;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isEligibleForDonation() {
        return eligibleForDonation;
    }

    public void setEligibleForDonation(boolean eligibleForDonation) {
        this.eligibleForDonation = eligibleForDonation;
    }
}
