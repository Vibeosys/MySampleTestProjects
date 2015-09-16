package com.example.mahesh.hms;

/**
 * Created by mahesh on 9/16/2015.
 */
public class LoginCredentials {

    String user;
    String pass;
LoginCredentials(){

}
LoginCredentials(String _user,String _pass){
    this.user=_user;
    this.pass=_pass;
}
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }


}
