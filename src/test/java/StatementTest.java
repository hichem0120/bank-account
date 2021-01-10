import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class StatementTest {

    @Mock
    private Printer printer;

    @Mock
    private Clock clock;

    @Before
    public void setUp() throws Exception {

        given(clock.getTodayDate()).willReturn(LocalDate.of(2021, 1, 7));

    }

    @Test
    public void should_print_no_transactions_when_no_transactions() {
        Account account = new Account(new Statement());
        account.printTransactions(printer);
        verify(printer).print("No Transactions");
    }


    @Test
    public void should_print_deposit_transaction() {
        Statement statement = new Statement(clock);
        Account account = new Account(statement);
        account.deposit(500);
        account.printTransactions(printer);

        InOrder inOrder = inOrder(printer);
        inOrder.verify(printer).print("|2021-01-07|DEPOSIT|500|0|");
    }


    @Test
    public void should_print_withdraw_transaction() {
        Statement statement = new Statement(clock);
        Account account = new Account(statement, 100);
        account.withdraw(50);
        account.printTransactions(printer);

        InOrder inOrder = inOrder(printer);
        inOrder.verify(printer).print("|2021-01-07|DEPOSIT|100|0|");
        inOrder.verify(printer).print("|2021-01-07|WITHDRAW|50|100|");
    }

    @Test
    public void should_print_all_transactions_when_multiple_transactions() {
        Statement statement = new Statement(clock);
        Account account = new Account(statement);
        account.deposit(2000);
        account.withdraw(1200);
        account.withdraw(100);
        account.printTransactions(printer);

        InOrder inOrder = inOrder(printer);
        inOrder.verify(printer).print("|2021-01-07|DEPOSIT|2000|0|");
        inOrder.verify(printer).print("|2021-01-07|WITHDRAW|1200|2000|");
        inOrder.verify(printer).print("|2021-01-07|WITHDRAW|100|800|");

    }

    @Test
    public void should_print_current_balance_after_deposit() {
        Statement statement = new Statement(clock);
        Account account = new Account(statement);
        account.deposit(500);

        account.printCurrentBalance(printer);

        InOrder inOrder = inOrder(printer);
        inOrder.verify(printer).print("Your current balance is : 500");
    }

    @Test
    public void should_print_zero_balance_when_empty_account() {
        Statement statement = new Statement(clock);
        Account account = new Account(statement);

        account.printCurrentBalance(printer);

        InOrder inOrder = inOrder(printer);
        inOrder.verify(printer).print("Your current balance is : 0");
    }

    @Test
    public void should_print_sum_after_multiple_transactions() {
        Statement statement = new Statement(clock);
        Account account = new Account(statement);
        account.deposit(500);
        account.withdraw(200);
        account.deposit(50);
        account.withdraw(100);
        account.printCurrentBalance(printer);

        InOrder inOrder = inOrder(printer);
        inOrder.verify(printer).print("Your current balance is : 250");
    }

}
