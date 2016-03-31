public class countingEndings {
		public countingEndings(){
		int i = (int)Math.random();	
		if(i>3)
			System.out.println("After your " + i + "th Shuffle ");
		else if(i==3)
			System.out.println("After your " + i + "rd Shuffle ");
		else if(i==2)
			System.out.println("After your " + i + "nd Shuffle ");
		else
			System.out.println("After your " + i + "st Shuffle ");
	}
}
