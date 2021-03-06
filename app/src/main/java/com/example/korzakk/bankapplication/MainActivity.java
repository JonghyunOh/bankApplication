 package com.example.korzakk.bankapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

 public class MainActivity extends AppCompatActivity implements View.OnClickListener {


     private AccountRepository mAccountRepo = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAccountRepo = AccountRepository.getInstance();

        Button mCreateBtn = (Button)findViewById(R.id.createBtnID);
        Button mCheckeBtn = (Button)findViewById(R.id.checkBtnID);
        Button mAdminBtn = (Button)findViewById(R.id.adminBtnID);
        Button mExitBtn = (Button)findViewById(R.id.exitBtnID);

        mCreateBtn.setOnClickListener(this);
        mCheckeBtn.setOnClickListener(this);
        mAdminBtn.setOnClickListener(this);
        mExitBtn.setOnClickListener(this);
    }

     @Override
     public void onClick(View view) {
        switch(view.getId()){
            case R.id.createBtnID:
                Intent intentCreate = new Intent(this, CreateAccountActivity.class);
                startActivityForResult(intentCreate, 1000);
                break;
            case R.id.checkBtnID:
                Intent intentCheck = new Intent(this, CheckAccountActivity.class);
                intentCheck.putExtra("data",mAccountRepo.getmAccountMap());
                startActivity(intentCheck);
                break;
            case R.id.adminBtnID:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Administrator mode");
                builder.setView((R.layout.dialog_admin));
                builder.setPositiveButton("login", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.setNegativeButton("Close", null);
                builder.show();
                break;
            case R.id.exitBtnID:
                break;

        }
     }

     @Override
     protected void onActivityResult(int requestCode, int resultCode, Intent data) {
         super.onActivityResult(requestCode, resultCode, data);

         if((requestCode == 1000) && (resultCode == RESULT_OK)){
             if(data != null){
                 BankAccount account = (BankAccount)data.getSerializableExtra("newMember");
                 mAccountRepo.getmAccountMap().put(account.getId(), account);
                 Toast.makeText(MainActivity.this, "new member is added!", Toast.LENGTH_SHORT).show();
             }

         }
     }
 }
