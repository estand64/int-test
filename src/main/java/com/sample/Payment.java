package com.sample;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import org.springframework.lang.NonNull;

@Entity
public class Payment {
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    @NonNull
    private Order order;
    @NonNull
    private String creditCardNumber;

    public Payment() {
    }

    public Payment(@NonNull Order order, @NonNull String creditCardNumber) {
        this.order = order;
        this.creditCardNumber = creditCardNumber;
    }

    public Long getId() {
        return id;
    }

    public @NonNull Order getOrder() {
        return order;
    }

    public void setOrder(@NonNull Order order) {
        this.order = order;
    }

    public @NonNull String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(@NonNull String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }
}
