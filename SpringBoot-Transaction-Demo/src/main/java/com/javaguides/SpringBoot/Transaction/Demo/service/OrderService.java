package com.javaguides.SpringBoot.Transaction.Demo.service;

import com.javaguides.SpringBoot.Transaction.Demo.dto.OrderRequest;
import com.javaguides.SpringBoot.Transaction.Demo.dto.OrderResponse;
import com.javaguides.SpringBoot.Transaction.Demo.entity.Order;
import com.javaguides.SpringBoot.Transaction.Demo.entity.Payment;
import com.javaguides.SpringBoot.Transaction.Demo.exception.PaymentException;
import com.javaguides.SpringBoot.Transaction.Demo.repository.OrderRepository;
import com.javaguides.SpringBoot.Transaction.Demo.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;
    private final PaymentRepository paymentRepository;

    public OrderResponse placeOrder(OrderRequest orderRequest) {

        Order order = orderRequest.getOrder();
        order.setStatus("IN PROGRESS");
        order.setOrderTrackingNumber(UUID.randomUUID().toString());
        orderRepository.save(order);

        Payment payment = orderRequest.getPayment();

        if (!payment.getType().equals("DEBIT")) {

            throw new PaymentException("Debit Card Supported Only");
        }
        else {

        payment.setOrderId(order.getId());
        paymentRepository.save(payment);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderTrackingNumber(order.getOrderTrackingNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("ORDER PLACED SUCCESSFULLY");


        return orderResponse;
        }
    }
}
