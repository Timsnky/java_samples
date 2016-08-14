import java.util.Scanner;

public class Marks {
	public static void main(String [] args){
		int choice = 1;
		float marks;
		Scanner input = new Scanner(System.in);
		while (choice == 1){
			System.out.println("Enter the Marks:: ");
			marks = input.nextFloat();
			if(marks <= 50){
				System.out.println("The Student's Grade is Fail");
			}else if(marks > 50 && marks <= 100){
				System.out.println("The Student's Grade is Pass");
			}
			System.out.println("Do you wish to Enter more Marks?\n1. Yes\n2. No ");
			choice = input.nextInt();
		}		
	}
}
