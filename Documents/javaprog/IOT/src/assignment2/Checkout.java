package assignment2;

import java.util.Vector;

public class Checkout {

	Vector<DessertItem>DessertItemList;
	static int index=0;
	public Checkout() {
		// TODO Auto-generated constructor stub
		DessertItemList=new Vector<DessertItem>();
	}
	void clear(){
		index=0;
		DessertItemList.clear();
	}
	void enterItem(DessertItem item){
		index++;
		DessertItemList.add(item);
		
	}
	int numberOfItems(){
		return index;
	}
	int totalCost()
	{
		int total_cost=0;
		for(DessertItem i:this.DessertItemList)
		{
		
			total_cost+=i.getCost();
			
		}
		return total_cost;
	}
	int  totalTax()
	{
		int total_tax;
		int total_cost=0;
		for(DessertItem i:this.DessertItemList)
		{
			total_cost+=i.getCost();
			
		}
		total_tax=(int)(total_cost*DessertShoppe.TAX_RATE/100);
		return total_tax;
		
		
		
	}
	@Override
	public String toString() {
		String check_out_string=DessertShoppe.STORE_NAME;
		check_out_string+=System.lineSeparator();
		check_out_string+="*******************";
		check_out_string+=System.lineSeparator();
		int total_cost=0;
		
		for(DessertItem i:DessertItemList)
		{
		
			check_out_string+=String.format("%-30s %s", i.getName(),DessertShoppe.cents2dollarsAndCents( i.getCost()));
			check_out_string+=System.lineSeparator();
			total_cost+=i.getCost();
		}
		check_out_string+="Total"+"                          "+DessertShoppe.cents2dollarsAndCents(total_cost);
		check_out_string+=System.lineSeparator();
		int total_tax=(int)(total_cost*DessertShoppe.TAX_RATE/100);
		check_out_string+="Total with tax"+"                 "+DessertShoppe.cents2dollarsAndCents(total_cost+total_tax);       
	
		return check_out_string;
	}
	
}
