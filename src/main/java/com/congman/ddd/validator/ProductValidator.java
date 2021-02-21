package com.congman.ddd.validator;

import com.congman.ddd.util.ItemDTO;
import com.congman.ddd.util.ProductDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductValidator implements Validator {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> errors = new ArrayList<>();

//    @Autowired
//    private ProductSerivce productSerivce;
//    @Autowired
//    private ItemService itemService;


    public void addValidationError(String error) {
        errors.add(error);
    }

    public List<String> getErrors() {
        return errors;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return ProductDTO.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ProductDTO productDTO = (ProductDTO) o;
        try {
//            if (productDTO.getItemDTO().getId() != null) {
//                ItemDTO itemDTO = this.itemService.findItemById(productDTO.getItemDTO().getId());
//                if (itemDTO == null || itemDTO.getId() < 0) {
//                    errors.reject("itemDTO.id", "Item id invalid !");
//                }
//            }
//
//            if (productDTO.getCode() == null || StringUtils.isEmpty(productDTO.getCode())) {
//                errors.reject("code", "code id invalid !");
//            }

        } catch (Exception e) {

        }
    }
}
