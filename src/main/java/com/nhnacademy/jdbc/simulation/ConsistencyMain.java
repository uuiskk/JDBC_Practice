package com.nhnacademy.jdbc.simulation;

import com.nhnacademy.jdbc.bank.domain.Account;
import com.nhnacademy.jdbc.bank.repository.impl.AccountRepositoryImpl;
import com.nhnacademy.jdbc.bank.service.BankService;
import com.nhnacademy.jdbc.bank.service.impl.BankServiceImpl;
import com.nhnacademy.jdbc.util.DbUtils;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.SQLException;

@Slf4j
public class ConsistencyMain {
    public static void main(String[] args) throws SQLException {
        BankService bankService = new BankServiceImpl(new AccountRepositoryImpl());

        Connection connection = DbUtils.getDataSource().getConnection();
        connection.setAutoCommit(false);

        try {

            Account account1 = new Account(8000, "nhn아카데미", 10_0000);
            //todo#1 계좌번호가 8000인 account1 생성
            bankService.createAccount(connection, account1);

            //todo#2 계좌번호가 8000인 account2생성
            Account account2 = new Account(8000, "nhn아카데미", 10_0000);
            bankService.createAccount(connection, account2);

            connection.commit();
        }catch (Exception e){
            log.error("error:{}", e);
            //todo#3 account_number(계좌번호) primary key 제약조건 위배. -> rollback
            connection.rollback();
        }

        connection.close();
    }
}
