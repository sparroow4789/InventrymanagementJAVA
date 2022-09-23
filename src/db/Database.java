
package db;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Amazoft
 */
public class Database {
    
    private static Connection Con = null;
    private static ResultSet Rs = null;
    
    public static Connection getConnection(){
    
        
        if(Con == null){
        
            try{
                Con = DriverManager.getConnection("jdbc:derby://localhost:1527/Inventrydb", "root", "root");
            }catch(SQLException e){
                e.printStackTrace();
            }
           
        }
    
        return Con;
    }
    
    
    
    
    public static boolean saveData(String query){
        
        boolean isSaved = false;
        
        try {
            
            if(getConnection().createStatement().executeUpdate(query) == 1){
                isSaved = true;
            }else{
                isSaved = false;
            }
            
            
        } catch (SQLException ex) {
            isSaved = false;
            ex.printStackTrace();
        }
    
    
    return isSaved;
    
    }
    
    
    public static ResultSet getData(String query){
    
    
        try {
            Rs = getConnection().createStatement().executeQuery(query);
            return Rs;
        } catch (SQLException ex) {
            
            ex.printStackTrace();
            return null;
        }
        
        
        
       
        
    }
    
    
    
    
}
