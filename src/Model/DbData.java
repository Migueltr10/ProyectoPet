/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Aprendiz
 */
public class DbData {
    private final String Drive = "com.mysql.jdbc.Drive";
    private final String url = "jdbc:mysql://localhost:3306/petmanagerdb";
    private final String user = "root";
    private final String pass = "";

    /**
     * @return the Drive
     */
    public String getDrive() {
        return Drive;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }
    
    
    
    
    
}



