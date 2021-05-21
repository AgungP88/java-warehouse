/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agung.controller;

import agung.model.modelBarang;
import agung.view.ViewBarangInternal;



/**
 *
 * @author hp
 */
public class controllerBarang {
    private modelBarang mB;
    private ViewBarangInternal vB;

    public controllerBarang(ViewBarangInternal vB) {
        this.vB = vB;
    }
    
    public void bersihkan(){
        //pemanggilan variable object swing yang ada di view
        vB.getIdBarangView().setText("");
        vB.getNamaBarangView().setText("");
        vB.getJenisBarangView().setText("");
        vB.getSatuanView().setText("");
        vB.getUkuranView().setText("");
        vB.getHargaView().setText("");
        
    }
    
    public void kontrolButton(){
        vB.getTombolSimpan().setEnabled(true);
        vB.getTombolHapus().setEnabled(false);
        vB.getTombolBatal().setEnabled(true);
        vB.getTombolEdit().setEnabled(false);
    }
    
    public void kontrolButtonDua(){
        vB.getTombolSimpan().setEnabled(false);
        vB.getTombolHapus().setEnabled(true);
        vB.getTombolBatal().setEnabled(true);
        vB.getTombolEdit().setEnabled(true);
    }
    
    public void deleteData(){
        mB = new modelBarang();
        mB.setIdBarang(vB.getIdBarangView().getText());
        
        mB.deleteDataBarang();
        bersihkan();
        kontrolButton();
    }
    
    public void updateData(){
        mB = new modelBarang();
        mB.setIdBarang(vB.getIdBarangView().getText());
        
        mB.setNamaBarang(vB.getNamaBarangView().getText());
        mB.setJenisBarang(vB.getJenisBarangView().getText());
        
        mB.setSatuan((vB.getSatuanView().getText()));
        mB.setUkuran(vB.getUkuranView().getText());
        mB.setHarga(Integer.parseInt(vB.getHargaView().getText()));
        mB.updateDataBarang();
        bersihkan();
        kontrolButton();
    }
    
    public void simpan(){
        mB = new modelBarang();
        
        mB.setNamaBarang(vB.getNamaBarangView().getText());
        mB.setJenisBarang(vB.getJenisBarangView().getText());
        
        mB.setSatuan((vB.getSatuanView().getText()));
        mB.setUkuran(vB.getUkuranView().getText());
        mB.setHarga(Integer.parseInt(vB.getHargaView().getText()));
        
        mB.simpanDataBarang();
        bersihkan();
        //JOptionPane.showConfirmDialog(vP, " Nama Pelanggan      : "+nP.getNamaPelanggan()+
        //        "\n Nomor HP        : "+nP.getNomorHp()+
        //        "\n Jenis Kelamin   : "+nP.getJenisKelamin()+
        //        "\n Umur        : "+nP.getUmur()+
        //        "\n Alamat      : "+nP.getAlamat());
        
    }
}
