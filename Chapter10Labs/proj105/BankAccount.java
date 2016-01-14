package proj105;
//Taylan Unal 1/14/16

public abstract class BankAccount {
	private boolean hasBalance;
	private double value;
	private static String owner;
		
		public BankAccount(){
			setHasBalance(true);
			setValue(0);
			setOwner("");
		}

		/**
		 * @return the hasBalance
		 */
		public boolean getHasBalance() {
			return hasBalance;
		}

		/**
		 * @param hasBalance the hasBalance to set
		 */
		public void setHasBalance(boolean hasBalance) {
			this.hasBalance = hasBalance;
		}

		/**
		 * @return the value
		 */
		public double getValue() {
			return value;
		}

		/**
		 * @param value the value to set
		 */
		public void setValue(double value) {
			this.value = value;
		}

		/**
		 * @return the owner
		 */
		public String getOwner() {
			return owner;
		}

		/**
		 * @param owner the owner to set
		 */
		public void setOwner(String owner) {
			BankAccount.owner = owner;
		}
	
}
