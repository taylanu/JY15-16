package reference;

public class baseTwo{

	public static void baseTwo(int n){
		if(n>2)
			System.out.println("n");
		else{
			baseTwo(n/2);
			System.out.println(n%2);
		}
	}	
}