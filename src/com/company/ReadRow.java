package com.company;


import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;


public class ReadRow {
    public void readRow(String FileLoc, ArrayList<String> ui) throws IOException {

        String excelFilePath = "ExcelFile/sample data"+ ui.get(1)+ ".xlsx" ;
        FileInputStream inputstream = new FileInputStream(excelFilePath);
        XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
        XSSFSheet sheet = workbook.getSheetAt(0);
        FileAppend f1 = new FileAppend();
        FileRename f2 = new FileRename();

        int rows = sheet.getLastRowNum();
        if(rows==0) {f1.fileAppend(FileLoc,"\nNo data in table"); return;}
        int cols = sheet.getRow(1).getLastCellNum();
        int ru = 0,flag=0;
        int cu=0;
        //int value = list.get(0);

        for(int r =1;r<=rows;r++)
        {
            XSSFRow row = sheet.getRow(r);
            // System.out.println("first for");
            for(int c =0;c<cols;c++)
            {
                XSSFCell cell = row.getCell(c);
                //System.out.println(cell);
                //System.out.println(cell.getCellType());
                if(cell.getCellType()== CellType.STRING) {
                    if (cell.getStringCellValue().equals(ui.get(2))) {
                        System.out.println("Found");
                        ru = r;
                        flag=1;
                        break;

                    }
                }
            }
        }
        if(ru==0&&flag==0)
            f1.fileAppend(FileLoc,"\nNo Data Found\n");
        String passingit="";
        f1.fileAppend(FileLoc,"\n");
        for(int c =0;c<cols;c++) {
            passingit="";
            XSSFRow row = sheet.getRow(ru);
            XSSFCell cells = row.getCell(c);
            // try {
            //    FileWriter op = new FileWriter(FileLoc,true);
            System.out.print(row.getCell(c));

            passingit+=row.getCell(c)+" | ";
            // System.out.println("Append Success");
            //    op.close();
            //  } catch (IOException e) {
            //     System.out.println("File Append Error");
            //   }
            //
            System.out.print(" | ");
            // f1.fileAppend(FileLoc,"|");
            f1.fileAppend(FileLoc,passingit);

        }
        System.out.println();
        f1.fileAppend(FileLoc,"\n");
        // f2.closeFile(FileLoc);
        //  f2.readRename(FileLoc);

    }
}