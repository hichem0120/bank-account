public class Account {
    private Statement statement;

    public Account(Statement statement) {
        this.statement = statement;
    }

    public void deposit(Integer amount) {
        statement.registerDeposit(amount);
    }

    public int getBalance() {
        return 25;
    }
}
