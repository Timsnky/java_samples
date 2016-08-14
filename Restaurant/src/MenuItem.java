/*
 * This class will hold the Item Name and Item Price 
 * for each of the Item in the Menu so that they can 
 * easilty retrieved after user selection
 */
public class MenuItem {
	
	public String itemName;
	public float itemPrice;
	
	public MenuItem(String itemName, float itemPrice){
		this.itemName = itemName;
		this.itemPrice = itemPrice;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public float getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(float itemPrice) {
		this.itemPrice = itemPrice;
	}
}
