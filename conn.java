/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employee;

/**
 *
 * @author KARAN
 */
import java.sql.*;
public class conn {
    
    public Connection con;
    public Statement pstmt;
    public conn(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management_system","root","");
            pstmt = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
