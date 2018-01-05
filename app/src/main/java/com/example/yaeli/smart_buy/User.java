package com.example.yaeli.smart_buy;

/**
 * Created by yaeli on 30/11/2017.
 */

public class User {
    String firstname, lastName, userName, password, address,city,Email;
    //public static boolean permissionIsGranted=false;

    public User(String userName, String password, String firstName,String lastName, String address, String city, String Email){
        this.userName=userName;
        this.password=password;
        this.firstname=firstName;
        this.lastName=lastName;
        this.address=address;
        this.city=city;
        this.Email=Email;
    }

    public User(String userName, String password, String firstName,String lastName, String city, String Email){
        this.userName=userName;
        this.password=password;
        this.firstname=firstName;
        this.lastName=lastName;
        this.city=city;
        this.Email=Email;
    }










}
