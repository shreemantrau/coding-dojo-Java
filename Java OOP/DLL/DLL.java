package dll;

public class DLL {
	public Node head;
	public Node tail;
	
	public DLL() {
		this.head=null;
		this.tail=null;
	}
	
	public void push(Node newNode) {
		if(this.head==null) {
			this.head=newNode;
			this.tail=newNode;
			return;
		}
		
		Node lastNode=tail;
		lastNode.next=newNode;
		newNode.previous=lastNode;
		this.tail=newNode;
	}
	
	public void printValuesForward() {
		Node current=this.head;
		while(current!=null) {
			System.out.println(current.value+ " ");
			current=current.next;
		}
	}
	
	public void printValuesBackward() {
		Node runner=tail;
		while(runner!=null) {
			System.out.print(runner.value+ " ");
			runner=runner.previous;
		}
		
	}
	
	public Node pop() {
		Node runner=tail;
		runner=runner.previous;
		tail.previous=null;
		tail.next=null;
		runner.next=null;
		Node temp=tail;
		tail=runner;
		
		return temp;
	}
	
	
	public boolean contains(Integer val) {
		Node runner=head;
//		boolean x=false;
		while(runner!=null) {
			if(runner.value==val) {
				return true;
			}
			runner=runner.next;
		}
		return false;
	}
	
	public int size() {
		Node runner=head;
		int count=0;
		while(runner!=null) {
			runner=runner.next;
			count++;
		}
		return count;
	}
	
	
	public void insertAt(Node newNode, int x) {
		
		if(x==0) {
			newNode.next=head;
			head.previous=newNode;
			head=newNode;
			return;
		}
		int count=0;
		Node runner=head;
		Node temp=head;
		while(runner!=null) {
			if(count==x) {
				temp.next=newNode;
				newNode.next=runner;
				newNode.previous=temp;
				runner.previous=newNode;
			}
			
			temp=runner;
			runner=runner.next;
			count++;
		}
	}
	
	public void removeAt(int x) {
		if(x==0) {
			Node temp=head.next;
			head.next=null;
			head.previous=null;
			head=temp;
			return;
		}
		
		int count=0;
		Node runner=head;
		Node temp=runner;
		
		while(runner!=null) {
			if(count==x) {
				temp.next=temp.next.next;
				runner.previous=null;
				Node temp2=runner.next;
				temp2.previous=temp;
				runner.next=null;
			}
			temp=runner;
			runner=runner.next;
			count++;
		}
		
	}
	
	public boolean isPalindrome() {
		Node runner=head;
		Node tailRunner=tail;
		
		while(tailRunner!=runner) {
			if(tailRunner.value != runner.value) return false;
			runner=runner.next;
			tailRunner=tailRunner.previous;
		}
		return true;
		
	}
	
}

