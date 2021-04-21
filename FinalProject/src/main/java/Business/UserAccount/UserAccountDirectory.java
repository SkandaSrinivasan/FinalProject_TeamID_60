/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Role.Role;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Skanda
 */
public class UserAccountDirectory {
    List<UserAccount> users;
    
    public UserAccountDirectory(){
        this.users = new ArrayList<>();
    }
    
    public void addUser(String userName,String password,Role role){
        if(this.isUserUnique(userName)){
            UserAccount newAcc = new UserAccount(userName, password, role);
            this.users.add(newAcc);
        }
        else{
            JOptionPane.showMessageDialog(null, "User already exists","Error adding user",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public boolean isUserUnique(String uname){
        for(UserAccount user:this.users){
            if(user.getUserName().equals(uname)){
                return false;
            }
        }
        return true;
    }

    public UserAccount authenticateUser(String uname, String pass) {
        for(UserAccount user:this.users){
            if(user.getUserName().equals(uname) && user.getPassword().equals(pass)){
                return user;
            }
        }
        return null;
    }
    
}
