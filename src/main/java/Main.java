public class Main {
    public static void main(String[] args) {
        Account account = new Account(new Statement());
        account.deposit(100);
        account.deposit(200);
        account.withdraw(50);
        account.deposit(50);
        Printer printer = new Printer();
        account.printTransactions(printer);
        account.printCurrentBalance(printer);

    }

}
