package com.example.korzakk.bankapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateAccountActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mID = null;
    private EditText mPass1 = null;
    private EditText mPass2 = null;
    private EditText mDeposit = null;

    private Button mResetBtn = null;
    private Button mSubmit = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        mID = (EditText)findViewById(R.id.idTxtID);
        mPass1 = (EditText)findViewById(R.id.passTxtID);
        mPass2 = (EditText)findViewById(R.id.confimTxtID);
        mDeposit = (EditText)findViewById(R.id.depositTxtID);

        mResetBtn = (Button)findViewById(R.id.resetBtnID);
        mSubmit = (Button)findViewById(R.id.submitBtnID);

        mResetBtn.setOnClickListener(this);
        mSubmit.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.resetBtnID:
                mID.setText("");
                mPass1.setText("");
                mPass2.setText("");
                mDeposit.setText("");
                break;
            case R.id.submitBtnID:
                String id = mID.getText().toString();
                String pass1 = mPass1.getText().toString();
                String pass2 = mPass2.getText().toString();
                String deposit = mDeposit.getText().toString();

                if(TextUtils.isEmpty(id) || TextUtils.isEmpty(pass1) ||
                        TextUtils.isEmpty(pass2) || TextUtils.isEmpty(deposit)){
                    Toast.makeText(CreateAccountActivity.this, "enter valid inputs...",
                            Toast.LENGTH_SHORT).show();
                }else{
                    BankAccount account = new BankAccount(id,pass1,pass2,deposit);
                    Intent intent = new Intent();
                    intent.putExtra("newMember",account);
                    setResult(RESULT_OK, intent);
                    finish();
                }
                break;
        }
    }
}
