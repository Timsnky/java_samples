import java.util.Iterator;


public class QueueTests {
	public static void main(String [] args){
		addToQueue();	
		removeFromQueue();
		displayStrings();
		displayAndRemoveStrings();
	}
	
	public static void displayStatistics(double [] data){
		Statistics results = new Statistics(data);
		System.out.println("Average: " + results.getMean());
		System.out.println("Standard Deviation: " + results.getStdDev() + "\n");
	}
	
	public static QueueArray populateArrayQueue(){
		QueueArray queue = new QueueArray();
		int i = 1;
		while(i <= 100000){
			queue.add(i);
			i ++;
		}
		return queue;
	}
	
	public static ReferenceQueue populateReferenceQueue(){
		ReferenceQueue queue = new ReferenceQueue();
		int i = 1;
		while(i <= 100000){
			queue.add(i);
			i ++;
		}
		return queue;
	}
	
	public static QueueArray populateStringArrayQueue(){
		QueueArray queue = new QueueArray(100);
		int i = 1;
		while(i <= 100){
			queue.add("String " + i);
			i ++;
		}
		return queue;
	}
	
	public static ReferenceQueue populateStringReferenceQueue(){
		ReferenceQueue queue = new ReferenceQueue();
		int i = 1;
		while(i <= 100){
			queue.add("String " + i);
			i ++;
		}
		
		return queue;
	}
	
	public static void addToQueue(){
		long startTime, endTime, duration;
		int tries = 0;
		double data[] = new double[10];
		
		System.out.println("Adding Integers to an Array Queue");
		System.out.println("Trial\tDuration");	
		while(tries < 10){
			QueueArray queue = new QueueArray();
			int i = 1;
			startTime = System.nanoTime();
			while(i <= 100000){
				queue.add(i);
				i++;
			}
			endTime = System.nanoTime();
			duration = endTime - startTime;
			System.out.println(tries + "\t" + duration);
			data[tries] = duration;
			tries ++;
		}
		displayStatistics(data);
		
		tries = 0;
		System.out.println("Adding Integers to a Reference Queue");
		System.out.println("Trial\tDuration");	
		while(tries < 10){
			ReferenceQueue queue = new ReferenceQueue();
			int i = 1;
			startTime = System.nanoTime();
			while(i <= 100000){
				queue.add(i);
				i++;
			}
			endTime = System.nanoTime();
			duration = endTime - startTime;
			System.out.println(tries + "\t" + duration);
			data[tries] = duration;
			tries ++;
		}
		displayStatistics(data);
	}
	
	public static void removeFromQueue(){
		long startTime, endTime, duration;
		int tries = 0;
		double data[] = new double[10];
		
		System.out.println("Removing Integers from an Array Queue");
		System.out.println("Trial\tDuration");	
		while(tries < 10){
			QueueArray queue = populateArrayQueue();			
			int i = 1;
			startTime = System.nanoTime();
			while (! queue.isEmpty()){
				queue.remove();
			}
			endTime = System.nanoTime();
			duration = endTime - startTime;
			System.out.println(tries + "\t" + duration);
			data[tries] = duration;
			tries ++;
		}
		displayStatistics(data);
		
		tries = 0;
		System.out.println("Removing Integers from a Reference Queue");
		System.out.println("Trial\tDuration");	
		while(tries < 10){
			ReferenceQueue queue = populateReferenceQueue();
			
			int i = 1;
			startTime = System.nanoTime();
			while (! queue.isEmpty()){
				queue.remove();
			}
			endTime = System.nanoTime();
			duration = endTime - startTime;
			System.out.println(tries + "\t" + duration);
			data[tries] = duration;
			tries ++;
		}
		displayStatistics(data);
		
	}

	public static void displayStrings(){
		long startTime, endTime, duration;
		int tries = 0;
		double data[] = new double[10];
		
		System.out.println("Display data from Array Queue using Iterator");
		System.out.println("Trial\tDuration");	
		while(tries < 10){
			QueueArray queue = populateStringArrayQueue();
			Iterator iterator = queue.iterator();
			startTime = System.nanoTime();
			while( iterator.hasNext()){
				System.out.println(iterator.next());
			}
			endTime = System.nanoTime();
			duration = endTime - startTime;
			System.out.println(tries + "\t" + duration);
			data[tries] = duration;
			tries ++;
		}
		displayStatistics(data);
		
		tries = 0;
		System.out.println("Display data from Reference Queue using Iterator");
		System.out.println("Trial\tDuration");	
		while(tries < 10){
			ReferenceQueue queue = populateStringReferenceQueue();
			Iterator iterator = queue.iterator();
			startTime = System.nanoTime();
			while( iterator.hasNext()){
				System.out.println(iterator.next());
			}
			endTime = System.nanoTime();
			duration = endTime - startTime;
			System.out.println(tries + "\t" + duration);
			data[tries] = duration;
			tries ++;
		}
		displayStatistics(data);
	}
	
	public static void displayAndRemoveStrings(){
		long startTime, endTime, duration;
		int tries = 0;
		double data[] = new double[10];
		
		System.out.println("Display data from Array Queue using Iterator");
		System.out.println("Trial\tDuration");	
		while(tries < 10){
			QueueArray queue = populateStringArrayQueue();
			queue.displayQueue();
			Iterator iterator = queue.iterator();
			startTime = System.nanoTime();
			while( iterator.hasNext()){
				System.out.println(iterator.next());
				iterator.remove();
			}
			queue.displayQueue();
			endTime = System.nanoTime();
			duration = endTime - startTime;
			System.out.println(tries + "\t" + duration);
			data[tries] = duration;
			tries ++;
		}
		displayStatistics(data);
		
		tries = 0;
		System.out.println("Display data from Reference Queue using Iterator");
		System.out.println("Trial\tDuration");	
		while(tries < 10){
			ReferenceQueue queue = populateStringReferenceQueue();
			queue.displayQueue();
			Iterator iterator = queue.iterator();
			startTime = System.nanoTime();
			while( iterator.hasNext()){
				System.out.println(iterator.next());
				iterator.remove();
			}
			queue.displayQueue();
			endTime = System.nanoTime();
			duration = endTime - startTime;
			System.out.println(tries + "\t" + duration);
			data[tries] = duration;
			tries ++;
		}
		displayStatistics(data);
	}
}
