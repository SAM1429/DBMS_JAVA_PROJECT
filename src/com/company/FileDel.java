package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileDel {
    public void fileCreate(String FileLoc) {
        try {
            File myObj = new File("Table created ");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred in FileCreate.");
        }
    }

    public void fileDelete(String FileLoc)
    {
        File file
                = new File(FileLoc);

        if (file.delete()) {
            System.out.println("File deleted successfully");
        }
        else {
            System.out.println("Failed to delete the file");
        }
    }

    public void fileAppend(String FileLoc, String C) {

        try {
            FileWriter op = new FileWriter(FileLoc,true);
            op.write(C);
            //System.out.println("Append Success");
            op.close();
        } catch (IOException e) {
            System.out.println("File Append Error");
        }
    }

    public void gettingShitTogether(String FileLoc, String C){
        FileDel f = new FileDel();
        f.fileDelete(FileLoc);
        f.fileCreate(FileLoc);
    }
}
