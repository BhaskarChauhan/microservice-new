package com.microservice.servcie.inventory.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class InventoryResponse {
    private String skuCode;
    private boolean isInStock;
}
