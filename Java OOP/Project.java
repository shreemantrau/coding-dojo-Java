package assignments;

public class Project {
	String name;
	String description;
	double initialCost;
	
	
	public String elevatorPitch() {
		return this.name + "( " + this.initialCost + " )" + " : " + this.description;
	}
	
	
	public Project() {
			
	}
		
	public Project(String name) {
		this.name=name;
	}
	
	public Project(String name, String description) {
		this.name=name;
		this.description=description;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
//	public static void main (String[] args) {
//		System.out.println("Hello");
//	}
	
}
