import org.example.Transaction;
import org.example.TransactionAnalyzer;
import org.example.TransactionCSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class TransactionCSVReaderTest {

    @Test
    public void testReadTransactionsFromRemoteCSV() {
        // URL  Main
        String filePath = "https://informer.com.ua/dut/java/pr2.csv";

        List<Transaction> transactions = TransactionCSVReader.readTransactions(filePath);

        // Перевірки
        Assertions.assertNotNull(transactions, "Список транзакцій не повинен бути null");
        Assertions.assertFalse(transactions.isEmpty(), "Список транзакцій не повинен бути порожнім");

        Transaction first = transactions.get(0);
        Assertions.assertNotNull(first.getDate(), "Дата не повинна бути null");
        Assertions.assertTrue(first.getAmount() != 0, "Сума не повинна бути 0");
        Assertions.assertNotNull(first.getDescription(), "Опис не повинен бути null");
    }

    @Test
    public void testFindTopExpenses() {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("01-01-2023", -100.0, "Продукти"),
                new Transaction("02-01-2023", -200.0, "Оренда"),
                new Transaction("03-01-2023", -50.0, "Транспорт"),
                new Transaction("04-01-2023", -300.0, "Одяг"),
                new Transaction("05-01-2023", -10.0, "Кава")
        );


        List<Transaction> topExpenses = TransactionAnalyzer.findTopExpenses(transactions);

        // Перевірки
        Assertions.assertEquals(5, topExpenses.size());
        Assertions.assertEquals(-300.0, topExpenses.get(0).getAmount(), "Найбільша витрата повинна бути першою");
    }
}