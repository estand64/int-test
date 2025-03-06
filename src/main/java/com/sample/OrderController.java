package com.sample;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.money.CurrencyUnit;
import java.net.URI;

@RestController
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/order")
    public ResponseEntity<Order> createOrder(
            @RequestBody @Valid OrderRequest orderRequest,
            UriComponentsBuilder uriComponentsBuilder) {

        Order order = orderService.createOrder(orderRequest.amount());
        URI location = uriComponentsBuilder.path("/order/{id}").buildAndExpand(order.getId()).toUri();
        return ResponseEntity.created(location).body(order);
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable("id") Long orderId) {
        Order order = orderService.getOrder(orderId);
        return ResponseEntity.ok().body(order);
    }

    @PostMapping("/order/{id}/payment")
    public ResponseEntity<PaymentResponse> pay(
            @PathVariable("id") Long orderId,
            @RequestBody @Valid PaymentRequest paymentRequest,
            UriComponentsBuilder uriComponentsBuilder) {

        Payment payment = orderService.pay(orderId, paymentRequest.creditCardNumber());
        URI location = uriComponentsBuilder.path("/order/{id}/receipt").buildAndExpand(orderId).toUri();
        PaymentResponse response = new PaymentResponse(payment.getOrder().getId(), payment.getCreditCardNumber());
        return ResponseEntity.created(location).body(response);
    }

    @GetMapping("/order/{id}/receipt")
    public ResponseEntity<Receipt> getReceipt(
            @PathVariable("id") Long orderId,
            @RequestParam(value = "currency", required = false, defaultValue = "EUR") CurrencyUnit currency) {

        Receipt receipt = orderService.getReceipt(orderId, currency);
        return ResponseEntity.ok().body(receipt);
    }
}
