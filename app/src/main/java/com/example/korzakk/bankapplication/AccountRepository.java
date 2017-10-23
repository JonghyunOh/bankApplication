package com.example.korzakk.bankapplication;

import java.util.HashMap;

/**
 * Created by korza on 2017-10-23.
 */

public class AccountRepository {


    private AccountRepository instance = null;

    private HashMap<String, BankAccount> mAccountMap = null;

    public AccountRepository getInstance(){
        if(instance==null){
            instance = new AccountRepository();
        }
        return instance;
    }



    private AccountRepository(){

    }

}
