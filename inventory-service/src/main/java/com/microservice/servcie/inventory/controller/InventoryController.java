package com.microservice.servcie.inventory.controller;

import com.microservice.servcie.inventory.dto.InventoryResponse;
import com.microservice.servcie.inventory.service.IInventoryService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private IInventoryService inventoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode, HttpServletRequest request) {
        System.out.println(request.getRequestURL().toString());
        System.out.println(request.getQueryString());
        return inventoryService.isInStock(skuCode);
    }

}
