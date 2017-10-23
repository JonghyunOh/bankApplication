package com.example.korzakk.bankapplication;

import java.io.Serializable;

/**
 * Created by korza on 2017-10-23.
 */

public class BankAccount implements Serializable{

    private String name = "";
    private String id = "";
    private String pass = "";
    private String balance = "";

    @Override
    public String toString() {
        return "BankAccount{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", pass='" + pass + '\'' +
                ", balance='" + balance + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BankAccount that = (BankAccount) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (pass != null ? !pass.equals(that.pass) : that.pass != null) return false;
        return balance != null ? balance.equals(that.balance) : that.balance == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (pass != null ? pass.hashCode() : 0);
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        return result;
    }

    public BankAccount(String name, String id, String pass, String balance) {
        this.name = name;
        this.id = id;
        this.pass = pass;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }
}
