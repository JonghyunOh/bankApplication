 package com.example.korzakk.bankapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

 public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mCreateBtn = (Button)findViewById(R.id.createBtnID);
        Button mCheckeBtn = (Button)        findViewById(R.id.checkBtnID);
        Button mAdminBtn = (Button)findViewById(R.id.adminBtnID);
        Button mExitBtn = (Button)findViewById(R.id.exitBtnID);

        mCheckeBtn.setOnClickListener(this);
        mCheckeBtn.setOnClickListener(this);
        mAdminBtn.setOnClickListener(this);
        mExitBtn.setOnClickListener(this);
    }

     @Override
     public void onClick(View view) {
        switch(view.getId()){
            case R.id.createBtnID:
                Intent intent = new Intent(this, CreateAccountActivity.class);
                startActivity(intent);
                break;
            case R.id.checkBtnID:
                break;
            case R.id.adminBtnID:
                break;
            case R.id.exitBtnID:
                break;

        }
     }
 }
