package ObjectMaster;

public class Wizard extends Human{
	int health=50;
	int intelligence=8;
	public void heal(Human h) {
		h.health+=this.intelligence;
	}
	
	public void fireball(Human h) {
		h.health-=(3*this.intelligence);
	}
	
	
}
