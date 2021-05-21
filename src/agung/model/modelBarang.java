/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agung.model;

import agung.db.KoneksiDatabase;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class modelBarang {
    private String namaBarang;
    private String jenisBarang;
    private String satuan;
    private String ukuran;
    private int harga;
    private String idBarang;
    
    //hasil generate untuk idPelanggan
    public String getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(String idBarang) {
        this.idBarang = idBarang;
    }
    
    //inisialisasi class koneksi database
    KoneksiDatabase koneksi = new KoneksiDatabase();
    public modelBarang() {
        
    }
    
    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getJenisBarang() {
        return jenisBarang;
    }

    public void setJenisBarang(String jenisBarang) {
        this.jenisBarang = jenisBarang;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getUkuran() {
        return ukuran;
    }

    public void setUkuran(String ukuran) {
        this.ukuran = ukuran;
    }
    
    public void simpanDataBarang(){
        //inisialisasi query untuk insert kedalam database
        String sql = ("INSERT INTO barang (namaBarang, jenisBarang, satuan, ukuran, harga)" 
                + "VALUES ('"+getNamaBarang()+"', '"+getJenisBarang()+"', '"+getSatuan()+"'"
                + ", '"+getUkuran()+"', '"+getHarga()+"')");
        
        try {
            //inisialisasi preparedstatmen
            PreparedStatement eksekusi = koneksi. getKoneksi().prepareStatement(sql);
            eksekusi.execute();
            
            //pemberitahuan jika data berhasil di simpan
            JOptionPane.showMessageDialog(null,"Data Berhasil Disimpan");
        } catch (SQLException ex) {
            //Logger.getLogger(modelPelanggan.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan \n"+ex);
        }
    }
    
    public void deleteDataBarang(){
        String sql = "DELETE FROM barang WHERE idBarang = '"+getIdBarang()+"'";
        try {
            //inisialisasi preparedstatmen
            PreparedStatement eksekusi = koneksi. getKoneksi().prepareStatement(sql);
            eksekusi.execute();
            
            //pemberitahuan jika data berhasil di simpan
            JOptionPane.showMessageDialog(null,"Data Berhasil Dihapus");
        } catch (SQLException ex) {
            //Logger.getLogger(modelPelanggan.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Data Gagal Dihapus \n"+ex);
        }
    }
    
    public void updateDataBarang(){
        //inisialisasi query untuk insert kedalam database
//        String sql = ("INSERT INTO pelanggan (namaPelanggan, noHp, jenisKelamin, umur, alamat)" 
//                + "VALUES ('"+getNamaPelanggan()+"', '"+getNomorHp()+"', '"+getJenisKelamin()+"'"
//                + ", '"+getUmur()+"', '"+getAlamat()+"')");
          String sql = "UPDATE barang SET namaBarang = '"+getNamaBarang()+"'"
                  + ",jenisBarang = '"+getJenisBarang()+"'"
                  + ",satuan = '"+getSatuan()+"'"
                  + ",ukuran = '"+getUkuran()+"'"
                  + ",harga = '"+getHarga()+"' WHERE idBarang = '"+getIdBarang()+"'";
        
        try {
            //inisialisasi preparedstatmen
            PreparedStatement eksekusi = koneksi. getKoneksi().prepareStatement(sql);
            eksekusi.execute();
            
            //pemberitahuan jika data berhasil di simpan
            JOptionPane.showMessageDialog(null,"Data Berhasil Disimpan");
        } catch (SQLException ex) {
            //Logger.getLogger(modelPelanggan.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan \n"+ex);
        }
    }
}
