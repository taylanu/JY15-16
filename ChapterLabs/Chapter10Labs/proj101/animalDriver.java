package proj101;

public class animalDriver {

	public static void main(String[] args) {
			newt Jimmy = new newt("Orange",3,5.3);
			newt Johnny = new newt("Black",5,23.4);
			newt Jackie = new newt("Grey",12,31.2);

			System.out.println("You have 3 newts.");
			System.out.println("Each of them are alive.");
			System.out.println("Your youngest newt is " + Jimmy.getAge() + " years old, is " + Jimmy.getColor() + " and weighs " + Jimmy.getWeight() + " grams.");
			System.out.println("Your next youngest newt is " + Johnny.getAge() + " years old, is " + Johnny.getColor() + " and weighs " + Johnny.getWeight() + " grams.");
			System.out.println("Your oldest newt is " + Jackie.getAge() + " years old, is " + Jackie.getColor() + " and weighs " + Jackie.getWeight() + " grams.");
			//natSelect();
	}
}
