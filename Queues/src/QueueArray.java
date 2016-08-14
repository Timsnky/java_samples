import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class QueueArray implements QueueInterface {
	
	private Object [] elements;
	private int capacity = 100000;
	private int size ;
	private int front;
	private int back;
	
	public QueueArray(){
		elements = new Object[capacity];
		this.front = -1;
		this.back = -1;
		this.size = 0;
	}
	
	public QueueArray(int capacity){
		elements = new Object[capacity];
		this.front = -1;
		this.back = -1;
		this.size = 0;
		this.capacity = capacity;
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
	public boolean add(Object e) throws IllegalStateException,
			ClassCastException, NullPointerException {
		// TODO Auto-generated method stub
		if (size == capacity){
			throw new IllegalStateException("Queue is Full");
		}else if(size == 0){
			front = 0;
			back = 0;
			elements[back] = e;	
			size ++;
			return true;
		}else{
			back = (back + 1) % capacity;
			elements[back] = e;
			size ++;
			return true;
		}
	}

	@Override
	public Object element() throws NoSuchElementException {
		// TODO Auto-generated method stub
		if(! isEmpty()){
			return elements[front];
		}else{
			throw new NoSuchElementException("Queue is Empty");
		}
	}

	@Override
	public Object remove() throws NoSuchElementException {
		// TODO Auto-generated method stub
		Object element = null;
		if( isEmpty()){
			throw new NoSuchElementException("Queue is Empty");
		}else if(size == 1){
			element = elements[front];
			elements[front] = null;
			front = -1;
			back = -1;
			size --;
		}else{
			element =  elements[front];
			elements[front] = null;
			front = (front + 1) % capacity;			
			size --;
		}
		return element;
	}

	@Override
	public Object remove(int index) throws NoSuchElementException {
		// TODO Auto-generated method stub
		if( isEmpty()){
			throw new NoSuchElementException("Queue is Empty");		
		}else if( index < 0 || index >= size){
			throw new NoSuchElementException("Invalid Index");	
		}else{
			Object element = elements[index];
			size --;
			return element;
		}
	}

	@Override
	public void removeAll() {
		// TODO Auto-generated method stub
		front = -1;
		back = -1;
		size = 0;
		elements = new Object[capacity];
		
	}
	
	public void displayQueue(){
		String output = "";
		output += Arrays.toString(elements);
		System.out.println(output);	
		
	}
	
	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return new ArrayIterator(this);
	}
	
	private class ArrayIterator implements Iterator{

		private QueueArray queue = null;
		private int start = 0;
		
		public ArrayIterator(QueueArray queue){
			this.queue = queue;		
			this.start = queue.front;
		}
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			if(queue.isEmpty()){
				return false;
			}else{
				if(start <= queue.back){
					return true;
				}else{
					return false;
				}
			}			
		}

		@Override
		public Object next() {
			// TODO Auto-generated method stub
			int index = start;
			start ++;
			return queue.elements[index];
		}	
		
		@Override
		public void remove() {
			// TODO Auto-generated method stub
			queue.remove();
		}
	}

}
