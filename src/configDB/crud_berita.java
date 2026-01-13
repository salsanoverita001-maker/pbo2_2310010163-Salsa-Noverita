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
public class crud_berita {
    
    private String namaDB = "hukum_pbo2";
    private String url = "jdbc:mysql://localhost:3306/" + namaDB;
    private String username = "root";
    private String password = "";
    private Connection koneksi;
    public String VAR_TOPIK = null;
    public String VAR_ISI = null;
    public String VAR_GAMBAR = null;
    public boolean validasi = false;
    
    public crud_berita(){
        try {
           Driver mysqldriver = new com.mysql.jdbc.Driver();
           DriverManager.registerDriver(mysqldriver);
           koneksi = DriverManager.getConnection(url,username,password);
           System.out.print("Berhasil dikoneksikan");
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error.getMessage());
                
        }
    }
    
    public void simpanBerita01(String tanggal, String jam, String topik, String isi, String gambar){
        try {
            String sql = "insert into berita(tanggal, jam, topik, isi, gambar) "
                    + "values('"+tanggal+"', '"+jam+"', '"+topik+"', '"+isi+"', '"+gambar+"')";
            
            Statement perintah = koneksi.createStatement();
            perintah.execute(sql);
            JOptionPane.showMessageDialog(null, "Data berita berhasil disimpan");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
    }
    
     public void simpanBerita02(String tanggal, String jam, String topik, String isi, String gambar){
        try {
            String sql = "insert into berita(tanggal, jam, topik, isi, gambar) values(?, ?, ?, ?, ?)";
            
            PreparedStatement perintah = koneksi.prepareStatement(sql);
            perintah.setString(1, tanggal);
            perintah.setString(2, jam);
            perintah.setString(3, topik);
            perintah.setString(4, isi);
            perintah.setString(5, gambar);
            perintah.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berita berhasil disimpan");
    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
    }
     
     public void ubahBerita01(String id_berita, String tanggal, String jam, String topik, String isi, String gambar){
        try {
            String sql = "update berita set tanggal = '"+tanggal+"', jam = '"+jam+"', topik = '"+topik+"'"
                    + ", isi = '"+isi+"', gambar = '"+gambar+"' where id_berita = '"+id_berita+"'";
                   
            Statement perintah = koneksi.createStatement();
            perintah.execute(sql);
             JOptionPane.showMessageDialog(null, "Data berita berhasil diubah");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
    }
     
      public void ubahBerita02(String id_berita, String tanggal, String jam, String topik, String isi, String gambar){
        try {
            String sql = "update berita set tanggal =?, jam =?, topik =?, isi =?, gambar =? where id_berita =?";
                   
            PreparedStatement perintah = koneksi.prepareStatement(sql);
            perintah.setString(1, tanggal);
            perintah.setString(2, jam);
            perintah.setString(3, topik);
            perintah.setString(4, isi);
            perintah.setString(5, gambar);
            perintah.setString(6, id_berita);
            
            perintah.executeUpdate();
             JOptionPane.showMessageDialog(null, "Data berita berhasil diubah");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
    }
      
       public void hapusBerita01(String id_berita){
        try {
            String sql = "delete from berita where id_berita = '"+id_berita+"'";
                   
            Statement perintah = koneksi.createStatement();
            perintah.execute(sql);
             JOptionPane.showMessageDialog(null, "Data berita berhasil dihapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
    }
       
       public void hapusBerita02(String id_berita){
        try {
            String sql = "delete from berita where id_berita = ?";
                   
            PreparedStatement perintah = koneksi.prepareStatement(sql);
            perintah.setString(1, id_berita);
            perintah.executeUpdate();
             JOptionPane.showMessageDialog(null, "Data berita berhasil dihapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
    }
       
      public void tampilDataBerita (JTable komponenTable, String SQL){
          try {
              Statement perintah = koneksi.createStatement();
              ResultSet data = perintah.executeQuery(SQL);
              ResultSetMetaData meta = data.getMetaData();
              int jumKolom = meta.getColumnCount();
              DefaultTableModel modelTable = new DefaultTableModel();
              modelTable.addColumn("ID Berita");
              modelTable.addColumn("Tanggal");
              modelTable.addColumn("Jam");
              modelTable.addColumn("Topik");
              modelTable.addColumn("Isi");
              modelTable.addColumn("Gambar");
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