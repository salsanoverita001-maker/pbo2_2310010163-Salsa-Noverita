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
public class crud_bagian_perkara {
    
    private String namaDB = "hukum_pbo2";
    private String url = "jdbc:mysql://localhost:3306/" + namaDB;
    private String username = "root";
    private String password = "";
    private Connection koneksi;
    public String VAR_NAMA_LENGKAP = null;
    public String VAR_USERNAME = null;
    public String VAR_PASSWORD = null;
    public String VAR_HAK_AKSES = null;
    public boolean validasi = false;
    
    public crud_bagian_perkara(){
        try {
           Driver mysqldriver = new com.mysql.jdbc.Driver();
           DriverManager.registerDriver(mysqldriver);
           koneksi = DriverManager.getConnection(url,username,password);
           System.out.print("Berhasil dikoneksikan");
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error.getMessage());
                
        }
    }
    
    public void simpanBagianPerkara01(String nama_lengkap, String username, String password, String hak_akses){
        try {
            String sql = "insert into bagian_perkara(nama_lengkap, username, password, hak_akses) "
                    + "values('"+nama_lengkap+"', '"+username+"', '"+password+"', '"+hak_akses+"')";
            
            Statement perintah = koneksi.createStatement();
            perintah.execute(sql);
            JOptionPane.showMessageDialog(null, "Data bagian perkara berhasil disimpan");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
    }
    
     public void simpanBagianPerkara02(String nama_lengkap, String username, String password, String hak_akses){
        try {
            String sql = "insert into bagian_perkara(nama_lengkap, username, password, hak_akses) values(?, ?, ?, ?)";
            
            PreparedStatement perintah = koneksi.prepareStatement(sql);
            perintah.setString(1, nama_lengkap);
            perintah.setString(2, username);
            perintah.setString(3, password);
            perintah.setString(4, hak_akses);
            perintah.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data bagian perkara berhasil disimpan");
    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
    }
     
     public void ubahBagianPerkara01(String id_bagian_perkara, String nama_lengkap, String username, String password, String hak_akses){
        try {
            String sql = "update bagian_perkara set nama_lengkap = '"+nama_lengkap+"', username = '"+username+"', password = '"+password+"'"
                    + ", hak_akses = '"+hak_akses+"' where id_bagian_perkara = '"+id_bagian_perkara+"'";
                   
            Statement perintah = koneksi.createStatement();
            perintah.execute(sql);
             JOptionPane.showMessageDialog(null, "Data bagian perkara berhasil diubah");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
    }
     
      public void ubahBagianPerkara02(String id_bagian_perkara, String nama_lengkap, String username, String password, String hak_akses){
        try {
            String sql = "update bagian_perkara set nama_lengkap =?, username =?, password =?, hak_akses =? where id_bagian_perkara =?";
                   
            PreparedStatement perintah = koneksi.prepareStatement(sql);
            perintah.setString(1, nama_lengkap);
            perintah.setString(2, username);
            perintah.setString(3, password);
            perintah.setString(4, hak_akses);
            perintah.setString(5, id_bagian_perkara);
            
            perintah.executeUpdate();
             JOptionPane.showMessageDialog(null, "Data bagian perkara berhasil diubah");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
    }
      
       public void hapusBagianPerkara01(String id_bagian_perkara){
        try {
            String sql = "delete from bagian_perkara where id_bagian_perkara = '"+id_bagian_perkara+"'";
                   
            Statement perintah = koneksi.createStatement();
            perintah.execute(sql);
             JOptionPane.showMessageDialog(null, "Data bagian perkara berhasil dihapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
    }
       
       public void hapusBagianPerkara02(String id_bagian_perkara){
        try {
            String sql = "delete from bagian_perkara where id_bagian_perkara = ?";
                   
            PreparedStatement perintah = koneksi.prepareStatement(sql);
            perintah.setString(1, id_bagian_perkara);
            perintah.executeUpdate();
             JOptionPane.showMessageDialog(null, "Data bagian perkara berhasil dihapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
    }
       
      public void tampilDataBagianPerkara (JTable komponenTable, String SQL){
          try {
              Statement perintah = koneksi.createStatement();
              ResultSet data = perintah.executeQuery(SQL);
              ResultSetMetaData meta = data.getMetaData();
              int jumKolom = meta.getColumnCount();
              DefaultTableModel modelTable = new DefaultTableModel();
              modelTable.addColumn("ID Bagian Perkara");
              modelTable.addColumn("Nama Lengkap");
              modelTable.addColumn("Username");
              modelTable.addColumn("Password");
              modelTable.addColumn("Hak Akses");
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