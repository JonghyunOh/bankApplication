package com.example.korzakk.bankapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
                break;
        }
    }
}
