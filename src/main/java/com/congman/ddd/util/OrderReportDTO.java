package com.congman.ddd.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderReportDTO {
    private StoreDTO storeDTO;
    private BigDecimal totalAmount;
    private Long totalQuantity;
}
