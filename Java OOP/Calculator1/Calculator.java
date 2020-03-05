package Calculator;

public class Calculator {
	double operandOne;
	double operandTwo;
	String operation;
	double ans;
	public void setOperandOne(double x) {
		this.operandOne=x;
	}
	
	public void setOperandTwo(double y) {
		this.operandTwo=y;
	}
	
	public void setOperation(String z) {
		this.operation= z;
	}
	
	public void perfromOperation() {
		if(operation == "+" ) ans= operandOne + operandTwo;
		else if(operation == "-") ans= operandOne - operandTwo;
		else if(operation== "*") ans= operandOne* operandTwo;
		else if(operation== "/") ans= operandOne/operandTwo;
		else System.out.println("Invalid operation!");
	}
	
	public void getResult() {
		System.out.println("This is the putput for your opernds: "+ans);
	}
}
