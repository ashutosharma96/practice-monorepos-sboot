package org.example;
import java.sql.*;
import static java.lang.Class.forName;

public class Main {
    public static void main(String[] args)throws Exception  {


        String uname="postgres";
        String pass="ashuashu99";
        String url="jdbc:postgresql://localhost:5432/practiceDB";

        Connection con=DriverManager.getConnection(url,uname,pass);

        System.out.print("Connection established....\n");



        con.close();
    System.out.println("Connection closed.......");

    }


}