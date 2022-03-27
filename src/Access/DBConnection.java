/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Access;

import java.sql.*;
import java.sql.DriverManager;
import javax.swing.*;

/**
 *
 * @author Nhat Anh
 */
public class DBConnection {
    public static Connection getConnection(){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        String URL = "jdbc:mysql://localhost/data_tts?user=root&password=";
        Connection con = DriverManager.getConnection(URL);
        return con;
    }
    catch (Exception ex){
        JOptionPane.showMessageDialog(null,ex.toString(),"Loi",JOptionPane.ERROR_MESSAGE);
        return null;
    } 
    }
}
