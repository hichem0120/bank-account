public class Statement {

    private Integer balance;

    public Statement(Integer amount) {
        this.balance = amount;
    }

    public void registerDeposit(Integer amount) {
        balance += amount;
    }

    public int getBalance() {
        return balance;
    }
}
