package ZooKeeper;

public class Gorilla extends Mammal{
	public void throwSomething() {
		System.out.println("Gorilla has thrown somehting");
		energyLevel-=5;
	}
	
	public void eatBananas() {
		System.out.println("Gorilla is no more hungry");
		energyLevel+=10;
	}
	
	public void climb() {
		System.out.println("Gorilla has climbed the tree");
		energyLevel-=10;
	}
	
	
}
