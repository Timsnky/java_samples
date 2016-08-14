import java.util.Arrays;


public class ListLinked implements ListInterface {
	
	private Link headLink;
	private int size;
	private int stepIndex;
	
	public ListLinked(){
		headLink = null;
		size = 0;		
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
		if (headLink == null){
			headLink = new Link(obj);
			size ++;
		}else{
			Link currentLink = headLink;
			
			while(currentLink.nextLink != null){
				currentLink = currentLink.nextLink;				
			}
			
			Link newLink = new Link(obj);
			currentLink.nextLink = newLink;
			size ++;
		}
	}

	@Override
	public boolean add(Object obj, int index) {
		// TODO Auto-generated method stub
		if(index > size){
			return false;
		}else{
			Link newLink = new Link(obj);
			Link currentLink = headLink;
			if(index == 0){
				headLink = newLink;
				newLink.nextLink = currentLink;
			}else{
				int i = 1;
				
				while(i < index){
					currentLink = currentLink.nextLink;
					i ++;
				}
				 newLink.nextLink = currentLink.nextLink;
				 currentLink.nextLink = newLink;
			}
			size ++;			
			return true;
		}
	}

	@Override
	public void addSorted(Object obj) {
		// TODO Auto-generated method stub
		int index  = 0;
		if(size == 0){
			add(obj);
		}else{
			while( index < size){
				if((int)(getObject(index)) > (int)obj){
					add(obj, index);
					break;
				}
				index ++;
			}
			if(index == size){
				add(obj, index);
			}			
		}
	}

	@Override
	public Object getObject(int index) {
		// TODO Auto-generated method stub
		if( index >= size || index < 0){
			return null;
		}
		Link currentLink = headLink;
		for( int i = 0; i < index; i++){
			currentLink = currentLink.nextLink;
		}
		
		return currentLink.data;		
	}

	@Override
	public Object getFirstObject() {
		// TODO Auto-generated method stub
		stepIndex = 1;
		return headLink.data;
	}

	@Override
	public Object getNextObject() {
		// TODO Auto-generated method stub
		if(stepIndex != 0){
			if (stepIndex >= size){
				stepIndex = 0;
				return null;
			}
			return getObject(stepIndex ++);			
		}else{
			System.out.println("You should call getFirstObject first");
			return null;
		}		
	}

	@Override
	public boolean remove(int index) {
		// TODO Auto-generated method stub
		if (index < 0 || index >= size){
			return false;
		}else{
			if(index == 0){
				headLink = headLink.nextLink;
			}else{
				Link currentLink = headLink;
				
				for(int i = 1; i < index; i++){
					currentLink = currentLink.nextLink;
				}
				currentLink.nextLink = (currentLink.nextLink.nextLink);
			}
			
			size --;
			return true;
		}
	}

	@Override
	public void removeAll() {
		// TODO Auto-generated method stub
		headLink = null;
		size = 0;
		
	}
	
	/*public String toString(){
		Link currentLink = headLink;
		String output = "";
		
		while(currentLink != null){
			output += "[" + currentLink.data.toString() + "],";
			currentLink = currentLink.nextLink;
		}
		return output;
	}*/
}

class Link{
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


