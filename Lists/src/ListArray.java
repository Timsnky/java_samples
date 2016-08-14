import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class ListArray implements ListInterface{
	
	private Object elements[];
	private int defaultLength = 100000;
	private int size = 0;
	private int stepIndex;
	
	public ListArray(){
		elements = new Object[defaultLength];
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (size == 0);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public void add(Object obj) {
		// TODO Auto-generated method stub
		if(size == elements.length){
			int newSize = elements.length * 2;
			elements = Arrays.copyOf(elements, newSize);
		}		
		elements[size++] = obj;		
	}
	

	@Override
	public boolean add(Object obj, int index) {
		// TODO Auto-generated method stub
		if(index > size){
			return false;
		}else{
			int x;
			if(size == elements.length){
				int newSize = elements.length * 2;
				elements = Arrays.copyOf(elements, newSize);
			}
			for( x = index; x <= size; x++){
				if (x == size){
					elements[x] = obj;
				}else{
					Object temp = elements[x];
					elements[x] = obj;
					obj = temp;	
				}							
			}
			size ++;
			return true;
		}
	}

	@Override
	public void addSorted(Object obj) {
		// TODO Auto-generated method stub
		int index = 0;
		if( size == 0){
			add(obj);
		}else{
			
			while( index < size){
				if((int)(elements[index]) > (int)obj){
					add(obj, index);
					break;
				}
				index ++;
			}
			if( index == size){
				add(obj, index);
			}
		}		
	}

	@Override
	public Object getObject(int index) {
		// TODO Auto-generated method stub
		if(index >= size || index < 0){
			return null;
		}else{
			return elements[index];
		}
	}

	@Override
	public Object getFirstObject() {
		// TODO Auto-generated method stub
		if(size == 0){
			return null;
		}else{
			stepIndex = 1;
			return elements[0];
		}
	}

	@Override
	public Object getNextObject() {
		// TODO Auto-generated method stub
		if( stepIndex == 0){
			System.out.println("You should call getObject First");
			return null;
		}else{
			if(stepIndex == size){
				stepIndex = 0;
				return null;
			}else{
				return elements[stepIndex ++];
			}			
		}				
	}

	@Override
	public boolean remove(int index) {
		// TODO Auto-generated method stub
		if(index >= size){
			return false;
		}else{
			for( int i = index; i < size - 1; i++){
				elements[i] = elements[i + 1];
			}
			size --;
			return true;
		}
	}

	@Override
	public void removeAll() {
		// TODO Auto-generated method stub
		for( int i = 0; i < size; i ++){
			elements[i] = null;
		}
		size = 0;
	}
	
	/*public String toString(){
		String output = "";
		int i = 0;
		while( i < size){
			output += "[" + elements[i] + "],";
			i ++;
		}
		return output;
	}*/
}
