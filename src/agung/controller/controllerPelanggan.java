/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agung.controller;

import agung.model.modelPelanggan;
import agung.view.ViewPelangganInternal;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class controllerPelanggan {
    private modelPelanggan nP;
    private ViewPelangganInternal vP;

    public controllerPelanggan(ViewPelangganInternal vP) {
        this.vP = vP;
    }  
    
    public void bersihkan(){
        //pemanggilan variable object swing yang ada di view
        vP.getIdPelangganView().setText("");
        vP.getNamaPelangganView().setText("");
        vP.getNoHpview().setText("");
        vP.getUmurview().setText("");
        vP.getAlamatView().setText("");
        
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
        nP = new modelPelanggan();
        nP.setIdPelanggan(vP.getIdPelangganView().getText());
        
        nP.deleteDataPelanggan();
        bersihkan();
        kontrolButton();
    }
    
    public void updateData(){
        nP = new modelPelanggan();
        nP.setIdPelanggan(vP.getIdPelangganView().getText());
        
        nP.setNamaPelanggan(vP.getNamaPelangganView().getText());
        nP.setNomorHp(vP.getNoHpview().getText());
        
        if(vP.getPriaView().isSelected()){
            nP.setJenisKelamin("Pria");
        }else if(vP.getWanitaView().isSelected()){
            nP.setJenisKelamin("Wanita");
        }
        
        nP.setUmur(Integer.parseInt(vP.getUmurview().getText()));
        nP.setAlamat(vP.getAlamatView().getText());
        nP.updateDataPelanggan();
        bersihkan();
        kontrolButton();
    }
    
    public void simpan(){
        nP = new modelPelanggan();
        
        nP.setNamaPelanggan(vP.getNamaPelangganView().getText());
        nP.setNomorHp(vP.getNoHpview().getText());
        
        if(vP.getPriaView().isSelected()){
            nP.setJenisKelamin("Pria");
        }else if(vP.getWanitaView().isSelected()){
            nP.setJenisKelamin("Wanita");
        }
        
        nP.setUmur(Integer.parseInt(vP.getUmurview().getText()));
        nP.setAlamat(vP.getAlamatView().getText());
        
        nP.simpanDataPelanggan();
        bersihkan();
        //JOptionPane.showConfirmDialog(vP, " Nama Pelanggan      : "+nP.getNamaPelanggan()+
        //        "\n Nomor HP        : "+nP.getNomorHp()+
        //        "\n Jenis Kelamin   : "+nP.getJenisKelamin()+
        //        "\n Umur        : "+nP.getUmur()+
        //        "\n Alamat      : "+nP.getAlamat());
        
    }
}
