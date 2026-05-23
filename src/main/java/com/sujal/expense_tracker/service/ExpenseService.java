package com.sujal.expense_tracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sujal.expense_tracker.entity.Expense;
import com.sujal.expense_tracker.repository.ExpenseRepository;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository repository;

    public Expense addExpense(Expense expense) {
        return repository.save(expense);
    }

    public List<Expense> getAllExpenses() {
        return repository.findAll();
    }

    public Expense getExpenseById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found"));
    }

    public Expense updateExpense(Long id, Expense expense) {
        Expense existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found"));

        existing.setTitle(expense.getTitle());
        existing.setAmount(expense.getAmount());
        existing.setCategory(expense.getCategory());
        existing.setDate(expense.getDate());

        return repository.save(existing);
    }

    public void deleteExpense(Long id) {
        repository.deleteById(id);
    }
}