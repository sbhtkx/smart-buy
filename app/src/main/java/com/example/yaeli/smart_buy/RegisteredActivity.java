package com.example.yaeli.smart_buy;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;


public class RegisteredActivity extends AppCompatActivity implements View.OnClickListener{
    private static TextView hello;
    private static Spinner spinner;
    private static Button logout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered);
        hello=(TextView) findViewById(R.id.hello);
        logout=(Button) findViewById(R.id.logout);
        hello.setText("Hello "+signin.userLocalStore.getUserData().userName+",");

        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        MainFragment mf=new MainFragment();
        fragmentTransaction.add(R.id.fragment_container,mf);

        hello.setOnClickListener(this);
        logout.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case(R.id.hello):
                Intent intent= new Intent("com.example.yaeli.smart_buy.myAccount");
                startActivity(intent);
                break;

            case(R.id.logout):
                Intent intent1= new Intent("com.example.yaeli.smart_buy.MainActivity");
                startActivity(intent1);
                break;
        }


    }
}
