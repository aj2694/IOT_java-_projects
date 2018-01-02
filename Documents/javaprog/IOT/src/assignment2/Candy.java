package assignment2;

public class Candy extends DessertItem {
	private double candy_weight;
	private int price_per_pound;
	
	public Candy(String name,double candy_weight,int price_per_pound ) {
		super(name);
		this.candy_weight=candy_weight;
		this.price_per_pound=price_per_pound;
		// TODO Auto-generated constructor stub
	}

	public int getCost() {
		int price;
		price=(int)(price_per_pound*candy_weight);
	//	price+=(price*DessertShoppe.TAX_RATE);
		// TODO Auto-generated method stub
		return price;
	}

}
