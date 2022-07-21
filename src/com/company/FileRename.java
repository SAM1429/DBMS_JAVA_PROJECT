package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileRename  {
    public void  closeFile(String FileLoc) throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream(FileLoc);
        try {
            fos.close();
        } catch (IOException e) {
            System.out.println("error");
        }
    }
    public void tableRename(String FileLoc) {
        File oldName = new File(FileLoc);
        File file = new File(FileLoc);
        String fileName = file.getName();
        File newName = new File("Table Created.txt");
        if (oldName.renameTo(newName))
            System.out.println("Renamed successfully");
        else
            System.out.println("Error");
    }
    public void rowRename(String FileLoc) {
        File oldName = new File(FileLoc);
        File file = new File(FileLoc);
        String fileName = file.getName();
        File newName = new File("Row Created.txt");
        if (oldName.renameTo(newName))
            System.out.println("Renamed successfully");
        else
            System.out.println("Error");
    }
    public void readRename(String FileLoc) {
        File oldName = new File(FileLoc);
        File file = new File(FileLoc);
        String fileName = file.getName();
        File newName = new File("Read Successful.txt");
        if (oldName.renameTo(newName))
            System.out.println("Renamed successfully");
        else
            System.out.println("Error");
    }
}