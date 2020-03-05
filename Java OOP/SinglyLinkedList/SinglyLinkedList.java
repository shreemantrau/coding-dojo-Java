package LinkedList;

public class SinglyLinkedList {
    public Node head;
    public SinglyLinkedList() {
        this.head=null;
    }
    
    // SLL methods go here. As a starter, we will show you how to add a node to the list.
    public void add(int value) {
        Node newNode = new Node(value);
        if(head == null) {
            head = newNode;
        } else {
            Node runner = head;
            while(runner.next != null) {
                runner = runner.next;
            }
            runner.next = newNode;
        }
    }
    
    public void remove(int value) {
    	Node runner=head;
    	while(runner.next.next!=null) {
    		runner=runner.next;
    	}
    	runner.next=null;
    }
    
    
    public void printValues() {
    	Node runner=head;
//   	System.out.println(runner.next.value);
    	while(runner != null) {
    		System.out.println("The value of the node is: " + runner.value);
    		runner=runner.next;
    	}
    	System.out.println("-------------------------------------------------------------");
    }
    
    public Node findInt(int x) {
    	Node runner=head;
    	while(runner != null) {
    		if(runner.value == x) return runner;
    		runner=runner.next;
    	}
    	return runner;
    }

    

    
    
    
    
    public void removeAt(int x) {
    	if(x==0) {
    		Node temp = head.next;
    		head.next=null;
    		head=temp;
    	}
    	else {
    		int count=0;
    		Node runner=head;
    		Node temp=runner;
    		while(runner.next!=null) {
    			if(count==x)
    			{

    	    		temp.next=temp.next.next;
    	    		runner.next=null;
    				break;
    			}
    			temp=runner;
    			runner=runner.next;
    			count++;
    		}
    	//	printValues();
    	}
    }
    
//      0 1 2 3 4 
//      1 2 3 4 5 
   
    
}//end of class
	