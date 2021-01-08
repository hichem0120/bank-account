import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class TransactionTest {

    @Test
    public void check_to_print_method() {
        Transaction transaction = new Transaction(100, OperationType.DEPOSIT, LocalDate.of(2021, 1, 8 ), 0);

        assertEquals(transaction.toPrint(), "|2021-01-08|DEPOSIT|100|0|");
    }

    @Test
    public void should_return_positive_value_when_deposit() {
        Transaction transaction = new Transaction(1200, OperationType.DEPOSIT, LocalDate.of(2021, 1, 8 ), 0);

        assertEquals(new Integer(1200), transaction.addOrSubtractAmount());
    }


    @Test
    public void should_return_negative_value_when_deposit() {
        Transaction transaction = new Transaction(700, OperationType.WITHDRAW, LocalDate.of(2021, 1, 8 ), 0);

        assertEquals(new Integer(-700), transaction.addOrSubtractAmount());
    }

}
