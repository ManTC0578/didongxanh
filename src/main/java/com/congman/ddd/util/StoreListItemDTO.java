package com.congman.ddd.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreListItemDTO {
    private Integer id;
    private int quantity;
    private int activeFlag;
    private Date createDate;
    private Date updateDate;
    private ProductDetailDTO productDetailDTO;
}
