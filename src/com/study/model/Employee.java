package com.study.model;

/**
 * Created by 龚健
 *  2017/12/19.
 */
public class Employee {
    private String account;
    private String password;

    public Employee(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return account + "   " + password;
    }
}
