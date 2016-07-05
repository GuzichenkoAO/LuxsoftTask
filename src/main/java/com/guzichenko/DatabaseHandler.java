package com.guzichenko;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by ����� on 26.02.2016.
 */
public class DatabaseHandler {

    private static String INSERT = "INSERT INTO line_statistic(longest_word, shortest_word, line_length, average_word_length)  VALUES(?,?,?,?)";

    static void lineStatSaver(ArrayList<LineStat> list) {

        try {

            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);

        } catch (SQLException e) {
            System.out.println("Data base driver doesn`t exist");
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/statistic", "root", "root");
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {


            for (LineStat ls : list) {
                preparedStatement.setString(1, ls.getMaxLength());
                preparedStatement.setString(2, ls.getMinLength());
                preparedStatement.setInt(3, ls.getLineLength());
                preparedStatement.setDouble(4, ls.getAverageWordLength());
                preparedStatement.execute();

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void fileStatSaver(ArrayList<FileStat> list){

        try {

            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);

        } catch (SQLException e){
            System.out.println("Data base driver doesn`t exist");
        }

        try ( Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/statistic", "root", "root");
              PreparedStatement preparedStatement = connection.prepareStatement(INSERT)){


            for (FileStat ls: list) {
                preparedStatement.setString(1, ls.getMaxLength());
                preparedStatement.setString(2, ls.getMinLength());
                preparedStatement.setInt(3, ls.getLineLength());
                preparedStatement.setDouble(4, ls.getAverageWordLength());
                preparedStatement.execute();

            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }




}
