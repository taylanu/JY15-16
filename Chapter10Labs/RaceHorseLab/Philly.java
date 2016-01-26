package RaceHorseLab;

public class Philly extends Horse{

	public Philly() {
		// Super method to call from Horse.
	}
	
//Getters//
	@Override
	public int getLocation() {
		// TODO Auto-generated method stub
		return super.getLocation();
	}

	@Override
	public int getIndex() {
		// TODO Auto-generated method stub
		return super.getIndex();
	}
//Getters//

//Actions//
	@Override
	public void advance() {
		// TODO Auto-generated method stub
		super.advance();
	}

	@Override
	public void raceStride() {
		// TODO Auto-generated method stub
		super.raceStride();
	}
//Actions//
	
	@Override
	public String toString(){
	      String str = new String();
	      String first = new String ("");
	      String second = new String("");
	      if(getLocation() > 1){
	         for(int i = 1; i < getLocation(); i++){
	            first += "-";
	         }
	      }
	      
	      if(getLocation() < 15){
	         for(int i = getLocation() + 1; i <= 15; i++){
	            second = second + "-";
	         }
	      }
	     str = "|S|" + first + getIndex() + second + "|F|";
	     return str;
	}
}
