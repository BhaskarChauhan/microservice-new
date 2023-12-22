package com.microservice.servcie.order.service;

import com.microservice.servcie.order.dto.OrderRequest;

import java.util.concurrent.CompletableFuture;

public interface IOrderService {
    CompletableFuture<String> placeOrder(OrderRequest orderRequest) throws IllegalAccessException;
}
