package com.example.yaeli.smart_buy;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class signin extends AppCompatActivity implements View.OnClickListener{
    private static EditText userName;
    private static EditText password;
    private static EditText firstName;
    private static EditText lastName;
    private static EditText address;
    private static EditText city;
    private static EditText Email;
    private static TextView msg;


    private static Button nextBtn;

    public static UserLocalStore userLocalStore=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        nextBtn= (Button) findViewById(R.id.next);
        userName= (EditText) findViewById(R.id.userName);
        password= (EditText) findViewById(R.id.password);
        firstName= (EditText) findViewById(R.id.name);
        lastName= (EditText) findViewById(R.id.lastName);
        address= (EditText) findViewById(R.id.street);
        city= (EditText) findViewById(R.id.city);
        Email= (EditText) findViewById(R.id.Email);
        msg= (TextView) findViewById(R.id.msg);
        userLocalStore=new UserLocalStore(this);
        nextBtn.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
//        if( (userName.getText().toString().length()==0) ){
//            msg.setText("userName must contain character");
//        }
//        else if(password.getText().toString().length()<8){
//            msg.setText("password must contain 8 characters");
//        }
//
//        else {
//            if( (firstName.getText().length()==0)|| (lastName.getText().length()==0)||(city.getText().length()==0)||(Email.getText().length()==0) ){
//                msg.setText("check requires fields");
//            }
//            else{
//            if(address.getText().length()==0){
//                address.setText("*UNKNOWN*");
//                address.setTextColor(Color.RED);
//            }
            User user = new User(userName.getText().toString(), password.getText().toString(), firstName.getText().toString(), lastName.getText().toString(), address.getText().toString(), city.getText().toString(), Email.getText().toString());
            userLocalStore.storeUserData(user, this);
            Intent intent = new Intent("com.example.yaeli.smart_buy.Photo");
            startActivity(intent);
            }
//        }
//    }

}
