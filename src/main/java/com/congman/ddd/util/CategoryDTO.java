package com.congman.ddd.util;

import com.congman.ddd.entity.CategoryEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
    private Integer id;

    private String name;

    private Integer active;

    private String shortDescription;

    private Integer displayOrder;

    private CategoryDTO parent;

    private List<CategoryDTO> childs;

}
