package ZooKeeper;

public class Mammal {
	int energyLevel;
	int batEnergyLevel=300;
	
	public int displayEnergyLevel() {
		System.out.println("The energy level of the animal is: "+energyLevel);
		return energyLevel;
	}
	
	public int batEnergyLevel() {
		System.out.println("The energy level of at is: "+batEnergyLevel);
		return batEnergyLevel;
	}
	
	
}
