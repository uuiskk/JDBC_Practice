package com.nhnacademy.jdbc.bank.domain;

public class Account {

    //계좌번호, 편의를 위해서 1,2,3,4.... n+1 형태로 1씩 증가합니다. , AUTO INCREMENT Primary key
    private long accountNumber;
    //이름
    private String name;
    //잔고
    private long balance;

    public long getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public long getBalance() {
        return balance;
    }

    //예금
    public void deposit(int amount){
        this.balance += amount;
    }

    //출금
    public void withdraw(int amount){
        this.balance-=amount;
    }

}
