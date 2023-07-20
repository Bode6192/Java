package com.javaguides.SpringBoot.Transaction.Demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {

    private String orderTrackingNumber;
    private String status;
    private String message;
}
