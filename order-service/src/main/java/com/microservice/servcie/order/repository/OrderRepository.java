package com.microservice.servcie.order.repository;

import com.microservice.servcie.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
