import java.util.Scanner;

public class Maximum {
	public static void main(String [] args){
		float firstNumber, secondNumber;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the First Number: ");
		firstNumber = input.nextFloat();
		
		System.out.println("Enter the Second Number: ");
		secondNumber = input.nextFloat();
		
		if(firstNumber < secondNumber){
			System.out.println(firstNumber + " is Smaller of the two Numbers");
		}
		else if(firstNumber > secondNumber){
			System.out.println(secondNumber + " is Smaller of the two Numbers");
		}
		else{
			System.out.println("The two numbers are equal");
		}
	}
}
