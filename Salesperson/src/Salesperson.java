
public class Salesperson {
	private int sales;
	private String name;
	
	/*Empty constructor incase the user wishes to initialise the object
	 * without parameters
	 */
	public Salesperson(){
		
	}
	
	/* Salesperson constructor requiring the name and total 
	 * sales made by the salesperson
	 */
	public Salesperson(int sales, String name){
		this.sales = sales;
		this.name = name;
	}

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	/*Display the properties of the selected salesperson*/
	public String display(){
		return "Name: " + this.name + "\nTotal Sales: " + this.sales;		
	}

}
