package proj102;
//Taylan Unal 1/15/16

public abstract class Car {

	private String fuelType;
	private double fuelLevel;
	private int wheels;
	private boolean hasWheels;

	private int passCount;
	private boolean isMoving;

	public Car(){
		fuelType="gasoline";
		fuelLevel=100.0;
		wheels=4;
		passCount=1;
		isMoving=false;
	}

	/**
	 * @return the hasWheels
	 */
	public boolean isHasWheels() {
		return hasWheels;
	}

	/**
	 * @param hasWheels the hasWheels to set
	 */
	public void setHasWheels(boolean hasWheels) {
		this.hasWheels = hasWheels;
	}
	/**
	 * @return the fuelType
	 */
	public String getFuelType() {
		return fuelType;
	}

	/**
	 * @param fuelType the fuelType to set
	 */
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	/**
	 * @return the fuelLevel
	 */
	public double getFuelLevel() {
		return fuelLevel;
	}

	/**
	 * @param fuelLevel the fuelLevel to set
	 */
	public void setFuelLevel(double fuelLevel) {
		this.fuelLevel = fuelLevel;
	}

	/**
	 * @return the wheels
	 */
	public int getWheels() {
		return wheels;
	}

	/**
	 * @param wheels the wheels to set
	 */
	public void setWheels(int wheels) {
		this.wheels = wheels;
	}

	/**
	 * @return the passCount
	 */
	public int getPassCount() {
		return passCount;
	}

	/**
	 * @param passCount the passCount to set
	 */
	public void setPassCount(int passCount) {
		this.passCount = passCount;
	}

	/**
	 * @return the isMoving
	 */
	public boolean getMoving() {
		return isMoving;
	}

	/**
	 * @param isMoving the isMoving to set
	 */
	public void setMoving(boolean isMoving) {
		this.isMoving = isMoving;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "The Vehicle uses " + fuelType + ", it has fuelLevel=" + fuelLevel + ", has " + wheels +" wheels " + " can carry " + passCount + " passengers. It is currently" + isMoving + ".";
	}

}
