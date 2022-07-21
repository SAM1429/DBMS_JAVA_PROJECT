package com.company;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Createe {
    public void create(ArrayList<String>studentData, String k) throws IOException {
        TableCheck t = new TableCheck();
        boolean b;
        b = t.parseFile(studentData.get(1), k);
        if (b == true) {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet(studentData.get(1));
            sheet.createFreezePane(0, 1);
            FileAppend f1 = new FileAppend();
            FileRename f2 = new FileRename();
            //ArrayList<String> studentData = new ArrayList<>();
            // studentData.add("Register No");
            //studentData.add("Name");
            //studentData.add("Fees");

            int rows = studentData.size();
            for (int i = 0; i < 1; i++) {
                XSSFRow row = sheet.createRow(i);
                int j = 0;
                for (int c = 2; c < rows; c++) {
                    XSSFCell cell = row.createCell(j);
                    cell.setCellValue(studentData.get(c));
                    j++;
                }
            }


            String filePath = "ExcelFile/sample data" + studentData.get(1) + ".xlsx";
            FileOutputStream outstream = new FileOutputStream(filePath);
            workbook.write(outstream);
            outstream.close();
            //inputstream.close();
            System.out.println("has been successfully created");
            f1.fileAppend(k, "\nSuccessful Creation");
            //f2.closeFile(k);
            // f2.tableRename(k);
        }
    }
}