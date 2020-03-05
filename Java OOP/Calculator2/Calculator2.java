package Calculator;

public class Calculator2 {
	double operand;
	String operation;
	public static double ans;
	boolean addition;
	boolean subtraction;
	boolean multiplication;
	boolean division;
	boolean check=true;
	public void performOperation(double x) {
//		this.operand=x;
		
		if(check) {
			ans=x;
			check=false;
		}
		if(addition) {
			ans+=x;
			System.out.println("Form the main class the value is "+ans);
			addition=false;
		}
		if(subtraction) {
			ans-=x;
			subtraction=false;
		}
		if(multiplication) {
			ans*=x;
			multiplication=false;
		}
		if(division) {
			ans/=x;
			division=false;
		}
	}
	
	public void performOperation(String x) {
		
		if(x=="+") addition=true;
		else if(x=="-")subtraction=true;
		else if(x=="*") multiplication=true;
		else if(x=="/") division=true;
		else if(x=="=") getResults();
		else System.out.println("Inalid operator");
		
	}
	
	public static void getResults() {
//		return ans;
		System.out.println("Here is your output: "+ans);
	}
	
	
	
	
}
