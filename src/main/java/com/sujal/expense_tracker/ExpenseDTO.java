package com.sujal.expense_tracker;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ExpenseDTO {

    @NotBlank(message = "Title is required")
    public String title;

    @NotNull(message = "Amount is required")
    public Double amount;

    @NotBlank(message = "Category is required")
    public String category;

    @NotNull(message = "Date is required")
    public LocalDate date;
}