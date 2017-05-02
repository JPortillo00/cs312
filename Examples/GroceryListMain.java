public class GroceryListMain {

	public static void main(String[] args) {
		GroceryList list = new GroceryList();
		
		GroceryItemOrder sugar = new GroceryItemOrder("sugar", 2, 2.50);
		GroceryItemOrder milk = new GroceryItemOrder("milk", 3, 4.0);
		GroceryItemOrder bread = new GroceryItemOrder("bread", 1, 3.75);

		list.add(sugar);
		list.add(milk);
		list.add(bread);
		System.out.println(list.getTotalCost());
		list.print();
		
		sugar.setQuantity(4);
		System.out.println(list.getTotalCost());
		list.print();
	}
}