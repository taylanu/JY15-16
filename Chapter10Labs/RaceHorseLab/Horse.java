package RaceHorseLab;

public class Horse {
	private int location;//horse location on race track out of 15 unit track length. Where 1 is start and 15 is finish line
	private int index;
	
	public Horse(){
		location=1;
		index=0;//There will be no horse with index of 0.
	}
	public Horse(int l, int i){
		location=l;
		index=i;
	}
	public int getLocation(){
		return location;
	}
	public int getIndex(){
		return index;
	}
	public void advance(){
		if(location<15)
			location++;
	}
	public void raceStride(){
		for(int i=0;i<45;i++){
			for(int j=0;j<15;j++){//for Horse 0
				
			}
			for(int k=0;k<15;k++){//for Horse 1
				
			}
			for(int l=0;l<15;l++){//for Horse 2
				
			}
		}
	}
	public String toString(){
		return "|S------------F|" + "\n" + "|---------------|" + "\n" + "|---------------|" + "\n" + "|---------------|";
	}
}

/*System.out.println("|S------------F|");//Demonstrating how start and finish positions lie on track.
System.out.println("|---------------|");
System.out.println("|---------------|");		FIRST ATTEMPT
System.out.println("|---------------|");*/
