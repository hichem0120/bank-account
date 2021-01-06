public class Statement {

    private Integer balance = 0;

    public Statement(Integer amount) {
        this.balance = amount;
    }

    public Statement() {

    }

    public void registerDeposit(Integer amount) {
        if (amount < 0) {
            throw new UnsupportedOperationException();
        }
        balance += amount;
    }

    public int getBalance() {
        return balance;
    }

    public void registerWithdraw(Integer amount) {

    }
}
