package com.javaguides.SpringBoot.Transaction.Demo.controller;

import com.javaguides.SpringBoot.Transaction.Demo.dto.OrderRequest;
import com.javaguides.SpringBoot.Transaction.Demo.dto.OrderResponse;
import com.javaguides.SpringBoot.Transaction.Demo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequest orderRequest) {

        return ResponseEntity.ok(orderService.placeOrder(orderRequest));
    }
}
