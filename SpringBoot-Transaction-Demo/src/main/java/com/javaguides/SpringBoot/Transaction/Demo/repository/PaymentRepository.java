package com.javaguides.SpringBoot.Transaction.Demo.repository;

import com.javaguides.SpringBoot.Transaction.Demo.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
