package LinkedList;

public class ListTester {
    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.add(3);
        sll.add(4);
        sll.add(10);
        sll.add(12);
        sll.add(15);
        sll.add(23);
        Node found=sll.findInt(2);
        
        System.out.println("The found node is present at: " + found);
        sll.printValues();
        
        sll.removeAt(1);
        sll.printValues();
    }
}