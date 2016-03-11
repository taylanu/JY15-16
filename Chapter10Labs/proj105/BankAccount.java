package proj105;
//Taylan Unal 1/14/16

public abstract class BankAccount{

	private double value;
	private static String owner;

		public BankAccount(){
			setValue(0);
			setOwner("");
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
