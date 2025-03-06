package com.sample;

import javax.money.MonetaryAmount;


public record OrderRequest(MonetaryAmount amount) {
}
