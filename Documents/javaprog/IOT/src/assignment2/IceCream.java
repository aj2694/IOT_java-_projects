package assignment2;

public class IceCream extends DessertItem {
	private int price_of_icecream;
	public IceCream() {
		// TODO Auto-generated constructor stub
	}
	public IceCream(String name, int price_of_icecream) {
		super(name);
		this.price_of_icecream=price_of_icecream;
	}
	public int getPrice_of_icecream() {
		return price_of_icecream;
	}
	

	@Override
	public int getCost() {
		int price;
		price=price_of_icecream;
		return price;
	
		}

}
