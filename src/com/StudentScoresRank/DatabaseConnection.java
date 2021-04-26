package com.StudentScoresRank;


/*-
 * @project: CourseRank/src/com.StudentScoresRank/DatabaseConnection
 * @description: operation
 * @author: 1910120228_louis
 * @Date: 2021/4/21 17:19
 **/

import java.sql.Connection;
import java.sql.DriverManager;

/**
* @description: this is a function to connect with mysql
* @Param: null
* @return: conn
* @author: 1910120228_louis
* @Date: 2021/4/21
* @Time: 21:36
*
**/
public class DatabaseConnection {
    private static Connection conn = null;
    public static Connection getCon() {
        try {
                        Class.forName("com.mysql.cj.jdbc.Driver");      //com.mysql.jdbc.Driver, Load database connection driver
                        String user = "root";
                        String psw = "Hwb..//0987";  //"..." the database pwd
                        String url = "jdbc:mysql://localhost:3306/assignment";      //assignment is one of your database
                        conn = DriverManager.getConnection(url, user, psw);     //try to connect
                    } catch (Exception e) {
                        System.out.println("** fail to connect to database **");
                        e.printStackTrace();
                    }
                return conn;
            }
}
