package com.congman.ddd.service.mapper;

import com.congman.ddd.entity.CategoryEntity;
import com.congman.ddd.util.CategoryDTO;

public class CategoryBeanUtil {
    public static CategoryDTO entityDTO(CategoryEntity entity) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(entity.getId());
        categoryDTO.setName(entity.getName());
        categoryDTO.setActive(entity.getActive());
        categoryDTO.setDisplayOrder(entity.getDisplayOrder());
        categoryDTO.setShortDescription(entity.getShortDescription());
        if(entity.getParent() != null){

            CategoryDTO parent = new CategoryDTO();
            parent.setId(entity.getParent().getId());
            parent.setName(entity.getParent().getName());
            parent.setActive(entity.getParent().getActive());
            parent.setDisplayOrder(entity.getParent().getDisplayOrder());
            parent.setShortDescription(entity.getParent().getShortDescription());
            categoryDTO.setParent(parent);
        }
        return categoryDTO;
    }
    public static CategoryEntity dto2Entity(CategoryDTO categoryDTO){
        CategoryEntity entity = new CategoryEntity();
        entity.setId(categoryDTO.getId());
        entity.setName(categoryDTO.getName());
        entity.setActive(categoryDTO.getActive());
        entity.setDisplayOrder(categoryDTO.getDisplayOrder());
        entity.setShortDescription(categoryDTO.getShortDescription());
        if(entity.getParent() != null){

            CategoryEntity parent = new CategoryEntity();
            parent.setId(categoryDTO.getParent().getId());
            parent.setName(categoryDTO.getParent().getName());
            parent.setActive(categoryDTO.getParent().getActive());
            parent.setDisplayOrder(categoryDTO.getParent().getDisplayOrder());
            parent.setShortDescription(categoryDTO.getParent().getShortDescription());
            entity.setParent(parent);
        }
        return entity;
    }

}
