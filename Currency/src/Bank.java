import java.util.Scanner;

public class Bank {
	private static double accountBalance;
	public static Scanner input = new Scanner(System.in);
	
	public Bank(double balance){
		this.accountBalance = balance;
	}
	
	public double getBalance(){
		return accountBalance;
	}
	
	public void setBalance(double balance){
		this.accountBalance = balance;
	}
	
	public int greetings(){
		int choice;
		System.out.println("Please Select the Transaction you wish to perform:\n1. Withdrawal\n2. Deposit\n3. Check Balance");
		choice = input.nextInt();
		return choice;		
	}
	
	public void withdrawal(){
		double withdrawalAmount;
		System.out.println("Please Enter the amount you wish to withdraw");
		withdrawalAmount = input.nextDouble();
		if(withdrawalAmount < accountBalance){
			accountBalance -= withdrawalAmount;
			System.out.println("You have Withdrawn Ksh." + withdrawalAmount + "\nNew Account Balance = Ksh." + accountBalance);
		}else{
			System.out.println("You have insufficient funds in your account\n");
		}		
	}
	
	public void deposit(){
		double depositAmount;
		System.out.println("Please Enter the amount you wish to deposit");
		depositAmount = input.nextDouble();		
		accountBalance += depositAmount;
		System.out.println("You have Deposited Ksh." + depositAmount + "\nNew Account Balance = Ksh." + accountBalance);
	}
	
	public void showBalance(){
		System.out.println("Your Account Balance is: Ksh." + accountBalance);
	}
	
	public static void main(String [] args){
		int choice = 1, choice1;
		//The Account starts with an initial balance of Ksh.100000;
		Bank bankTransaction = new Bank(100000);
		System.out.println("Welcome to Equity Bank Online Transaction Service");
		while(choice == 1){
			choice1 = bankTransaction.greetings();
			if(choice1 == 1){
				bankTransaction.withdrawal();
			}
			else if(choice1 == 2){
				bankTransaction.deposit();
			}
			else if(choice1 == 3){
				bankTransaction.showBalance();
			}
			
			System.out.println("\nDo you wish to perform another Transaction?\n1. Yes\n2. No ");
			choice = input.nextInt();
		}		
	}
}
