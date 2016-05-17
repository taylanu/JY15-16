package proj105;
//Taylan Unal 1/14/16

public class Checking extends BankAccount implements BankActions {
    private double balance;
    private double interest;
    private int txlimit;

    public Checking() {
        balance = 0.00;
        interest = 0.00;
        txlimit = 999;
    }

    //Methods used in each of the specific classes.
    ////Getters////
    public double getInterest() { //Returns Interest Rate in %age form. If unnecessary, simply divide by 100 when used.
        return (interest * 100);
    }

    ////Getters////
    ////Setters////
    public void setInterest(double i) {
        interest = i;
    }

    public double getTxLimit() {
        return txlimit;
    }

    public void setTxLimit(int tx) {
        txlimit = tx;
    }
    ////Setters////
    //Methods used in each of the specific classes

    //Implemented methods from BankActions
    @Override
    public void deposit(double d) {
        balance += d;
    }

    @Override
    public void withdraw(double w) {
        balance -= w;
    }

    @Override
    public double checkBal() {
        return balance;
    }

}
