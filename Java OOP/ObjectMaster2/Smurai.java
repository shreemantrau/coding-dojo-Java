package ObjectMaster;

public class Samurai {
	int health=200;
	static int count=0;
	
	public Samurai() {
		count+=1;
	}
	
	public void deathBlow(Human h) {
		h.health=0;
		this.health=this.health/2;
	}
	
	public void meditate() {
		this.health+=this.health/2;
	}
	
	public void howMany() {
		System.out.println("Total count of Samurai that are ready for a fight is: "+count);
	}
}
