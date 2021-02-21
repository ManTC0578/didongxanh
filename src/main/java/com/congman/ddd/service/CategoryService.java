package com.congman.ddd.service;

import com.congman.ddd.util.CategoryDTO;
import org.springframework.data.relational.core.sql.In;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface CategoryService {
    List<CategoryDTO> buildTreeCategory(Integer storeId);
}
