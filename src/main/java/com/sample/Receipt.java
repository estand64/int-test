package com.sample;

import javax.money.MonetaryAmount;
import java.time.LocalDateTime;

public record Receipt(LocalDateTime date, String creditCardNumber, MonetaryAmount amount) {
}
