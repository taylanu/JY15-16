	public class Shoe{
	private double size;
	private String color;

	public Shoe(){
			size = 5;
			color = "White";
	}

	public Shoe(double s, String c){
			size = s;
			color = c;
	}
	@Override
	public String toString(){
		return ("Your shoe is " + color + " and is size " + size + ".");
	}
}
