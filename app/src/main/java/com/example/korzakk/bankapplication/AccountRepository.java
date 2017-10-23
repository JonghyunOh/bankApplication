package com.example.korzakk.bankapplication;

/**
 * Created by korza on 2017-10-23.
 */

public class AccountRepository {


    private AccountRepository instance = null;

    public AccountRepository getInstance(){
        if(instance==null){
            instance = new AccountRepository();
        }
        return instance;
    }



    private AccountRepository(){

    }

}
