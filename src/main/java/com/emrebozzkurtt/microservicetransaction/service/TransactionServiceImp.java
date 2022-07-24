package com.emrebozzkurtt.microservicetransaction.service;

import com.emrebozzkurtt.microservicetransaction.model.Transaction;
import com.emrebozzkurtt.microservicetransaction.repository.ITransactionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionServiceImp implements ITransactionService{

    private final ITransactionRepository transactionRepository;

    public TransactionServiceImp(ITransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction saveTransaction(Transaction transaction) {
        transaction.setTransactionTime(LocalDateTime.now());
        return transactionRepository.save(transaction);
    }

    @Override
    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }

    @Override
    public List<Transaction> findAllTransaction() {
        return transactionRepository.findAll();
    }

    @Override
    public List<Transaction> findAllTransactionOfUser(Long userId) {
        return transactionRepository.findAllByUserId(userId);
    }
}
