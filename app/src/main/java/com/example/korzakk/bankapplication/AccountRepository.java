package com.example.korzakk.bankapplication;

import java.util.HashMap;

/**
 * Created by korza on 2017-10-23.
 */

public class AccountRepository {


    private static AccountRepository instance = null;

    private HashMap<String, BankAccount> mAccountMap = null;

    public static AccountRepository getInstance(){
        if(instance==null){
            instance = new AccountRepository();
        }
        return instance;
    }



    private AccountRepository(){
        mAccountMap = new HashMap<String, BankAccount>();
    }

    public HashMap<String, BankAccount> getmAccountMap() {
        return mAccountMap;
    }
}
