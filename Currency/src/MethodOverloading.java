
public class MethodOverloading {
	public static void main(String [] args){
		area(7);
		area(6,9);
	}
	
	public static void area(int x){
		double area = Math.PI * x * x;
		System.out.println("The Area is " + area);
	}
	
	public static void area(int x, int y){
		double area = x * y;
		System.out.println("The Area is " + area);
	}
}

