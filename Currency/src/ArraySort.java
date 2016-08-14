import java.util.Scanner;

public class ArraySort {
	public static void main(String [] args){
		int index = 0;
		int[] inputArray ={4,11,15,36,99,1,56,42,3};
		arraySort(inputArray);		
	}
	
	public static void arraySort( int [] inputArray )
	{
	     int index = 0;
	     boolean swapped = true;
	     int temp;
	     
	     while(index < inputArray.length){
			System.out.print(inputArray[index] + " , ");
			index ++;
		 }

	     while ( swapped ){
	    	 swapped= false; 
	    	 for( index = 0;  index < inputArray.length - 1;  index++ ){
	    		 if (inputArray[index] > inputArray[index + 1]){
	    			 temp = inputArray[index];
	                 inputArray[index] = inputArray[index + 1];
	                 inputArray[index + 1 ] = temp;
	                 swapped = true;
	             }
	         }
	    }
	     index = 0;
	     System.out.println();
	     while(index < inputArray.length){
				System.out.print(inputArray[index] + " , ");
				index ++;
		}
	}	 
}
