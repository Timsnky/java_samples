import java.util.Scanner;

public class SquareDisplay {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		int length, l, w;
		boolean wrongInput = false;
		
		do{
			wrongInput = false;
			//Prompt the User to enter the desired integer
			System.out.print("Enter an Integer in the range of 1 - 15: ");
			length = input.nextInt();
			//Check if the input is valid
			if(length > 15 || length < 0){
				wrongInput = true;
				System.out.println("You have entered an Invalid Integer");
			}
		}while(wrongInput);	
		w = 0;
		
		//Iterate using the given integer to display the square.
		while(w < length){
			l = 0;
			while (l < length){
				System.out.print("X");
				l ++;
			}
			if(w != length-1){
				System.out.println("");
			}			
			w ++;
		}		
	}
}
