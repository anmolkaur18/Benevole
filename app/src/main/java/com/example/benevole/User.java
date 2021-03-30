package com.example.benevole;
import android.view.ViewDebug;

import com.google.firebase.database.PropertyName;


    public class User{
    String username, email, phoneNo, password;

    @PropertyName("username")
    public String getUsername() {
        return username;
    }

    @PropertyName("email")
    public String getEmail() {
        return email;
    }

    @PropertyName("phoneNo")
    public String getPhoneNo() {
        return phoneNo;
    }

    @PropertyName("password")
    public String getPassword(){
        return password;
    }
}

