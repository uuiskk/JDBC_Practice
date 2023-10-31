package com.nhnacademy.jdbc.bank.service;

import com.nhnacademy.jdbc.bank.domain.Account;

import java.sql.Connection;
import java.util.Optional;

public class BankService {

    public Optional<Account> findByAccountNumber(Connection connection, long accountNumber){
        //todo 계좌-조회
        String sql = "select ";
        return null;
    }

    public int saveAccount(Connection connection, Account account){
        //todo 계좌-등록
        return 0;
    }

    void deposit(Connection connection, long accountNumber, long amount){
        //todo 예금

    }

    void withdraw(Connection connection, long accountNumber, long amount){
        //todo 출금

    }

    void accountTransfer(Connection connection, long accountNumberFrom, long accountNumberTo, long amount){
        //todo 계좌 이체 accountNumberFrom -> accountNumberTo 으로 amount만큼 이체
    }
}