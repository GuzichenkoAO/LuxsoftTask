package com.guzichenko;

import java.io.*;
import java.util.ArrayList;


/**
 * Created by Артем on 25.02.2016.
 */
public class FileHandler {

    public ArrayList<String> reader(String fileName) throws IOException{

        File file = new File(fileName);
        ArrayList<String> list = new ArrayList<>();

        try{
            BufferedReader br = new BufferedReader(new FileReader( file.getAbsoluteFile() ));
            try{
                String s;
                while ((s = br.readLine()) != null){
                    list.add(s);
                }
            } finally {
                br.close();
            }

        } catch (FileNotFoundException e){
            System.out.println("File doesn`t exist");
        }
        return list;
    }


}
