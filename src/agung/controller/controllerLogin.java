/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agung.controller;

import agung.model.modelLogin;
import agung.view.ViewLogin;

/**
 *
 * @author hp
 */
public class controllerLogin {
    private modelLogin mL;
    private ViewLogin vL;
    
    public controllerLogin(ViewLogin vL){
        this.vL = vL;
    }
    
    public void loginUser(){
        mL = new modelLogin();
        mL.setUsername(vL.getUsername().getText());
        mL.setPassword(vL.getPassword().getText());
        
        mL.login();
    }
}
