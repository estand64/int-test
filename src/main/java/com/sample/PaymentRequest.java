package com.sample;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.CreditCardNumber;

public record PaymentRequest(@NotNull @CreditCardNumber String creditCardNumber) {
}
