import java.util.Iterator;
import java.util.NoSuchElementException;


public class ReferenceQueue implements QueueInterface {

	private Link frontLink;
	private Link backLink;
	private int size;
	private int capacity = 100000;
	
	public ReferenceQueue(){
		frontLink = null;
		backLink = null;
		size = 0;
	}
	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return new ReferenceIterator(this);
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
		if( size == capacity){
			throw new IllegalStateException("Queue is Full");
		}else if(size == 0){
			frontLink = new Link(e);
			backLink = frontLink;
			size ++;
			return true;
		}else{
			Link currentLastLink = backLink;
			backLink = new Link(e);
			currentLastLink.nextLink = backLink;
			size ++;
			return true;
		}
	}

	@Override
	public Object element() throws NoSuchElementException {
		// TODO Auto-generated method stub
		if(isEmpty()){
			throw new NoSuchElementException("Queue is Empty");
		}else{
			return frontLink;
		}		
	}

	@Override
	public Object remove() throws NoSuchElementException {
		// TODO Auto-generated method stub
		Object element = null;
		if(isEmpty()){
			throw new NoSuchElementException("Queue is Empty");
		}else{
			element = frontLink.data;
			frontLink = frontLink.nextLink;
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
			int i = 0;
			Link currentLink = frontLink;
			while( i < index ){
				currentLink = currentLink.nextLink;
				i++;
			}
			currentLink.nextLink = currentLink.nextLink.nextLink;
			size --;
			return currentLink.nextLink.data;
		}
	}

	@Override
	public void removeAll() {
		// TODO Auto-generated method stub
		frontLink = null;
		backLink = null;
		size = 0;
		
	}
	
	public void displayQueue(){
		Link currentLink = frontLink;
		String output = "";
		
		while(currentLink != null){
			output += "[" + currentLink.data.toString() + "],";
			currentLink = currentLink.nextLink;
		}
		System.out.println(output);
	}
	
	private class Link{
		public Link nextLink;
		public Object data;
		
		public Link(Object obj){
			nextLink = null;
			data = obj;
		}
		
		public Link(Object obj, Link nextLink){
			nextLink = nextLink;
			data = obj;
		}
	}
	
	private class ReferenceIterator implements Iterator{

		private ReferenceQueue queue = null;
		private Link startLink = null;
		
		public ReferenceIterator(ReferenceQueue queue){
			this.queue = queue;		
			this.startLink = queue.frontLink;
		}
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			if(startLink == null){
				return false;
			}else {
				return true;
			}				
		}

		@Override
		public Object next() {
			// TODO Auto-generated method stub
			Object data = startLink.data;
			startLink = startLink.nextLink;
			return data;
		}
		
		@Override
		public void remove() {
			// TODO Auto-generated method stub
			queue.remove();
		}
	}

}
