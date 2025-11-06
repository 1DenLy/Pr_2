package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter // Додає геттери для всіх полів (getDate, getAmount, getDescription)
@AllArgsConstructor // Додає конструктор з усіма параметрами
@ToString // Перевизначає метод toString() для зручного виводу
public class Transaction {
    private String date;
    private double amount;
    private String description;
}