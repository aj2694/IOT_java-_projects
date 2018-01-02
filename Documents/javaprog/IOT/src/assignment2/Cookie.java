package assignment2;

public class Cookie extends DessertItem{

	private int number_of_cookies;
	private int price_per_cookie;
	
	public Cookie(String name,int number_of_cookies,int price_per_cookie)
	{
		super(name);
		this.number_of_cookies=number_of_cookies;
		this.price_per_cookie=price_per_cookie;
		
		
	}

	
	@Override
	public int getCost() {
		int price;
		price=(number_of_cookies*price_per_cookie)/12;
		//price+=(price*DessertShoppe.TAX_RATE);
		// TODO Auto-generated method stub
		return price;
	}
}
