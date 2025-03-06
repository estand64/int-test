package com;

import com.sample.*;
import org.javamoney.moneta.FastMoney;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.money.Monetary;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


public class OrderServiceTest {
    private final OrderRepository orderRepository = Mockito.mock(OrderRepository.class);
    private final PaymentRepository paymentRepository = Mockito.mock(PaymentRepository.class);
    private final ExchangeRateClient exchangeRateClient = Mockito.mock(ExchangeRateClient.class);
    private final OrderService orderService;

    private final LocalDateTime now = LocalDateTime.now();

    public OrderServiceTest() {
        this.orderService = new OrderService(orderRepository, paymentRepository, exchangeRateClient);
    }

    @Test
    public void test() {
        var amount = FastMoney.of(2, Monetary.getCurrency("USD"));
        var order = new Order(now, new BigDecimal(String.valueOf(amount.getNumber())), false);
        when(orderRepository.save(any())).thenReturn(order);
        var returned = orderService.createOrder(amount);
        assertEquals(order, returned);
    }
}
