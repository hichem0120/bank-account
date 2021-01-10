import java.util.ArrayList;
import java.util.List;

public class Statement {

    private Clock clock;
    private List<Transaction> transactions = new ArrayList<>();
    private final static int MIN_THRESHOLD = -100;


    public Statement(Clock clock) {
        this.clock = clock;
    }

    public Statement() {
        transactions = new ArrayList<>();
        clock = new Clock();
    }

    public void registerDeposit(Integer amount) {
        if (amount < 0) {
            throw new UnsupportedOperationException();
        }
        transactions.add(new Transaction(amount, OperationType.DEPOSIT, clock.getTodayDate(), getCurrentBalance()));

    }


    public void registerWithdraw(Integer amount) {
        if (amount < 0) {
            throw new UnsupportedOperationException();
        }
        Transaction newTransaction = new Transaction(amount, OperationType.WITHDRAW, clock.getTodayDate(), getCurrentBalance());
        if (getCurrentBalance() + newTransaction.addOrSubtractAmount() < MIN_THRESHOLD) {
            throw new UnsupportedOperationException("Minimum limit for balance is reached");
        }
        transactions.add(newTransaction);
    }

    public void printTransactions(Printer printer) {
        if (transactions.isEmpty()) {
            printer.print("No Transactions");
        } else {
            transactions.forEach(transaction -> printer.print(transaction.toPrint()));
        }
    }

    public Integer getCurrentBalance() {
        return transactions.stream().mapToInt(Transaction::addOrSubtractAmount).sum();
    }

    public void printCurrentBalance(Printer printer) {
        printer.print("Your current balance is : " + getCurrentBalance().toString());

    }
}
