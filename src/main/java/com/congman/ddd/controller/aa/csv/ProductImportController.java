package com.congman.ddd.controller.aa.csv;

import com.congman.ddd.dto.FileUploadBean;
import com.congman.ddd.dto.ProductImportDTO;
import com.congman.ddd.dto.wrap.MonoResponse;
import com.congman.ddd.util.CsvReader;
import com.congman.ddd.util.file.FileUtil;
import org.apache.any23.encoding.TikaEncodingDetector;
import org.apache.commons.io.input.BOMInputStream;
import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/ddd/v1")
public class ProductImportController {

    public transient final Logger log = Logger.getLogger(getClass());
    private static final String[] expectedHeaders = new String[]{"Action A/U (Required)", "CategoryId (Required)", "BrandId (Required)",
            "Name (Required)", "Code (Required)", "Description (Optional)", "Thumbnail (Optional)"};


    @RequestMapping(value = "/upload",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_XML_VALUE}, method = RequestMethod.POST)
    public ResponseEntity<?> uploadCSV(@ModelAttribute FileUploadBean fileUploadBean, HttpServletRequest request) {
        List<ProductImportDTO> productImportDTOS = new ArrayList<>();

        try {
            CommonsMultipartFile csvFile = (CommonsMultipartFile) fileUploadBean.getFile();
            int totalItems = 0;
            try {
                Object[] objs = transferData2DTO(csvFile, request);
                totalItems = Integer.valueOf(objs[0].toString());
                productImportDTOS = (List<ProductImportDTO>) objs[1];

            } catch (IOException ex) {
                log.error(ex.getMessage(), ex);
            }
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        }
        return ResponseEntity.ok(MonoResponse.wrap(productImportDTOS));


    }


    private List<ProductImportDTO> readCSVFile(String fileName) throws IOException {
        List<ProductImportDTO> productList = new ArrayList<>();
        InputStream is = new FileInputStream(fileName);
        InputStream bis = new BOMInputStream(is);
        CsvReader csvReader = new CsvReader(bis, getEncoding(fileName));

        int totalColumn = 6;
        while (csvReader.readRecord()) {
            if (csvReader.getCurrentRecord() == 0 || (csvReader.getColumnCount() == 1)) {
                continue;
            }
            if (csvReader.getColumnCount() != totalColumn) {
                csvReader.close();
                bis.close();
                is.close();

            }

            String test = csvReader.get(0) != null ? csvReader.get(0).trim() : "";

        }

        csvReader.close();
        bis.close();
        is.close();

        try {
            FileUtil.remove(fileName);
        } catch (Exception ex) {

        }

        return productList;
    }

    private Object[] transferData2DTO(CommonsMultipartFile csvFile, HttpServletRequest request) throws IOException, ServletException {
        List<ProductImportDTO> productResultList = new ArrayList<>();
        int totalItems = 0;
        String destFolder = "/files/temp";
        String fileName = FileUtil.upload(request, destFolder, csvFile);
        String destFileName = request.getSession().getServletContext().getRealPath(destFolder + "/" + fileName);
        List<ProductImportDTO> studentList = readCSVFile(destFileName);

        return new Object[]{totalItems, studentList};

    }

    public static String getEncoding(String fileName) {
        try {
            File file = new File(fileName);
            FileInputStream fis = new FileInputStream(file);
            String encoding = new TikaEncodingDetector().guessEncoding(fis);
            fis.close();
            return encoding;
        } catch (IOException e) {
            //ignore
        }
        return "";
    }

}
