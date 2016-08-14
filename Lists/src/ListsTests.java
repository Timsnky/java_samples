
public class ListsTests {
	public static void main(String [] args){
		addSortedOdd();
		add();
		addIndexed();
		removeOdd();
	}
	
	public static void displayStatistics(double [] data){
		Statistics results = new Statistics(data);
		System.out.println("Average: " + results.getMean());
		System.out.println("Standard Deviation: " + results.getStdDev() + "\n");
	}
	
	public static void addSortedOdd(){
		long startTime, endTime, duration;
		int tries = 0;
		double data[] = new double[10];
		double data2[] = new double[10];
		
		System.out.println("Adding Sorted Odd Numbers in Array List");
		System.out.println("Trial\tDuration");	
		while(tries < 10){
			startTime = System.currentTimeMillis();
			int i = 1;
			ListArray list = new ListArray();
			while(i <= 100000){
				if((i % 2) != 0){
					list.addSorted(i);
				}				
				i++;
			}			
			endTime = System.currentTimeMillis();
			duration = endTime - startTime;
			System.out.println(tries + "\t" + duration);
			data[tries] = duration;
			
			startTime = System.currentTimeMillis();
			i = 1;
			while(i <= 100000){
				if((i % 2) == 0){
					list.addSorted(i);
				}				
				i++;
			}
			endTime = System.currentTimeMillis();
			duration = endTime - startTime;
			data2[tries] = duration;
			
			list.removeAll();
			
			tries ++;
		}
		displayStatistics(data);
		System.out.println("Adding Sorted Even Numbers in Array List");
		System.out.println("Trial\tDuration");	
		tries = 0;
		while(tries < 10){
			System.out.println(tries + "\t" + data2[tries]);
			tries ++;
		}
		displayStatistics(data2);
		tries = 0;
		
		System.out.println("Adding Sorted Odd Numbers in Linked List");
		System.out.println("Trial\tDuration");	
		while(tries < 10){
			startTime = System.currentTimeMillis();
			int i = 1;
			ListLinked list = new ListLinked();
			while(i <= 5000){
				if((i % 2) != 0){
					list.addSorted(i);
				}				
				i++;
			}
			endTime = System.currentTimeMillis();
			duration = endTime - startTime;
			System.out.println(tries + "\t" + duration);
			data[tries] = duration;
			
			startTime = System.currentTimeMillis();
			i = 1;
			while(i <= 5000){
				if((i % 2) == 0){
					list.addSorted(i);
				}				
				i++;
			}
			endTime = System.currentTimeMillis();
			duration = endTime - startTime;
			data2[tries] = duration;
			
			list.removeAll();
			
			tries ++;
		}
		displayStatistics(data);
		System.out.println("Adding Sorted Even Numbers in Linked List");
		System.out.println("Trial\tDuration");	
		tries = 0;
		while(tries < 10){
			System.out.println(tries + "\t" + data2[tries]);
			tries ++;
		}
		displayStatistics(data2);
	}

	public static void add(){
		long startTime, endTime, duration;
		int tries = 0;
		double data[] = new double[10];
		double data2[] = new double[10];
		
		System.out.println("Adding Numbers in Array List");
		System.out.println("Trial\tDuration");	
		ListArray list = new ListArray();
		while(tries < 10){
			startTime = System.currentTimeMillis();
			int i = 1;
			
			while(i <= 100000){
				list.add(i);			
				i++;
			}
			endTime = System.currentTimeMillis();
			duration = endTime - startTime;
			System.out.println(tries + "\t" + duration);
			data[tries] = duration;
			
			i = 0;
			startTime = System.currentTimeMillis();			
			while(i < list.size()){
				if(((int)list.getObject(i) % 2) == 0){
					list.remove(i);
					i = 0;
				}	
				i++;
			}	
			endTime = System.currentTimeMillis();
			duration = endTime - startTime;
			data2[tries] = duration;
			
			tries ++;
			
			list.removeAll();
		}
		displayStatistics(data);
		
		System.out.println("Removing Numbers from Array List");
		System.out.println("Trial\tDuration");	
		tries = 0;
		while(tries < 10){
			System.out.println(tries + "\t" + data2[tries]);
			tries ++;
		}
		displayStatistics(data2);	
		tries = 0;
		
		System.out.println("Adding Numbers in Linked List");
		System.out.println("Trial\tDuration");	
		ListLinked list2 = new ListLinked();
		while(tries < 10){
			startTime = System.currentTimeMillis();
			int i = 1;
			
			while(i <= 5000){
				list2.add(i);				
				i++;
			}
			endTime = System.currentTimeMillis();
			duration = endTime - startTime;
			System.out.println(tries + "\t" + duration);
			data[tries] = duration;
			
			i = 0;
			startTime = System.currentTimeMillis();			
			while(i < list2.size()){
				if(((int)list2.getObject(i) % 2) == 0){
					list2.remove(i);
					i = 0;
				}	
				i++;
			}
			endTime = System.currentTimeMillis();
			duration = endTime - startTime;
			data2[tries] = duration;
			
			tries ++;
			
			list2.removeAll();
		}
		displayStatistics(data);
		
		System.out.println("Removing Numbers from Linked List");
		System.out.println("Trial\tDuration");	
		tries = 0;
		while(tries < 10){
			System.out.println(tries + "\t" + data2[tries]);
			tries ++;
		}
		displayStatistics(data2);		
		tries = 0;
	}

	public static void addIndexed(){
		long startTime, endTime, duration;
		int tries = 0;
		double data[] = new double[10];
		double data2[] = new double[10];
		
		System.out.println("Adding Indexed Numbers in Array List");
		System.out.println("Trial\tDuration");	
		ListArray list = new ListArray();
		while(tries < 10){
			startTime = System.currentTimeMillis();
			int i = 1;
			
			while(i <= 100000){
				list.add(i,0);			
				i++;
			}
			endTime = System.currentTimeMillis();
			duration = endTime - startTime;
			System.out.println(tries + "\t" + duration);
			data[tries] = duration;
			
			tries ++;
			
			list.removeAll();
		}
		displayStatistics(data);
		
		tries = 0;
		
		System.out.println("Adding Indexed Numbers in Linked List");
		System.out.println("Trial\tDuration");	
		ListLinked list2 = new ListLinked();
		while(tries < 10){
			startTime = System.currentTimeMillis();;
			int i = 1;
			
			while(i <= 5000){
				list2.add(i, 0);				
				i++;
			}
			endTime = System.currentTimeMillis();
			duration = endTime - startTime;
			System.out.println(tries + "\t" + duration);
			data[tries] = duration;
			
			tries ++;
			
			list2.removeAll();
		}
		displayStatistics(data);
	}

	public static void removeOdd(){
		long startTime, endTime, duration;
		int tries = 0;
		double data[] = new double[10];
		double data2[] = new double[10];
		
		System.out.println("Removing Odd Numbers from Array List");
		System.out.println("Trial\tDuration");	
		ListArray list = new ListArray();
		int x = 1;
		int i;
		
		while(tries < 10){
			x = 1;
			while( x <= 100000){
				list.add(x);
				x ++;
			}
			i = list.size() - 1;
			startTime = System.currentTimeMillis();			
			while(i < list.size() && i >= 0){
				if(((int)list.getObject(i) % 2) != 0){
					list.remove(i);
					i = list.size() - 1;
				}	
				i--;
			}
			endTime = System.currentTimeMillis();
			duration = endTime - startTime;
			System.out.println(tries + "\t" + duration);
			data2[tries] = duration;
			
			tries ++;
			
			list.removeAll();
		}
		displayStatistics(data);
		
		tries = 0;
		
		System.out.println("Removing Odd Numbers from Linked List");
		System.out.println("Trial\tDuration");	
		ListLinked list2 = new ListLinked();
		while(tries < 10){
			x = 1;
			
			while(x <= 5000){
				list2.add(x);				
				x++;
			}
			i = list2.size() - 1;
			startTime = System.currentTimeMillis();			
			while(i < list2.size() && i >= 0){
				if(((int)list2.getObject(i) % 2) != 0){
					list2.remove(i);
					i = list2.size() - 1;
				}	
				i--;
			}	
			endTime = System.currentTimeMillis();
			duration = endTime - startTime;
			System.out.println(tries + "\t" + duration);
			data[tries] = duration;
			tries ++;
			
			list2.removeAll();
		}
		displayStatistics(data);		
	}
}
