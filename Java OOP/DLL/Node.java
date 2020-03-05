package Tries;
import java.util.HashMap;

public class Node {
	public HashMap<Character,Node>children;
	public boolean isWordComplete;
	
	public Node() {
		this.children = new HashMap<Character,Node>();
		this.isWordComplete=false;
	}
	
	
}
