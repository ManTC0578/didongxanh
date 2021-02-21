package com.congman.ddd.validator.builder;

import com.congman.ddd.validator.ProductValidator;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

public class ProductValidatorBuilder {
    public static ProductValidator fromBindingErrors(Errors errors){
        ProductValidator productValidator = new ProductValidator();
        for(ObjectError objectError : errors.getAllErrors()){
            productValidator.addValidationError(objectError.getDefaultMessage());
        }
        return productValidator;
    }
}
