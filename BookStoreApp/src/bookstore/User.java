/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

public class User {
    private String username;
    private String password;
    
    public User(String user, String pass) {
        this.username = user;
        this.password = pass;
    }
    
    public String getUsername() {   //returns value of username 
        return username;
    }
    
    public String getPassword() {   //returns value of password
        return password;
    }
    
    public void setUsername(String user) {    //set value of username to value of u parameter
        this.username = user;
    }
    
    public void setPassword(String user) {    //set value of password to value of u parameter
        this.password = user;
    }

}
