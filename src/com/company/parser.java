package com.company;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class parser {
    void parsing(Path path) throws IOException {
        String file = "C:\\dbms\\" + path.toString();
        Scanner in = new Scanner(new File(file));
        ArrayList<String> str2 = new ArrayList<String>();
        FileAppend f1 = new FileAppend();
        while (in.hasNextLine()) {
            String str[] = in.nextLine().split(" ");
            for (int i = 0; i < str.length; i++)
                str2.add(str[i]);
        }
        try {
            int flag = 0;
            if (str2.get(0).equals("Create")) {
                if (str2.size() >= 3) {
                    System.out.println("will implement here");
                    System.out.println(str2);
                    Createe c1 = new Createe();
                    c1.create(str2, file);


                } else
                    f1.fileAppend(file, "\n Wrong Input");
                flag = 1;
            }

            if (str2.get(0).equals("Insert")) {
                if (str2.size() >= 3) {
                    Insert i = new Insert();
                    try {
                        i.Inserting(str2, file);
                    } catch (IOException e) {
                        System.out.println("\nTable Doesn't Exist");
                        f1.fileAppend(file, "\nTable Doesn't Exist\n");//will pass to sai
                    }
                    //Also check for the table wether it exists or not
                } else
                    f1.fileAppend(file, "\nWrong Input");
                flag = 1;

            }
            if (str2.get(0).equals("ReadAll")) {
                if (str2.size() != 2)
                    f1.fileAppend(file, "\nWrong Format");
                else {
                    // System.out.println("working ReadAll");
                    ReadAll r = new ReadAll();
                    try {
                        r.readAll(file, str2);
                    } catch (IOException e) {
                        f1.fileAppend(file, "\nError Try Again");  //will handle it later
                    }
                }
                flag = 1;
            }
            if (str2.get(0).equals("ReadRow")) {
                if (str2.size() != 3)
                    f1.fileAppend(file, "\nWrong Input Format");
                else {
                    System.out.println("working ReadRow");
                    ReadRow r2 = new ReadRow();
                    try {
                        r2.readRow(file, str2);
                    } catch (IOException e) {
                        f1.fileAppend(file, "\nError Try Again"); //will handle exception
                    }
                }
                flag = 1;
            }
            if (flag == 0)
                f1.fileAppend(file, "\nError Wrong Inputs");


        } catch (IndexOutOfBoundsException i) {
            System.out.println("Your input not valid");
            f1.fileAppend(file, "\nYour Input not valid");
        }
    }

}