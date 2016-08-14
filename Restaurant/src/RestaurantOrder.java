import java.util.Scanner;

public class RestaurantOrder {
	
	public static void main(String [] args){
		MenuItem menu[] = new MenuItem[10];
		Scanner input = new Scanner(System.in);
		int itemSelection, itemQuantity;
		float price, payment;
		//Call function to display the menu for the user to make selection
		displaMenu(menu);
		//Prompt user for order selection
		System.out.println("Please select the Item you would like to order:");
		itemSelection = input.nextInt();
		//Prompt user for quantity of order
		System.out.println("Please enter the Quantity you wish to order: ");
		itemQuantity = input.nextInt();
		//Compute the price of the order
		price = menu[itemSelection - 1].itemPrice * itemQuantity;
		//Display the price, payment and amount due
		System.out.println("The Price for your Order is: " + price);
		System.out.println("Please enter the amount of your payment: ");
		payment = input.nextFloat();
		
		
		System.out.println("\n\nThe Price for your Order is: $" + price);
		System.out.println("Your payment is: $" + payment);
		System.out.println("The amount due back is: $" + (payment - price));
		
		
	}
	
	/*Enter the Restaurant Items in the function for the Menu List*/
	
	public static void displaMenu(MenuItem menu[]){
		menu[0] = new MenuItem("Item 1", 10);
		menu[1] = new MenuItem("Item 2", 20);
		menu[2] = new MenuItem("Item 3", 30);
		menu[3] = new MenuItem("Item 4", 40);
		menu[4] = new MenuItem("Item 5", 50);
		menu[5] = new MenuItem("Item 6", 60);
		menu[6] = new MenuItem("Item 7", 70);
		menu[7] = new MenuItem("Item 8", 80);
		menu[8] = new MenuItem("Item 9", 90);
		menu[9] = new MenuItem("Item 10", 100);
		
		System.out.println("My Restaurant Menu:");
		System.out.println("   Item Name  \t  Price");
		
		for (int i = 1; i <= 10; i++){
			System.out.print(i + ". ");
			System.out.println(menu[i - 1].itemName + "\t$" + menu[i - 1].itemPrice);
		}		
	}

}
