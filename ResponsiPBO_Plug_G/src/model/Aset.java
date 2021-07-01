/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author edlan
 */
public class Aset extends Model
{
    
    public Aset(Db DB)
    {
        this.DB = DB;
    }
    
    public Object[][] getAset()
    {
        Object[][] aset = new Object[100][5];
        try
        {
            DB.statement = DB.connection.createStatement();
            ResultSet result = DB.statement.executeQuery("SELECT * FROM `aset`");
            
            int i = 0;
            while(result.next())
            {
                aset[i][0] = result.getString("nama_aset");
                aset[i][1] = result.getString("jumlah_aset");
                aset[i][2] = result.getString("harga_aset");
                aset[i][3] = result.getString("nilai_aset");
                i++;
            }
            DB.statement.close();
        } 
        
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Database Error");
        }
        return aset;
    }
    
    public void tambah(String nama_aset, double jumlah_aset, double harga_aset)
    {
        try
        {
            double nilai = jumlah_aset*harga_aset;
            DB.statement = DB.connection.createStatement(); 
            String query = "INSERT INTO `aset` (`nama_aset`, `jumlah_aset`, `harga_aset`, `nilai_aset`) "
                    + "VALUES ('"+ nama_aset +"', '"+ jumlah_aset +"', '"+harga_aset+"', '"+nilai+"')";
            DB.statement.execute(query);
        }
        
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Database Error");
        }
    }
    
    public void ubah(String nama_aset, double jumlah_aset, double harga_aset)
    {
        try
        {
            double nilai = jumlah_aset*harga_aset;
            DB.statement = DB.connection.createStatement(); 
            String query = "UPDATE `aset` SET `jumlah_aset` = '"+jumlah_aset+"', `harga_aset` = '"+harga_aset+"', `nilai_aset` = '" + nilai + "' WHERE `aset`.`nama_aset` = '" + nama_aset + "'";
            DB.statement.execute(query);
        }
        
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Database Error");
        }
    }
    
    public void hapus(String nama_aset)
    {
        try
        {
            DB.statement = DB.connection.createStatement(); 
            String query = "DELETE FROM `aset` WHERE `aset`.`nama_aset` = \'"+nama_aset+"\'";
            DB.statement.execute(query);
        }
        
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Database Error");
        }
    }
    
}
