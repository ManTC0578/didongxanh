package com.congman.ddd.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpecDetailDTO {
    private Integer id;
    private String name;
    private String value;
    private int activeFlag;
    private Date createDate;
    private Date updateDate;
}
