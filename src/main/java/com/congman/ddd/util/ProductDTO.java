package com.congman.ddd.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Integer id;

    private ItemDTO itemDTO;
     private BrandDTO brandDTO;
    @NotNull
    @NotBlank
     private String name;

    @NotNull
    private String code;
    @NotNull
    private String description;
    @NotNull
    private String img_Main;
    private String img_1;
    private String img_2;
    private String img_3;
    private int activeFlag;
    private Date createDate;
    private Date updateDate;
    private List<ProductDetailDTO> productDetailDTOS;
}
