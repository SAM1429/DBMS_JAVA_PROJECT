package com.company;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;


public class Insert{

    void Inserting(ArrayList<String> list,String k) throws IOException {
        // XSSFWorkbook workbook = new XSSFWorkbook();


        String excelFilePath = "ExcelFile/sample data"+list.get(1)+".xlsx" ;
        FileInputStream inputstream = new FileInputStream(excelFilePath);
        XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
        XSSFSheet sheet = workbook.getSheet(list.get(1));
        int v= sheet.getLastRowNum()+1;
        int z=  sheet.getRow(0).getLastCellNum();
        /* ArrayList<Object> list = new ArrayList<>();
        list.add("Abhinav");
        list.add("20GANSE002");
        list.add(5000.0); */
        FileAppend f1 = new FileAppend();
        FileRename f2 = new FileRename();
        if(z!= list.size()-2)
        { f1.fileAppend(k,"\nPlease Give correct inputs"); return;}
        int rows = list.size();
        XSSFRow row = sheet.createRow(v);


        for(int i =1;i<2;i++)
        {

            int j=0;
            for(int c = 2;c<rows;c++)
            {
                XSSFCell cell = row.createCell(j);
                Object value = list.get(c);
                if(value instanceof String)
                    cell.setCellValue((String)value);

                j++;
            }
        }


        FileOutputStream fos = new FileOutputStream(excelFilePath);
        workbook.write(fos);
        fos.close();
        System.out .println("Success");
        f1.fileAppend(k,"\nSuccessful Insertion");
        //  f2.closeFile(k);
        // f2.rowRename(k);




    }
}