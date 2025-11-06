package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public abstract class TransactionAnalyzer {

    // Поле форматера дати статичне
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    // Конструктор видалено, оскільки екземпляри не створюються

    // приймає список транзакцій
    public static double calculateTotalBalance(List<Transaction> transactions) {
        double balance = 0;
        for (Transaction transaction : transactions) {
            balance += transaction.getAmount(); // Використовуємо @Getter з Lombok
        }
        return balance;
    }

    // приймає список транзакцій
    public static int countTransactionsByMonth(List<Transaction> transactions, String monthYear) {
        int count = 0;
        for (Transaction transaction : transactions) {
            LocalDate date = LocalDate.parse(transaction.getDate(), dateFormatter); // Використовуємо @Getter
            String transactionMonthYear = date.format(DateTimeFormatter.ofPattern("MM-yyyy"));
            if (transactionMonthYear.equals(monthYear)) {
                count++;
            }
        }
        return count;
    }

    // приймає список транзакцій
    public static List<Transaction> findTopExpenses(List<Transaction> transactions) {
        return transactions.stream()
                .filter(t -> t.getAmount() < 0) // Використовуємо @Getter
                .sorted(Comparator.comparingDouble(Transaction::getAmount)) // Використовуємо @Getter
                .limit(10)
                .collect(Collectors.toList());
    }
}