package com.sample;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.springframework.lang.NonNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private LocalDateTime date;
    @NonNull
    private BigDecimal amount;
    @NonNull
    private Boolean paid;

    public Order() {
    }

    public Order(@NonNull LocalDateTime date, @NonNull BigDecimal amount, @NonNull Boolean paid) {
        this.date = date;
        this.amount = amount;
        this.paid = paid;
    }

    public Long getId() {
        return id;
    }

    public @NonNull LocalDateTime getDate() {
        return date;
    }

    public void setDate(@NonNull LocalDateTime date) {
        this.date = date;
    }

    public @NonNull BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(@NonNull BigDecimal amount) {
        this.amount = amount;
    }

    public void setPaid(@NonNull Boolean paid) {
        this.paid = paid;
    }

    public boolean isPaid() {
        return paid;
    }

    public Order markPaid() {
        paid = true;
        return this;
    }
}
