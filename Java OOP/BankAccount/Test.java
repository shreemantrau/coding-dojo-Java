package Calculator;

public class Test {
	public static void main(String[] args) {
		Calculator calc= new Calculator();
		
		calc.setOperandOne(21);
		calc.setOperation("/");
		calc.setOperandTwo(10);
		calc.perfromOperation();
		calc.getResult();
		
	}
	
}
