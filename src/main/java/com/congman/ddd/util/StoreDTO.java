package com.congman.ddd.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreDTO {
    private Integer id;
    private String address;
    private String name;
    private int activeFlag;
    private Date createDate;
    private Date updateDate;
    private List<StoreListItemDTO> storeListItemDTOS;
}
