package proj101;
//PHYLUM
public class chordata extends animalia{
	private boolean skeleton;
	private boolean tail;
	
	public chordata(){
		skeleton=true;
		tail=true;
	}
	
	public String hasSkeleton(){
		if(skeleton==true){
			return "Has a primitive skeleton called a chordata";
		}
		else{
			return "Has no skeleton";
		}
	}
	
	public String hasTail(){
		if (tail==true){
			return "Has a tail";
		}
		else{
			return "Has no tail";
		}
	}
}
