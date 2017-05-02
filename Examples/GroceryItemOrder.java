public class GroceryItemOrder {
	
	String name;
	int quantity;
	double pricePerUnit;

	public GroceryItemOrder (String name, int quantity, double pricePerUnit) {
		this.name = name;
		this.quantity = quantity;
		this.pricePerUnit = pricePerUnit;
	}
	
	public double getCost() {		
		return quantity*pricePerUnit;
	}
	
	public void setQuantity (int quantity) {
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public int getQuantity() {
		return quantity;
	}
	
	public String toString () {
		return String.format("%10s %3d %5.2f %6.2f", name, quantity, pricePerUnit, getCost());
	}
}