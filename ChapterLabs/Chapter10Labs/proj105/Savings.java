package proj105;
//Taylan Unal 1/14/16

public class Savings extends BankAccount implements BankActions {
    private double balance;
    private double apy;
    private int txlimit;

    //Constructor//
    public Savings() {
        balance = 0;
        apy = .01;
        txlimit = 6;
    }
    //Constructor//

    //Getters
    public double getAPY() {
        return (apy * 100);
    }

    //Setters
    public void setAPY(double y) {
        apy = y;
    }
    //Getters

    public double getTxLimit() {
        return txlimit;
    }

    public void setTxLimit(int tx) {
        txlimit = tx;
    }
    //Setters

    @Override
    public double checkBal() {
        return balance;
    }

    @Override
    public void deposit(double d) {
        balance += d;
    }

    @Override
    public void withdraw(double w) {
        balance -= w;
    }

}
