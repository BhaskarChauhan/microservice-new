package com.microservice.servcie.inventory.service;

import com.microservice.servcie.inventory.dto.InventoryResponse;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IInventoryService {
    List<InventoryResponse> isInStock(List<String> skuCode);
}
