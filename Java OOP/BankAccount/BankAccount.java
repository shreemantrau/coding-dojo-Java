package BankAccount;

import java.util.*;

public class BankAccount {
	private String account_number;
	private double checkingBalance;
	private double savingsBalance;
	private static int count;
	private static double total_money;
	private String accountNumber;
	public BankAccount() {
		count++;
		accountNumber=createAccountNumber();
	}
	
	
	private String createAccountNumber() {
		
		Random r=new Random();
		  for (int i = 0; i < 10; i++){
		      int num = r.nextInt(10);
		      accountNumber += num; 
		    }
		  
		  return accountNumber;
	}


	public String getAccount_number() {
		return account_number;
	}


	public static int getCount() {
		return count;
	}


	public void getTotal_money() {
		
		System.out.println("Total money in the bank is: "+total_money);
	}


	public String getAccountNumber() {
		return accountNumber;
	}
	
	public void getCheckingBalance() {
		System.out.println("Checking Balance: "+ this.checkingBalance);
	}
	
	public void getSavingsBalance() {
		System.out.println("savings balance: "+this.savingsBalance);
	}
	
	public void depositChecking(double x) {
		this.checkingBalance+=x;
		total_money+= checkingBalance+savingsBalance;
		getCheckingBalance();
	}
	
	public void depositSaving(double x) {
		this.savingsBalance+=x;
		total_money+= checkingBalance+savingsBalance;
		getSavingsBalance();
	}
	
	public void withdrawSaving(double x) {
		if(savingsBalance>x) {		
		savingsBalance-=x;
		total_money= checkingBalance+savingsBalance;
		getSavingsBalance();
		System.out.println("You have successfully withdrawn $"+x+" Your new balance is: "+savingsBalance);
		}
		
		else {
			System.out.println("Insufficient funds!");
		}
	}
	
	public void totalBalanceOfThisUser() {
		double x=checkingBalance+savingsBalance;
		System.out.println("The total balance of yours is: "+x );
	}
	
	
	
	
		
	
}
