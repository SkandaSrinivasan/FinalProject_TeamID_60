/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Role.Role;

/**
 *
 * @author Skanda
 */
public class UserAccount {

    String userName;
    String password;
    Role userRole;

    public UserAccount(String userName, String password, Role usrRole) {
        this.userName = userName;
        this.password = password;
        this.userRole = usrRole;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getUserRole() {
        return userRole;
    }

    public void setUserRole(Role userRole) {
        this.userRole = userRole;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof UserAccount)) {
            return false;
        }
        UserAccount ua = (UserAccount) o;
        return this.getUserName().equals(ua.getUserName());
    }
}
