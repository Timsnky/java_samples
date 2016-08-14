import java.util.Scanner;

public class InvoiceTest {
	public static void main(String [] args){
		//Initialising the variables for the Invoice
		String partNumber, partDescription;
		int quantity;
		double price;		
		Scanner input = new Scanner(System.in);
		
		//Prompting the User to Enter the Data required for an Invoice
		System.out.println("Enter the Part Number for the Item:");
		partNumber = input.nextLine();
		System.out.println("Enter the Part Description for the Item:");
		partDescription = input.nextLine();
		System.out.println("Enter the Quantity of the Item Bought:");
		quantity = input.nextInt();
		System.out.println("Enter the Price per Item for the Item:");
		price = input.nextDouble();
		
		//Instatiating the object with the provided input parameters
		Invoice invoice = new Invoice(partNumber,partDescription, quantity, price);
		
		//Displaying the object properties using the getter methods for the class
		System.out.println("\nThe Invoice details are:");
		System.out.println("Part Number: " + invoice.getPartNumber());
		System.out.println("Part Description: " + invoice.getPartDescription());
		System.out.println("Quantity Purchased: " + invoice.getQuantity());
		System.out.println("Price per Item: " + invoice.getPrice());
		System.out.println("Invoice Amount: " + invoice.getInvoiceAmount());		
	}

}
