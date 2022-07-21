package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TableCheck {
    boolean parseFile(String searchStr,String K) throws FileNotFoundException {
        int flag=1;
        FileAppend f=new FileAppend();
        Scanner scan = new Scanner(new File("ExcelFile/tables.txt"));
        searchStr=searchStr.toLowerCase();
        while(scan.hasNext()){
            String line = scan.nextLine().toLowerCase();
            if(line.contains(searchStr)){
                f.fileAppend(K,"\nTable Already Exists\n");
                flag=0;
                break;

            }
            else
                f.fileAppend("ExcelFile/tables.txt"," "+searchStr);
            flag=1;
        }
        if(flag==1) return true;
        else return false;
    }

}
