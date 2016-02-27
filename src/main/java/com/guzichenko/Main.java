package com.guzichenko;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



import java.util.ArrayList;

/**
 * Created by Артем on 25.02.2016.
 */
public class Main {
    public static void main(String[] args) throws IOException{

        ArrayList<String> list;
        ArrayList<LineStat> lStat = new ArrayList<>();
        ArrayList<FileStat> fStat = new ArrayList<>();        //List for future updates (if will be more than 1 file)

        FileHandler fh = new FileHandler();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        System.out.println("Input file name:");

        list = fh.reader(br.readLine());

        for (String s: list){
            lStat.add( new LineStat(s));
        }

        fStat.add(new FileStat(lStat));

        DatabaseHandler.lineStatSaver(lStat);
        DatabaseHandler.fileStatSaver(fStat);







    }
}
