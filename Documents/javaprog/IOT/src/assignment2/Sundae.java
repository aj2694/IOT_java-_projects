package assignment2;

public class Sundae extends IceCream{

	int price_of_topping;
	String name_of_topping;
	public Sundae(String name_of_icecream,int price_of_icecream,String name_of_topping, int price_of_topping) {
		// TODO Auto-generated constructor stub
		super(name_of_icecream,price_of_icecream);
		this.name_of_topping=name_of_topping;
		this.price_of_topping=price_of_topping;
	}
	public int getPrice_of_Sundae() {
		return price_of_topping+super.getPrice_of_icecream();
	}
	
	public int getCost()
	{
		int price;
		price=super.getCost()+price_of_topping;
		return price;
		
	}
}
