public class shoedriver {

	public static void main (String args[]) {
		System.out.println("Blueprint does not run, it needs a driver.");
		System.out.println("This is an instruction on how to build an object.");

		Shoe x = new Shoe();
		System.out.println(x);

		Shoe y = new Shoe(13,"black");
		System.out.println(y);
	}
}

