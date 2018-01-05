package com.example.yaeli.smart_buy;

import android.content.Intent;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends  AppCompatActivity implements View.OnClickListener {
    private static Button loginBtn;
    private static Button signInBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginBtn= (Button) findViewById(R.id.Login);
        signInBtn= (Button) findViewById(R.id.Signin);
        loginBtn.setOnClickListener(this);
        signInBtn.setOnClickListener(this);

        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        Fragment fragment;
        MainFragment mf=new MainFragment();
        fragmentTransaction.add(R.id.fragment_container,mf);

    }



    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case(R.id.Signin):
                Intent intent= new Intent("com.example.yaeli.smart_buy.signin");
                startActivity(intent);
                break;

            case(R.id.Login):
                Intent intent1=new Intent("com.example.yaeli.smart_buy.loginActivity");
                startActivity(intent1);
                break;
        }
    }
}
