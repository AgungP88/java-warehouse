/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agung.controller;

import agung.model.modelTransaksi;
import agung.view.ViewTransaksi;

/**
 *
 * @author hp
 */
public class controllerTransaksi {
    //inisialisasi model
    private modelTransaksi mT;
    //inisialisasi view transaksi
    private ViewTransaksi vT;
    
    public controllerTransaksi(ViewTransaksi vT){
        this.vT = vT;
        
    }
    
    public void simpanTransaksi(){
        mT = new modelTransaksi();
        mT.setIdPelanggan(vT.getIdPelanggan().getText());
        mT.setNamaPelanggan(vT.getNamaPelanggan().getText());
        mT.setNamaBarang(vT.getNamaBarang().getText());
        mT.setQty(vT.getQty().getText());
        mT.setTotalBayar(vT.getTotalBayar().getText());
        mT.setUangBayar(vT.getUangBayar().getText());
        
        mT.simpanTransaksi();
    }
}
