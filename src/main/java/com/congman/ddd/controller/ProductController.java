package com.congman.ddd.controller;

import com.congman.ddd.dto.wrap.MonoResponse;
import com.congman.ddd.util.HttpStatusCode;
import com.congman.ddd.util.ProductDTO;
import com.congman.ddd.util.ReponseRest;
import com.congman.ddd.validator.ProductValidator;
import com.congman.ddd.validator.builder.ProductValidatorBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class ProductController {
//
//    @Autowired
//    private ProductSerivce productSerivce;
    @Autowired
    private ProductValidator productValidator;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        if (binder.getTarget() == null) {
            return;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
        if (binder.getTarget().getClass() == ProductDTO.class) {
            binder.setValidator(productValidator);
        }
    }

//    @RequestMapping("/productInStock/{categoryId}")
//    public ResponseEntity<List<ProductDTO>> findProductInStock(@PathVariable("categoryId") Integer categoryId) {
//
//        List<ProductDTO> productDTOS = this.productSerivce.findProductInStockByCategoryId(categoryId);
//        return ResponseEntity.ok(productDTOS);
//    }

    @PostMapping("/saveProduct")
    public ReponseRest<Object> saveProduct(@Valid @RequestBody ProductDTO productDTO, Errors errors) {

        if (errors.hasErrors()) {
            return new ReponseRest<>(HttpStatusCode.object_not_found.getCode(),
                    HttpStatusCode.object_not_found.getDes(),
                    ProductValidatorBuilder.fromBindingErrors(errors));
        }
        return new ReponseRest<>(HttpStatusCode.created.getCode(), HttpStatusCode.created.getDes(), null);
    }

//    @GetMapping(path = "/product/{id}")
//    public ResponseEntity<?> getProductByid(@PathVariable("id") Integer id) {
//        ProductDTO dto = this.productSerivce.findById(id);
//        return ResponseEntity.ok(MonoResponse.wrap(dto));
//    }

    public static int[] removeDuplicates(int[] input) {

        int j = 0;
        int i = 1;

        if (input.length < 2) {
            return input;
        }
        while (i < input.length) {
            if (input[i] == input[j]) {
                i++;
            } else {
                input[++j] = input[i++];
            }
        }

        int output[] = new int[j + 1];
        for (int k = 0; k < output.length; k++) {
            output[k] = input[k];
        }
        return output;
    }

    public static String join(Object[] array, char separator, int startIndex, int endIndex) {
        if (array == null) {
            return null;
        } else {
            int bufSize = endIndex - startIndex;
            if (bufSize <= 0) {
                return "";
            } else {
               // bufSize *= (array[startIndex] == null ? 16 : array[startIndex].toString().length()) + 1;
                StringBuffer buf = new StringBuffer(bufSize);

                for(int i = startIndex; i < endIndex; i++) {
                    if (i > startIndex) {
                        buf.append(separator);
                    }

                    if (array[i] != null) {
                        buf.append(array[i]);
                    }
                }

                return buf.toString();
            }
        }
    }
    public static String join(Object[] array, char separator) {
        return array == null ? null : join(array, separator, 1, array.length);
    }

    public static boolean isBlank(String str) {
        int strLen;
        if (str != null && (strLen = str.length()) != 0) {
            for(int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }

            return true;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        int[] input1 = {2, 3, 3, 10, 6, 8, 9, 10, 10, 10, 12, 12};
        int[] output = removeDuplicates(input1);
//        for (int i : output) {
//            System.out.print(i + " ");
//        }

     String s[] = {"a","b","c","d"};
//     String result =join(s,',');
   // Boolean check = isBlank("  s  ");
    }
}