package com.company.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
//@Table(name = "contacts")
public class Contact implements Serializable {

    @Column(name = "phone", length = 11)
    private String phone;

    @Column(name = "email", length = 25)
    private String email;

    @Column(name = "address", length = 25)
    private String Address;

    @Column(name = "is_active")
    private boolean active;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", Address='" + Address + '\'' +
                ", active=" + active +
                '}';
    }
}