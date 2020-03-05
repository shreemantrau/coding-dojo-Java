package assignments;

public class ProjectTest {
	public static void main(String[] args) {
//		Project p=new Project();
//		Project p= new Project("Coding Dojo");
		Project p= new Project("Coding Dojo","Is good");
		
		System.out.println("hi");
		System.out.println(p.getName());
		System.out.println(p.getDescription());
		System.out.println(p.elevatorPitch());
		
	}
}
