public class Search {
	public static void main (String [] args){
		long startTime, endTime, duration;
		double data[] = new double[10];
		int test[] = new int[10000000];
		fillArray(test, 10000000);
		int keys[] = {500,10000,100000,1000000,5000000,7000000,10000000};
		int keyIndex = 0;
		
		while(keyIndex < keys.length){
			int tries = 0;
			System.out.println("Binary Search for "+ keys[keyIndex]);
			System.out.println("Trial\tDuration");
			while(tries < 10){
				startTime = System.nanoTime();
				int x = binarySearchRecursive(keys[keyIndex], test, 0, test.length - 1);
				endTime = System.nanoTime();
				duration = (endTime - startTime);
				System.out.println(tries + "\t" + duration);
				data[tries] = duration;
				tries ++;
			}
			Statistics results = new Statistics(data);
			System.out.println("Average: " + results.getMean());
			System.out.println("Standard Deviation: " + results.getStdDev() + "\n");
			
			System.out.println("Linear Search for "+ keys[keyIndex]);
			System.out.println("Trial\tDuration");
			tries = 0;
			while(tries < 10){   
				startTime = System.nanoTime();
				int x = linearSearchIterative(keys[keyIndex], test, 0);
				endTime = System.nanoTime();
				duration = (endTime - startTime);
				System.out.println(tries + "\t" + duration);
				data[tries] = duration;
				tries ++;
			}
			
			results = new Statistics(data);
			System.out.println("Average: " + results.getMean());
			System.out.println("Standard Deviation: " + results.getStdDev() + "\n");
			keyIndex ++;			
		}		
	}
	
	//Binary search algorithm applying recursion technique
	//Uncomment the print statement to see working but comment while testing duration since print statement is time consuming
	public static int binarySearchRecursive(int key, int list[], int min, int max){
		//System.out.print(key + "\t" + min + "\t" + max);
		if(max < min){
			return -1;
		}
		else{
			int mid = min + ((max - min) / 2);
			//System.out.println("\t" + mid +"\t" + list[mid]);
			if(list[mid] < key){
				return binarySearchRecursive(key, list, mid + 1, max);
			}
			else if(list[mid] > key){
				return binarySearchRecursive(key, list, min, mid - 1);
			}
			else{
				return mid;
			}
		}		
	}
	
	//Linear search algorithm applying iteration.
	//Uncomment the print statement to see working but comment while testing duration since print statement is time consuming
	public static int linearSearchIterative(int key, int list[], int start){
		while(start < list.length){
			//System.out.println(start + "\t" + list[start]);
			if(list[start] == key){
				return start;
			}
			else{
				start++;
			}
		}		
		return -1;
	}
	
	//Function to populate the array
	public static void fillArray(int test[], int length){
		int index = 0;
		while(index < length){
			test[index] = index;
			index ++;
		}
	}
}
