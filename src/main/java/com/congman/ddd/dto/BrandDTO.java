package com.congman.ddd.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BrandDTO {
    private Integer id;
    private String name;
    private int activeFlag;
    private Date createDate;
    private Date updateDate;
}
