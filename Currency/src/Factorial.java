import java.util.Scanner;

public class Factorial {
	public static void main(String [] args){
		int number;
		double factorialSum;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the Integer Number; ");
		number = input.nextInt();
		factorialSum = factorial(number);
		System.out.println("The Factorial of the Number is " + factorialSum);
	}
	
	public static double factorial(int number){
		if(number == 1){
			return 1;
		}
		else{
			return number * factorial(-- number);
		}
	}	
}
