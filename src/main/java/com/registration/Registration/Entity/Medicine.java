package com.registration.Registration.Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "medicines")
public class Medicine {

    @Id
    private String barcode;
    private String medicine_name;
    private String description;
    private String medicine_type;
    private LocalDate expiry_date;

    @OneToMany(mappedBy = "medicine")
    private List<UserMedicine> users;

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getMedicine_name() {
        return medicine_name;
    }

    public void setMedicine_name(String medicine_name) {
        this.medicine_name = medicine_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMedicine_type() {
        return medicine_type;
    }

    public void setMedicine_type(String medicine_type) {
        this.medicine_type = medicine_type;
    }

    public LocalDate getExpiry_date() {
        return expiry_date;
    }

    public void setExpiry_date(LocalDate expiry_date) {
        this.expiry_date = expiry_date;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "barcode='" + barcode + '\'' +
                ", medicine_name='" + medicine_name + '\'' +
                ", description='" + description + '\'' +
                ", medicine_type='" + medicine_type + '\'' +
                ", expiry_date=" + expiry_date +
                '}';
    }
}