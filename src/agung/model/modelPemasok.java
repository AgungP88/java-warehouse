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
public class modelPemasok {
    private String namaBarang;
    private String namaPemasok;
    private String alamatPemasok;
    private int jumlah;
    private String idPemasok;
    
    public String getIdPemasok() {
        return idPemasok;
    }

    public void setIdPemasok(String idPemasok) {
        this.idPemasok = idPemasok;
    }
    
    //inisialisasi class koneksi database
    KoneksiDatabase koneksi = new KoneksiDatabase();
    public modelPemasok() {
        
    }
    
    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getNamaPemasok() {
        return namaPemasok;
    }

    public void setNamaPemasok(String namaPemasok) {
        this.namaPemasok = namaPemasok;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public String getAlamatPemasok() {
        return alamatPemasok;
    }

    public void setAlamatPemasok(String alamatPemasok) {
        this.alamatPemasok = alamatPemasok;
    }
    
    public void simpanDataPemasok(){
        //inisialisasi query untuk insert kedalam database
        String sql = ("INSERT INTO pemasok (namaPemasok, namaBarang, jumlah, alamatPemasok)" 
                + "VALUES ('"+getNamaPemasok()+"', '"+getNamaBarang()+"', '"+getJumlah()+"'"
                + ", '"+getAlamatPemasok()+"')");
        
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
    
    public void deleteDataPemasok(){
        String sql = "DELETE FROM pemasok WHERE idPemasok = '"+getIdPemasok()+"'";
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
    
    public void updateDataPemasok(){
        //inisialisasi query untuk insert kedalam database
//        String sql = ("INSERT INTO pelanggan (namaPelanggan, noHp, jenisKelamin, umur, alamat)" 
//                + "VALUES ('"+getNamaPelanggan()+"', '"+getNomorHp()+"', '"+getJenisKelamin()+"'"
//                + ", '"+getUmur()+"', '"+getAlamat()+"')");
          String sql = "UPDATE pemasok SET namaPemasok = '"+getNamaPemasok()+"'"
                  + ",namaBarang = '"+getNamaBarang()+"'"
                  + ",jumlah = '"+getJumlah()+"'"
                  + ",alamatPemasok = '"+getAlamatPemasok()+"' WHERE idPemasok = '"+getIdPemasok()+"'";
        
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
