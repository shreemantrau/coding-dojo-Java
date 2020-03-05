package ObjectMaster;

public class HumanTest {
	public static void main(String[] args) {
		Human h1=new Human();
		Human h2=new Human();
//		h1.attack(h2);
		Wizard w1=new Wizard();
		Ninja n1=new Ninja();
		Ninja n2=new Ninja();
		Samurai s1= new Samurai();
		Samurai s2= new Samurai();
		
		n1.steal(n2);
		System.out.println("N2 Health: "+n2.health+", "+ "N1 Health: "+n1.health);
		n1.runAway();
		System.out.println("N1 health: "+n1.health);
		w1.heal(n1);
		System.out.println("N1 Health:  "+n1.health);
		s1.deathBlow(n1);
		System.out.println("Health of Samurai after the deathblow is: " +s1.health+", Health of N1 after taking the death blow is "+n1.health);
		s1.howMany();
		
	}
}
