public class Account {
    private Statement statement;

    public Account(Statement statement) {
        this.statement = statement;
    }

    public Account(Integer amount) {
        statement = new Statement();
        statement.registerDeposit(amount);
    }

    public void deposit(Integer amount) {
        statement.registerDeposit(amount);
    }

    public int getBalance() {
        return statement.getBalance();
    }

    public void withdraw(Integer amount) {
        statement.registerWithdraw(amount);
    }

    public void printStatement() {
        statement.print();
    }
}
