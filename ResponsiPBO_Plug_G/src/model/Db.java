/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.Connection; 
import java.sql.Statement;

/**
 *
 * @author edlan
 */
public class Db 
{
    public Connection connection;
    public Statement statement;
    
    public Db()
    {  
        try
        {  
           connection = DriverManager.getConnection("jdbc:mysql://localhost/aset_db","root","");
        }
        
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Failed to connect database!"); 
        }  
    }
}
