package proj105;
//Taylan Unal 1/14/16

public class Credit extends BankAccount implements BankActions{
	private double balance;
	private double apr;
	private int txlimit;
	// private double credLim; (Could be implemented later on)
	
	//Constructor//
	public Credit(){
		balance=0;
		apr=0.165;
		txlimit=999;
	}
	//Constructor//
	////Getters////
	public double getAPR(){
		return (apr*100);
	}
	public double getTxLimit(){
		return txlimit;
	}
	////Getters////
	////Setters////
	public void setAPR(double a){
		apr=a;
	}
	public void setBalance(){//Only to be called if interest has to be added to account for outstanding balance
		
	}
	public void setTxLimit(int tx){
		txlimit=tx;
	}
	////Setters////
	
	//Implemented methods from BankActions
	public double checkBal() {
		return balance;
	}

	public void deposit(double d) {
		balance-=d;
	}

	public void withdraw(double w) {
		balance+=w;
	}
	//Implemented methods from BankActions
}
