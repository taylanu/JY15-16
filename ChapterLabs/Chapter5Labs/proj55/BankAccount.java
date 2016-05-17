//INTERGALACTIC BANK OF TAY
public class BankAccount {
    private String name;
    private int balance;

    public BankAccount(String n, int b) {
        name = n;
        balance = b;
    }

    // The Retrievers
    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    //The Options
    public void deposit(int d) {
        balance = balance + d;
    }

    public void withdraw(int w) {
        balance = balance - w;
    }

    //The Returner
    @Override
    public String toString() {
        String str;
        str = "Name: " + name + "\nBalance: " + balance;
        return str;
    }
}
