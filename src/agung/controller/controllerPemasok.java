/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agung.controller;

import agung.model.modelPemasok;
import agung.view.ViewPemasokInternal;

/**
 *
 * @author hp
 */
public class controllerPemasok {
    private modelPemasok mP;
    private ViewPemasokInternal vP;

    public controllerPemasok(ViewPemasokInternal vP) {
        this.vP = vP;
    }
    
    public void bersihkan(){
        //pemanggilan variable object swing yang ada di view
        vP.getIdPemasokView().setText("");
        vP.getNamaPemasokView().setText("");
        vP.getNamaBarangView().setText("");
        vP.getJumlahView().setText("");
        vP.getAlamatPemasokView().setText("");
        
    }
    
    public void kontrolButton(){
        vP.getTombolSimpan().setEnabled(true);
        vP.getTombolHapus().setEnabled(false);
        vP.getTombolBatal().setEnabled(true);
        vP.getTombolEdit().setEnabled(false);
    }
    
    public void kontrolButtonDua(){
        vP.getTombolSimpan().setEnabled(false);
        vP.getTombolHapus().setEnabled(true);
        vP.getTombolBatal().setEnabled(true);
        vP.getTombolEdit().setEnabled(true);
    }
    
    public void deleteData(){
        mP = new modelPemasok();
        mP.setIdPemasok(vP.getIdPemasokView().getText());
        
        mP.deleteDataPemasok();
        bersihkan();
        kontrolButton();
    }
    
    public void updateData(){
        mP = new modelPemasok();
        mP.setIdPemasok(vP.getIdPemasokView().getText());
        
        mP.setNamaPemasok(vP.getNamaPemasokView().getText());
        mP.setNamaBarang(vP.getNamaBarangView().getText());
        
        mP.setJumlah(Integer.parseInt(vP.getJumlahView().getText()));
        mP.setAlamatPemasok(vP.getAlamatPemasokView().getText());
        mP.updateDataPemasok();
        bersihkan();
        kontrolButton();
    }
    
    public void simpan(){
        mP = new modelPemasok();
        
        mP.setNamaPemasok(vP.getNamaPemasokView().getText());
        mP.setNamaBarang(vP.getNamaBarangView().getText());
        
        mP.setJumlah(Integer.parseInt(vP.getJumlahView().getText()));
        mP.setAlamatPemasok(vP.getAlamatPemasokView().getText());
        
        mP.simpanDataPemasok();
        bersihkan();
        //JOptionPane.showConfirmDialog(vP, " Nama Pelanggan      : "+nP.getNamaPelanggan()+
        //        "\n Nomor HP        : "+nP.getNomorHp()+
        //        "\n Jenis Kelamin   : "+nP.getJenisKelamin()+
        //        "\n Umur        : "+nP.getUmur()+
        //        "\n Alamat      : "+nP.getAlamat());
        
    }
}
