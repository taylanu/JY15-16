package proj101;

public class newt extends amphibia {
    private int age;
    private double weight;
    private String color;

    public newt(String c, int a, double w) {
        super();
        age = a;
        weight = w;
        color = c;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public double getWeight() {
        return weight;
    }
    /*public void natSelect(){
		// Darwin ;) //
			Scanner reader = new Scanner(System.);
			setAlive(false);
			System.out.println("Your newt has died.");
			System.out.println("Its genes were not passed on");
			System.out.println("Play Again? (y/n)");

			if(nextChar()=='y'){
				System.out.println("Starting Simulation...");
				super.animalia.();
			}
			else{
				System.out.println("Quitting Simulation...");
			}
		}
		*/
}
