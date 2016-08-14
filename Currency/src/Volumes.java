import java.util.Scanner;

public class Volumes {
	public static Scanner input = new Scanner(System.in);
	
	public static void main(String [] args){
		int choice;
		
		System.out.println("Select the Shape you wish to compute its volume:\n1. Cylinder\n2. Sphere\n3. Pyramid");
		choice = input.nextInt();
		switch(choice){
		case 1:
			cylinder();
			break;
		case 2:
			sphere();
			break;
		case 3:
			pyramid();
			break;
		default:
			System.out.println("You Selected a wrong Choice: ");
			break;
		}
	}
	
	public static void cylinder(){
		double height, radius, volume;
		System.out.println("Enter the Height of the Cylinder(in meters): ");
		height = input.nextFloat();
		System.out.println("Enter the Radius of the Cylinder(in meters): ");
		radius = input.nextDouble();
		volume = Math.PI * radius * radius * height;
		System.out.println("The Volume of the Cylinder is " + volume + " m^3");
	}
	
	public static void sphere(){
		double radius, volume;
		System.out.println("Enter the Radius of the Sphere(in meters): ");
		radius = input.nextFloat();
		volume = 4 * Math.PI * radius * radius * radius / 3;
		System.out.println("The Volume of the Sphere is " + volume + " m^3");
	}
	
	public static void pyramid(){
		double height, width, length, volume;
		System.out.println("Enter the Height of the Pyramid(in meters): ");
		height = input.nextFloat();
		System.out.println("Enter the Width of the Pyramid(in meters): ");
		width = input.nextDouble();
		System.out.println("Enter the Length of the Pyramid(in meters): ");
		length = input.nextDouble();
		volume = length * width * height / 3; 
		System.out.println("The Volume of the Pyramid is " + volume + " m^3");
	}
}
