import java.util.ArrayList;
import java.util.Scanner;


public class SalespersonsTest {
	/* Initialize the global variables to be applied in the program*/
	private static float earningPerSale = 0;
	private static ArrayList<Salesperson> salespersons = new ArrayList<Salesperson>();
	private static Scanner input = new Scanner(System.in);
	public static void main(String [] args){		
		int choice = 1;
		while (choice != 0){
			//Prompt user to select the desired action 
			System.out.println("Please Select the Operation you wish to perform:");
			System.out.println("1. Set the Earning per Sale.\n2. Add a Salesperson.\n3. Compare two Salespersons.\n4. Exit");	
			choice = input.nextInt();
			switch(choice){
			case 1:
				setEarningPerSale();
				break;
			case 2:
				addSalesperson();
				break;
			case 3:
				compareSalespersons();
				break;
			case 4:
				choice = 0;
				break;
			default:
				System.out.println("You have Entered an Invalid Number:");
				break;				
			}
		}
	}
	
	/* This function sets the value for the amount to be paid for each sale made by the salesperson*/
	public static void setEarningPerSale(){
		System.out.println("Please Enter the Desired Earnings per Sale:");
		earningPerSale = input.nextFloat();
	}
	
	/*This function adds a new salesperson by prompting the user to provide their name and
	 * total sales made. The new salesperson is the added to an arraylist containing all the salespersons.
	 */
	public static void addSalesperson(){
		String name;
		int sales;
		int choice1;
		do{
			System.out.println("Enter the name of the Salesperson:");
			name = input.next().toUpperCase();
			System.out.println("Enter the Number of Sales made:");
			sales = input.nextInt();
			Salesperson newPerson = new Salesperson(sales, name);
			salespersons.add(newPerson);
			System.out.println("Do you wish to add another Salesperson?\n 1. Yes\n 2. No");
			choice1 = input.nextInt();			
		}while(choice1 != 2);
	}
	
	/*Perform the comparison of the earnings between two salespersons by initially prompting user to 
	 * provide a name for each salesperson they wish to compare. The names are then checked from the 
	 * salespersons arraylist.
	 */
	public static void compareSalespersons(){
		Salesperson salesperson1 = null, salesperson2 = null;
		String name;
		int i = 0;
		int sales1, sales2;
		int choice2;
		do{
			int x = 1;
			while(x == 1){
				System.out.println("Enter the Name of the First Salesperson:");
				name = input.next().toUpperCase();
				while( i < salespersons.size()){
					if(salespersons.get(i).getName().equals(name)){
						salesperson1 = salespersons.get(i);
						x = 0;
						break;
					}
					i ++;
				}
				i = 0;
				if(salesperson1 == null){
					System.out.println("The provided name was not found. Please enter the correct name");
				}
			}
			
			i = 0;
			x = 1;
			while(x == 1){
				System.out.println("Enter the Name of the Second Salesperson:");
				name = input.next().toUpperCase();
				while( i < salespersons.size()){
					if(salespersons.get(i).getName().equals(name)){
						salesperson2 = salespersons.get(i);
						x = 0;
						break;
					}
					i ++;
				}
				i = 0;
				if(salesperson2 == null){
					System.out.println("The provided name was not found. Please enter the correct name");
				}
			}
			
			
			System.out.println("\nSalesperson 1 Details:\n" + salesperson1.display() + "\nTotal Earnings: " + salesperson1.getSales() * earningPerSale);
			System.out.println("\nSalesperson 2 Details:\n" + salesperson2.display() + "\nTotal Earnings: " + salesperson2.getSales() * earningPerSale);
			sales1 = salesperson1.getSales();
			sales2 = salesperson2.getSales();
			if(sales1 > sales2){
				System.out.println(salesperson2.getName() + " has to make " + (sales1-sales2) + " extra sales for him/her to match " + salesperson1.getName() + " earnings");
			}else if ( sales2 > sales1){
				System.out.println(salesperson1.getName() + " has to make " + (sales2-sales1) + " extra sales for him/her to match " + salesperson2.getName() + " earnings");
			}else{
				System.out.println("The two salespersons have equal earnings");
			}
			System.out.println("Do you wish to compare another two salespersons?\n 1. Yes\n 2. No");
			choice2 = input.nextInt();	
		}while(choice2 != 2);
	}

}
