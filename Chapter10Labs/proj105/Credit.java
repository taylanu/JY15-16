package proj105;
//Taylan Unal 1/14/16

public class Credit extends BankAccount implements BankActions{
	private double balance;
	private double apr;
	private int txlimit;
	private double credLim;
	private int billDue;//Days until bill must be paid.

	//Constructor//
	public Credit(){
		balance=0;
		apr=0.165;
		txlimit=999;
		credLim=1000;
		billDue=30;
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
		balance=balance*(1+apr);
	}
	public void setTxLimit(int tx){
		txlimit=tx;
	}
	public void setcredLim(double l){
		credLim=l;
	}
	////Setters////

	//Implemented methods from BankActions
	@Override
	public double checkBal() {
		return balance;
	}

	@Override
	public void deposit(double d) {
		balance-=d;
	}

	@Override
	public void withdraw(double w) {
		balance+=w;
	}
	//Implemented methods from BankActions
	//Custom Credit Methods
	public void spend(double a){
		balance+=a;
	}
	public void creditLimit(){
		if (balance>credLim){
			System.out.println("Payment Declined");
		}
	}
	public void payDue(){
		if(billDue==0){
			balance*=(1+apr);
		}
	}
	//Custom Credit Methods
}
