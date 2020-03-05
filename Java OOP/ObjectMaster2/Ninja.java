package ObjectMaster;

public class Ninja extends Human{
	int stealth=10;
	
	public void steal(Human h) {
		h.health-=h.stealth;
		health+=h.stealth;
	}
	
	public void runAway() {
		health-=10;
	}
	
	
}
