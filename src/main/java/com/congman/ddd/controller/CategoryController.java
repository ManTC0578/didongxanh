package com.congman.ddd.controller;

import com.congman.ddd.dto.wrap.MonoResponse;
import com.congman.ddd.service.CategoryService;
import com.congman.ddd.util.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/ddd/v1")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping(path = "/categories")
    public ResponseEntity<?> getProducts() {
        List<CategoryDTO> dtos = this.categoryService.buildTreeCategory(null);
        return ResponseEntity.ok(MonoResponse.wrap(dtos));
    }
}
