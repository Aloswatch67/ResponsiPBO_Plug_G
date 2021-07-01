/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JOptionPane;
import model.Aset;

/**
 *
 * @author edlan
 */
public class Controller
{
   Aset aset;
   boolean status = false;
   int index;
   Object[][] asets = new Object[100][4];
    public Controller(Aset aset)
    {
       this.aset = aset;
    }
    
    public Object[][] index()
    {
       asets = aset.getAset();
       return asets;
    } 
    
    public void cek(String data)
    {        
        for (int i = 0; asets[i][0] != null; i++) 
        {
            if(asets[i][0].toString().equals(data))
            {
                status = true;
                index = i;
                break;
            }
        }
    }
    
    public void tambah(String nama_aset, double jumlah_aset, double harga_aset)
    {
        cek(nama_aset);
        
        if(status)
        {
            JOptionPane.showMessageDialog(null,"Aset sudah ada!");
        } 
        
        else 
        {
            aset.tambah(nama_aset, jumlah_aset, harga_aset);
            JOptionPane.showMessageDialog(null,"Berhasil menambahkan aset!");
            
        }
    }
    
    public void ubah(String nama_aset, double jumlah_aset, double harga_aset)
    {
        cek(nama_aset);
        
        if(status)
        {       
                aset.ubah(asets[index][0].toString(), jumlah_aset, harga_aset);
                JOptionPane.showMessageDialog(null,"Berhasil memperbaharui aset!");
        }
        
        else
        {
           JOptionPane.showMessageDialog(null,"Pilih aset!"); 
        }
    }
    
    public void hapus(String nama_aset)
    {
        cek(nama_aset);
        
        if(status)
        {
            aset.hapus(asets[index][0].toString());
            JOptionPane.showMessageDialog(null,"Berhasil menghapus aset!");
        }
        
        else
        {
           JOptionPane.showMessageDialog(null,"Aset tidak ada!"); 
        }
    }
}
