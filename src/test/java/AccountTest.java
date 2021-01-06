import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AccountTest {

    private Account account;

    @Mock
    private Statement statement;

    @Test
    public void should_store_deposit_statement() {
        account = new Account(statement);
        account.deposit(100);
        verify(statement).registerDeposit(100);
    }

    @Test
    public void balance_must_be_equal_to_deposit_amount_when_first_deposit() {
        account = new Account(25);
        assertEquals(25, account.getBalance());
    }

    @Test
    public void should_balance_amount_equal_all_deposit_sum_when_many_deposits() {
        account = new Account(0);
        account.deposit(60);
        account.deposit(40);
        Assert.assertEquals(100, account.getBalance());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void should_not_accept_deposit_with_negative_amounts() {
        account = new Account(0);
        account.deposit(-70);
    }

    @Test
    public void should_store_withdraw_statement() {
        account = new Account(statement);
        account.withdraw(200);
        verify(statement).registerWithdraw(200);
    }

    @Test
    public void should_subtract_amount_from_balance_when_withdraw() {
        account = new Account(100);
        account.withdraw(60);
        Assert.assertEquals(40, account.getBalance());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void should_not_accept_withdraw_with_negative_amounts() {
        account = new Account(100);
        account.withdraw(-70);
    }
}
