package com.registration.Registration.Entity;

import jakarta.persistence.*;
@Entity
@Table(name = "user_medicine")
public class UserMedicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "barcode", referencedColumnName = "barcode")
    private Medicine medicine;

    public UserMedicine() {}

    public UserMedicine(User user, Medicine medicine) {
        this.user = user;
        this.medicine = medicine;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }
}
