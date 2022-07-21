package com.company;

import org.apache.poi.xssf.usermodel.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ReadAll {
    public void readAll(String FileLoc, ArrayList<String> tname) throws IOException
    {
        String excelFilePath = "ExcelFile/sample data"+ tname.get(1)+".xlsx" ;
        FileInputStream inputstream = new FileInputStream(excelFilePath);
        XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
        XSSFSheet sheet = workbook.getSheetAt(0);
        FileAppend fa = new FileAppend();
        FileRename fr = new FileRename();
        //ArrayList<ArrayList<String>> op = new ArrayList<ArrayList<String>>();
        //ArrayList<String> opa = new ArrayList<>();

       /* int rows = sheet.getLastRowNum();
        int cols = sheet.getRow(1).getLastCellNum();
        for(int r =0;r<=rows;r++)
        {
            XSSFRow row = sheet.getRow(r);
            for(int c =0;c<cols;c++)
            {
                XSSFCell cell = row.getCell(c);
                switch(cell.getCellType())
                {
                    case STRING: System.out.print(cell.getStringCellValue());
                    break;
                    case NUMERIC:System.out.print(cell.getNumericCellValue());
                    break;
                    case BOOLEAN:System.out.print(cell.getBooleanCellValue());
                    break;
                }
                System.out.println();
            }
        }*/
        Iterator iterator = sheet.iterator();
        String appendingstring = "";
        while(iterator.hasNext())
        {
            XSSFRow row = (XSSFRow) iterator.next();
            Iterator cellIterator = row.cellIterator();
            fa.fileAppend(FileLoc,"\n");
            while(cellIterator.hasNext())
            {   appendingstring="";
                XSSFCell cell = (XSSFCell) cellIterator.next();
                switch (cell.getCellType()) {
                    case STRING -> { //try {
                        // fa.fileAppend(FileLoc,"\n");
                        // FileWriter op = new FileWriter(FileLoc,true);
                        // op.write(cell.getStringCellValue());
                        // System.out.println("Append Success");
                        //  op.close();
                        // } catch (IOException e) {
                        //    System.out.println("File Append Error");
                        //}}
                        // }
                        System.out.print(cell.getStringCellValue());
                        appendingstring+=cell.getStringCellValue();
                    }
                }
                System.out.print(" | ");

                appendingstring= appendingstring+" | ";


                fa.fileAppend(FileLoc,appendingstring);
            }
            System.out.println("\n");
            fa.fileAppend(FileLoc,"\n");

        }
        // fr.readRename(FileLoc);
    }
}