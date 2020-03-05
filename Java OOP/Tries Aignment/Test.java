package Tries;

import java.util.Set;

public class Test {
	public static void main(String[] args) {
		Trie t= new Trie();
		t.insertWord("car");
		t.insertWord("card");
		t.insertWord("chip");
		t.insertWord("trie");
		t.insertWord("try");
		
		
			Set<Character>keys=t.root.children.get('c').children.keySet();
			System.out.println(keys);
		
		System.out.println(t.isPrefixValid("ca"));
		System.out.println(t.isWorldValid("card"));
		System.out.println(t.isWorldValid("cardd"));
		
		System.out.println("-------------------");
		t.printAllKeys();
	}
}
