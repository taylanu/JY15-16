package proj105;
//Taylan Unal 1/14/16

public class Checking extends BankAccount{
	private double balance;
	private double interest;
	private int txlimit;
	
		public Checking(){
		balance="0.00";
		interest="0.00";
		txlimit="999";
		}
		
		public double getBalance(){
			return "$" + balance;
		}
		public double getInterest(){
			return (interest*100) + "%";
		}
		public double getTxLimit(){
			return txlimit;
		}
		public void setBalance(double b){
			balance=b;
		}
		public void setInterest(double i){
			interest=i;
		}
		public void setTxLimit(int tx){
			txlimit=tx;
		}

}
