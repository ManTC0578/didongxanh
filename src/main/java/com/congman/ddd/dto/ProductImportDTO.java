package com.congman.ddd.dto;

import com.congman.ddd.entity.BrandEntity;
import com.congman.ddd.entity.CategoryEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductImportDTO {

    private Integer categoryId;

    private Integer brandId;

    private String name;

    private String code;

    private String description;

    private String thumbnail;

    private Boolean isValid = true;

    private int errCode;

    private String errMessage;

    private Boolean isExist;

    private String loadingStatus;
    }
