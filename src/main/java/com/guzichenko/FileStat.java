package com.guzichenko;

import java.util.ArrayList;

/**
 * Created by Артем on 26.02.2016.
 */
public class FileStat {

    private String maxLength = "", minLength = "";
    private int lineLength = 0;
    private double averageWordLength = 0;


    public FileStat(ArrayList<LineStat> list){

        double sum = 0;

        minLength = list.get(0).getMinLength();

        for (LineStat ls: list){

            if (maxLength.length() < ls.getMaxLength().length()) maxLength = ls.getMaxLength();
            if (minLength.length() > ls.getMinLength().length()) minLength = ls.getMinLength();

            lineLength += ls.getLineLength();

            sum += ls.getAverageWordLength();
        }

        averageWordLength = sum/list.size();

    }

    public String getMaxLength() {
        return maxLength;
    }

    public String getMinLength() {
        return minLength;
    }

    public int getLineLength() {
        return lineLength;
    }

    public double getAverageWordLength() {
        return averageWordLength;
    }

    @Override
    public String toString() {
        return "Longest word in file: " + maxLength + "\n" +
                "Shortest word in file: " + minLength + "\n" +
                "Text length in file: " + lineLength + "\n" +
                "Average words length in file: " + averageWordLength;
    }


}
