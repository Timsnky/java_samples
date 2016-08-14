import java.util.Scanner;

public class Currency {
	public static void main(String [] args){
		int choice = 1;
		float kenyanCurrency, dollarCurrency;
		Scanner input = new Scanner(System.in);
		while (choice == 1){
			System.out.println("Enter the Currency in Ksh.: ");
			kenyanCurrency = input.nextFloat();
			dollarCurrency = kenyanCurrency * 86;
			System.out.println(kenyanCurrency + " Ksh. is equal to " + dollarCurrency + " US Dollars");
			System.out.println("Do you wish to Enter another Value?\n1. Yes\n2. No ");
			choice = input.nextInt();
		}		
	}
}
