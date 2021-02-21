package com.congman.ddd.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailDTO {
    private int id;
    private SpecDTO specDTO;
    private ColorDTO colorDTO;
    private BigDecimal price;
    private String img_url;
    private int activeFlag;
    private Date createDate;
    private Date updateDate;
}
