package com.emrebozzkurtt.microservicetransaction.service;

import com.emrebozzkurtt.microservicetransaction.model.Transaction;

import java.util.List;

public interface ITransactionService{

    Transaction saveTransaction(Transaction transaction);
    void deleteTransaction(Long id);
    List<Transaction> findAllTransaction();
    List<Transaction> findAllTransactionOfUser(Long userId);
}
