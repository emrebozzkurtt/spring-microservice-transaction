package com.emrebozzkurtt.microservicetransaction.controller;

import com.emrebozzkurtt.microservicetransaction.model.Transaction;
import com.emrebozzkurtt.microservicetransaction.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/transaction")
public class TransactionController {

    @Autowired
    private ITransactionService transactionService;

    @PostMapping(value = "/addTransaction")
    public ResponseEntity<?> addTransaction(Transaction transaction){
        return new ResponseEntity<>(transactionService.saveTransaction(transaction), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/deleteTransaction/{id}")
    public ResponseEntity<?> deleteTransaction(@PathVariable Long id){
        transactionService.deleteTransaction(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/transactions/{userId}")
    public ResponseEntity<?> getAllTransactionOfUser(@PathVariable Long userId){
        return ResponseEntity.ok(transactionService.findAllTransactionOfUser(userId));
    }

    @GetMapping(value = "/transactions")
    public ResponseEntity<?> getAllTransaction(){
        return ResponseEntity.ok(transactionService.findAllTransaction());
    }
}
