package proj101;

public class newt extends amphibia{

	public static void main(String[] args) {
		amphibia newt = new amphibia();
		System.out.println(newt);
		System.out.println("Darwinian Trap Card Activated!");
		natSelect();
	}
	
	public void natSelect(){
		// Darwin ;) //
			Scanner reader = new Scanner(System.in);
			alive = false;
			System.out.println("Your animal has died.");
			System.out.println("Its genes were not passed on");
			System.out.println("Play Again? (y/n)");
			
			if(System.nextChar()=='y'){
				System.out.println("Starting Simulation...");
				animalia();
			}
			else{
				System.out.println("Quitting Simulation...");
			}
		}
}
