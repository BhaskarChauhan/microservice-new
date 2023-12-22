package com.microservice.servcie.order.controller;

import com.microservice.servcie.order.dto.OrderRequest;
import com.microservice.servcie.order.service.IOrderService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @CircuitBreaker(name = "inventory", fallbackMethod = "fallbackMethod")
    @TimeLimiter(name = "inventory")
    @Retry(name = "inventory")
    public CompletableFuture<String> placeOrder(@RequestBody OrderRequest orderRequest) {
        try {
            return orderService.placeOrder(orderRequest);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


    public CompletableFuture<String> fallbackMethod(OrderRequest orderRequest) {
        return CompletableFuture.supplyAsync(
                () -> "Oops!, something went wrong, please place order after sometime!");
    }

//    public CompletableFuture<String> timeoutFallback(OrderRequest orderRequest,
//                                  RuntimeException runtimeException) {
//        return CompletableFuture.supplyAsync(
//                () -> "Request timeout, please try again later!!");
//    }
}
