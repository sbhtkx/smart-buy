package com.example.yaeli.smart_buy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class myAccount extends AppCompatActivity {
    TextView firstName;
    TextView lastName;
    TextView street;
    TextView city;
    TextView Email;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);
        firstName=(TextView) findViewById(R.id.name);
        lastName=(TextView) findViewById(R.id.lastName);
        street=(TextView) findViewById(R.id.street);
        city=(TextView) findViewById(R.id.city);
        Email=(TextView) findViewById(R.id.email);
        img=(ImageView) findViewById(R.id.pic);
        String name=signin.userLocalStore.getUserData().firstname;
        firstName.setText("First Name: "+name);
        String last_name=signin.userLocalStore.getUserData().lastName;
        lastName.setText("Last Name: "+last_name);
        String _street=signin.userLocalStore.getUserData().address;
        street.setText("Street: "+_street);
        String _city=signin.userLocalStore.getUserData().city;
        city.setText("City: "+_city);
        String _email=signin.userLocalStore.getUserData().Email;
        Email.setText("Email: "+_email);
        if(Photo.pic_location!=null){
            img.setImageURI(Photo.pic_location);
        }

    }
}
