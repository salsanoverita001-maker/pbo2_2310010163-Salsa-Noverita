/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package configDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Driver;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.sql.ResultSetMetaData;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class crud_jadwal_sidang {
    
    private String namaDB = "hukum_pbo2";
    private String url = "jdbc:mysql://localhost:3306/" + namaDB;
    private String username = "root";
    private String password = "";
    private Connection koneksi;
    public String VAR_HARI = null;
    public String VAR_SUSUNAN_MAJLIS = null;
    public String VAR_ACARA = null;
    public String VAR_RUANG = null;
    public boolean validasi = false;
    
    public crud_jadwal_sidang(){
        try {
           Driver mysqldriver = new com.mysql.jdbc.Driver();
           DriverManager.registerDriver(mysqldriver);
           koneksi = DriverManager.getConnection(url,username,password);
           System.out.print("Berhasil dikoneksikan");
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error.getMessage());
                
        }
    }
    
    public void simpanJadwalSidang01(String hari, String tanggal, String jam, String susunan_majlis, String acara, String ruang){
        try {
            String sql = "insert into jadwal_sidang(hari, tanggal, jam, susunan_majlis, acara, ruang) "
                    + "values('"+hari+"', '"+tanggal+"', '"+jam+"', '"+susunan_majlis+"', '"+acara+"', '"+ruang+"')";
            
            Statement perintah = koneksi.createStatement();
            perintah.execute(sql);
            JOptionPane.showMessageDialog(null, "Data jadwal sidang berhasil disimpan");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
    }
    
     public void simpanJadwalSidang02(String hari, String tanggal, String jam, String susunan_majlis, String acara, String ruang){
        try {
            String sql = "insert into jadwal_sidang(hari, tanggal, jam, susunan_majlis, acara, ruang) values(?, ?, ?, ?, ?, ?)";
            
            PreparedStatement perintah = koneksi.prepareStatement(sql);
            perintah.setString(1, hari);
            perintah.setString(2, tanggal);
            perintah.setString(3, jam);
            perintah.setString(4, susunan_majlis);
            perintah.setString(5, acara);
            perintah.setString(6, ruang);
            perintah.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data jadwal sidang berhasil disimpan");
    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
    }
     
     public void ubahJadwalSidang01(String id_jadwal, String hari, String tanggal, String jam, String susunan_majlis, String acara, String ruang){
        try {
            String sql = "update jadwal_sidang set hari = '"+hari+"', tanggal = '"+tanggal+"', jam = '"+jam+"'"
                    + ", susunan_majlis = '"+susunan_majlis+"', acara = '"+acara+"', ruang = '"+ruang+"' where id_jadwal = '"+id_jadwal+"'";
                   
            Statement perintah = koneksi.createStatement();
            perintah.execute(sql);
             JOptionPane.showMessageDialog(null, "Data jadwal sidang berhasil diubah");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
    }
     
      public void ubahJadwalSidang02(String id_jadwal, String hari, String tanggal, String jam, String susunan_majlis, String acara, String ruang){
        try {
            String sql = "update jadwal_sidang set hari =?, tanggal =?, jam =?, susunan_majlis =?, acara =?, ruang =? where id_jadwal =?";
                   
            PreparedStatement perintah = koneksi.prepareStatement(sql);
            perintah.setString(1, hari);
            perintah.setString(2, tanggal);
            perintah.setString(3, jam);
            perintah.setString(4, susunan_majlis);
            perintah.setString(5, acara);
            perintah.setString(6, ruang);
            perintah.setString(7, id_jadwal);
            
            perintah.executeUpdate();
             JOptionPane.showMessageDialog(null, "Data jadwal sidang berhasil diubah");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
    }
      
       public void hapusJadwalSidang01(String id_jadwal){
        try {
            String sql = "delete from jadwal_sidang where id_jadwal = '"+id_jadwal+"'";
                   
            Statement perintah = koneksi.createStatement();
            perintah.execute(sql);
             JOptionPane.showMessageDialog(null, "Data jadwal sidang berhasil dihapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
    }
       
       public void hapusJadwalSidang02(String id_jadwal){
        try {
            String sql = "delete from jadwal_sidang where id_jadwal = ?";
                   
            PreparedStatement perintah = koneksi.prepareStatement(sql);
            perintah.setString(1, id_jadwal);
            perintah.executeUpdate();
             JOptionPane.showMessageDialog(null, "Data jadwal sidang berhasil dihapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
    }
       
      public void tampilDataJadwalSidang (JTable komponenTable, String SQL){
          try {
              Statement perintah = koneksi.createStatement();
              ResultSet data = perintah.executeQuery(SQL);
              ResultSetMetaData meta = data.getMetaData();
              int jumKolom = meta.getColumnCount();
              DefaultTableModel modelTable = new DefaultTableModel();
              modelTable.addColumn("ID Jadwal");
              modelTable.addColumn("Hari");
              modelTable.addColumn("Tanggal");
              modelTable.addColumn("Jam");
              modelTable.addColumn("Susunan Majlis");
              modelTable.addColumn("Acara");
              modelTable.addColumn("Ruang");
              modelTable.getDataVector().clear();
              modelTable.fireTableDataChanged();
              while (data.next() ) {
                  Object[] row = new Object[jumKolom];
                  for(int i = 1; i <= jumKolom; i++ ){
                      row [i - 1] = data.getObject(i);
                  }
                  modelTable.addRow(row);
              }
              komponenTable.setModel(modelTable);
          } catch (Exception e) {
              
          }
      }
}