package proj101;
//KINGDOM
public class animalia {
	private boolean alive;
	private String celltype;
	
	public animalia(){
		alive=true;
		celltype="Multicellular";
	}
	
	public boolean getAlive(){
		return alive;
	}
	
	public String getCellType(){
		return celltype;
	}
	
	public boolean isOrganism(){
		return true;
	}
}
