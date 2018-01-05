package com.example.yaeli.smart_buy;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class loginActivity extends AppCompatActivity implements View.OnClickListener{
    private static Button login;
    private static EditText userName;
    private static EditText password;
    public static TextView msg_login;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login=(Button) findViewById(R.id.login);
        userName= (EditText) findViewById(R.id.user);
        password=(EditText) findViewById(R.id.pass);
        msg_login=(TextView) findViewById(R.id.msg);
        msg_login.setText("Please Login your account");
        login.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

        if(signin.userLocalStore==null){
            msg_login.setText("You are not registered");
            signin_btnFragment fm=new signin_btnFragment();
            fragmentTransaction.add(R.id.signin_btnFragment,fm);
            fragmentTransaction.commit();
        }
        else {
            if (!signin.userLocalStore.getUserData().userName.equals(userName.getText().toString())) {
                msg_login.setText("Wrong userName!");

            } else if (!signin.userLocalStore.getUserData().password.equals(password.getText().toString())) {
                msg_login.setText("Wrong password");
            } else {
                Intent intent = new Intent("com.example.yaeli.smart_buy.RegisteredActivity");
                startActivity(intent);

            }
            //checkdsaD
            //LKFSDJL
        }
    }
}
