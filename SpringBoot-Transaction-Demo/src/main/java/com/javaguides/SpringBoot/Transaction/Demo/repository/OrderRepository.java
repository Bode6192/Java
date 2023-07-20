package com.javaguides.SpringBoot.Transaction.Demo.repository;

import com.javaguides.SpringBoot.Transaction.Demo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
