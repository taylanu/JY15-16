package proj101;

public class animalia {
	private boolean alive;
	private String celltype;
	private double weight;
	private String color;

	public animalia(){
		setAlive(true);
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
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	public double getWeight(){
		return weight;
	}
	public void setWeight(double w){
		weight = w;
	}
	public String getColor(){
		return color;
	}
	public void setColor(String c){
		color=c;
	}
}
