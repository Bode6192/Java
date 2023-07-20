package com.javaguides.SpringBoot.Transaction.Demo.dto;

import com.javaguides.SpringBoot.Transaction.Demo.entity.Order;
import com.javaguides.SpringBoot.Transaction.Demo.entity.Payment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {

    private Order order;
    private Payment payment;
}
