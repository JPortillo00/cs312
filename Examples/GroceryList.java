public class GroceryList {
	private final int MAX_NO_ITEMS = 10;
	private GroceryItemOrder [] list;
	private int noOfItems = 0;
	
	public GroceryList () {		
		list = new GroceryItemOrder[MAX_NO_ITEMS];
	}
	
	public void add(GroceryItemOrder item) {
		if (noOfItems >= MAX_NO_ITEMS) {
			System.out.println("List full.");
			throw new IllegalArgumentException();
		}		
		list[noOfItems] = item;
		noOfItems++;
	}
	
	public int getNumberOfItems () {
		return noOfItems;
	}
	
	public double getTotalCost () {
		double cost = 0.0;
		for (int i = 0; i < noOfItems; i++) {
			cost += list[i].getCost();
		}
		return cost;
	}
	
	public void print() {
		for (int i = 0; i < noOfItems; i ++ ) {
			System.out.println(list[i].toString());
		}		
	}	
}