package com.example.sharedreferences;

import android.content.Context;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DataManager {
    Context context;
    public DataManager(Context context) {
        String[] array;
        this.context = context;
    }

    public void saveDataToFile(String textToSave){
        if(!textToSave.isEmpty()) {
            File folder = new File(context.getFilesDir(), "MyFolder");
            if (!folder.exists()) {
                folder.mkdir();
            }

            File textFile = new File(folder, "sample.text");

            try {
                PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(textFile, true)));
                writer.append(textToSave);
                writer.flush();
                writer.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public String loadFromFile() {
        File readFile = new File(context.getFilesDir(), "/MyFolder/sample.text");
        try {
            Scanner scanner = new Scanner(readFile);
            String s = scanner.nextLine();
            return s;
        } catch (FileNotFoundException e) {
            throw new RuntimeException (e);
        }
    }
}
