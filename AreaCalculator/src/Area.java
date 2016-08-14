
public class Area {
	
	public static double findArea(int radius){
		return Math.PI * radius * radius;
	}
	
	public static double findArea(int length, int width){
		return length * width;
	}
	
	public static double findArea(int length, int width, int height){
		return length * width * height * .5;
	}
	
	public static void main(String [] args){
		double circleArea, rectangleArea, trapezoidArea;
		
		circleArea = findArea(3);
		rectangleArea = findArea(2,4);
		trapezoidArea = findArea(3,5,5);
		
		System.out.printf("%.2f\n", circleArea);
		System.out.println(rectangleArea);
		System.out.print(trapezoidArea);
		
	}

}
