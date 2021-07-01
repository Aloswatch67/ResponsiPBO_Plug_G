/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import model.Db;
import view.Tampil_aset;

/**
 *
 * @author edlan
 */
public class Main 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        Db DB = new Db();
        Tampil_aset viewhome = new Tampil_aset(DB);
        viewhome.setVisible(true);
    }
    
}
