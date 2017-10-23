package com.example.korzakk.bankapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.HashMap;

public class CheckAccountActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mID = null;
    private EditText mPass = null;
    private Button mLoginBtn = null;
    private Button mCloseBtn = null;
    private TextView mResultTxt = null;

    private HashMap<String, BankAccount> mMap = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_account);

        mID = (EditText)findViewById(R.id.idFieldID);
        mPass = (EditText)findViewById(R.id.passFieldID);
        mLoginBtn = (Button)findViewById(R.id.loginBtnID);
        mCloseBtn = (Button)findViewById(R.id.checkFinishBtnID);
        mResultTxt = (TextView)findViewById(R.id.checkResultTxtID);

        mLoginBtn.setOnClickListener(this);
        mCloseBtn.setOnClickListener(this);

        Intent intent = getIntent();
        if(intent != null){
            mMap = (HashMap<String, BankAccount>)intent.getSerializableExtra("data");
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.loginBtnID:
                String id = mID.getText().toString();
                String pass = mPass.getText().toString();
                if(TextUtils.isEmpty(id) || TextUtils.isEmpty(pass)){
                    Toast.makeText(CheckAccountActivity.this, "type valid inputs!", Toast.LENGTH_SHORT).show();
                }else{
                    if(mMap.containsKey(id)){
                        BankAccount account = mMap.get(id);
                        if(account.getPass().equals(pass)){
                            mResultTxt.setText(account.toString());
                        }else{
                            Toast.makeText(CheckAccountActivity.this, "invalid password!", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(CheckAccountActivity.this, "There is no account like that.", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            case R.id.checkFinishBtnID:
                finish();
                break;
        }
    }
}
