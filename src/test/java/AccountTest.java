import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

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
}
