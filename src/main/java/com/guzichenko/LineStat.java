package com.guzichenko;

import java.util.StringTokenizer;

/**
 * Created by Артем on 26.02.2016.
 */
public class LineStat {

    private String maxLength = "", minLength = "";
    private int lineLength = 0;
    private double averageWordLength = 0;

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

    public LineStat(String line){

        StringTokenizer st = new StringTokenizer(line, " ");
        String array[] = new String[st.countTokens()];
        int i = 0;
        double tokenCount = st.countTokens();
        double sum = 0;

        lineLength = line.length();

        while (st.hasMoreTokens()){
            array[i] = st.nextToken();
            i++;
        }
        if (array.length != 0) {
            minLength = array[0];
            for (int j = 0; j < array.length; j++) {

                if (maxLength.length() < array[j].length()) maxLength = array[j];
                if (minLength.length() > array[j].length()) minLength = array[j];

                sum += array[j].length();
            }

            averageWordLength = sum / tokenCount;
        }
    }

    @Override
    public String toString() {
        return "Longest word: " + maxLength + "\n" +
                "Shortest word: " + minLength + "\n" +
                "Line length: " + lineLength + "\n" +
                "Average word length: " + averageWordLength;
    }
}
