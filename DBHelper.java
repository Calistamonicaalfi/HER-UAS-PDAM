/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author CALISTA MONICA ALFI
 */
public class DBHelper {
    private String url = "jdbc:mysql://localhost/dbpdam";
    private String username = "root";
    private String password= "";
    private Connection con;
    
    public Connection getKoneksi()throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(url, username, password);
        return con;
}
    
    public static void main (String[] args) {
        DBHelper db = new DBHelper();
        try{
            db.getKoneksi();
            JOptionPane.showMessageDialog(null, "Koneksi OK");
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Koneksi Gagal"+ex.getMessage());
        }
    }
}
