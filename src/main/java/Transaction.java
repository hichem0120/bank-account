import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private final Integer amount;
    private final OperationType operationType;
    private final LocalDate date;
    private Integer balance;

    public Transaction(Integer amount, OperationType operationType, LocalDate date, Integer balance) {
        this.amount = amount;
        this.operationType = operationType;
        this.date = date;
        this.balance = balance;
    }


    public String toPrint() {
        return String.format("|%s|%s|%s|%s|",
                date.format(DateTimeFormatter.ISO_DATE),
                operationType.toString(),
                amount,
                balance);
    }

    public Integer addOrSubtractAmount() {
        return OperationType.DEPOSIT.equals(operationType) ? amount : -amount;
    }
}
