package com.example.vhrapi.utils;

import com.example.vhrapi.model.per.Employeereward;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


public class EmpRUtils {
    public static ResponseEntity<byte[]> exportData(List<Employeereward> positions) {
        // 1. 创建 excel文件
        XSSFWorkbook workbook = new XSSFWorkbook();
        // 2. 创建样式
        // 标题行样式
        XSSFCellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.YELLOW.index);
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        // 日期样式
        XSSFCellStyle dateCellStyle = workbook.createCellStyle();
        dateCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));

        // 3. 写入标题栏数据
        XSSFSheet sheet = workbook.createSheet("员工惩罚信息表");
        sheet.setColumnWidth(0, 5 * 256);
        sheet.setColumnWidth(1, 15 * 256);
        sheet.setColumnWidth(2, 20 * 256);
        sheet.setColumnWidth(3, 10 * 256);

        Row titleRow = sheet.createRow(0);
        Cell c0 = titleRow.createCell(0);
        Cell c1 = titleRow.createCell(1);
        Cell c2 = titleRow.createCell(2);
        Cell c3 = titleRow.createCell(3);

        c0.setCellStyle(headerStyle);
        c1.setCellStyle(headerStyle);
        c2.setCellStyle(headerStyle);
        c3.setCellStyle(headerStyle);

        c0.setCellValue("编号");
        c1.setCellValue("姓名");
        c2.setCellValue("惩罚时间");
        c3.setCellValue("原因");

        // 4. 写入 postions数据
        for (int i = 0; i < positions.size(); i++) {
            Employeereward position = positions.get(i);
            Row row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue(position.getId());
            row.createCell(1).setCellValue(position.getName());

            Cell cell = row.createCell(2);
            cell.setCellStyle(dateCellStyle);
            cell.setCellValue(position.getPunishmentdate());
            row.createCell(3).setCellValue(position.getPunishmentclasses());
        }
        // 5. 保存文件
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        HttpHeaders headers = new HttpHeaders();
        try {
            headers.setContentDispositionFormData("attachment",
                    new String("员工惩罚表.xlsx".getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1));
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(out.toByteArray(), headers, HttpStatus.CREATED);
    }

    public static List<Employeereward> importData(MultipartFile file) {
        List<Employeereward> positions = new ArrayList<>();
        Employeereward position = null;
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
            // 2. 获取 workbook的 sheet数量
            int numberOfSheets = workbook.getNumberOfSheets();
            for (int i = 0; i < numberOfSheets; i++) {
                // 3. 获取 sheet
                XSSFSheet sheet = workbook.getSheetAt(i);
                int rows = sheet.getPhysicalNumberOfRows();
                for (int j = 1; j < rows; j++) {
                    XSSFRow row = sheet.getRow(j);
                    if (row != null) {
                        position = new Employeereward();
                        int cellNum = row.getPhysicalNumberOfCells();
                        for (int k = 0; k < cellNum; k++) {
                            XSSFCell cell = row.getCell(k);
                            switch (cell.getCellType()) {
                                case STRING:
                                    if (k == 1) {
                                        position.setName(cell.getStringCellValue());
                                    }
                                    break;
                                case BOOLEAN:
                                    if(k == 3) {
                                        position.setPunishmentdate(cell.getDateCellValue());
                                    }
                                    break;
                                default:
                                    if(k == 2) {
                                        position.setPunishmentclasses(cell.getStringCellValue());
                                    }
                                    break;
                            }
                        }
                        positions.add(position);

                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return positions;
    }
}
