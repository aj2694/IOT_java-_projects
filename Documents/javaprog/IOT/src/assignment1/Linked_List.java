package assignment1;

public class Linked_List {

	private static Linked_List Nodes = null;
	Bicycle link_bike;
	Linked_List Next;
	
	public Linked_List(Bicycle V)  
	{
		link_bike=new Bicycle(V.getBicycle_type(), V.getBicycle_no_of_gears(),V.getBicycle_wheel_base(),V.getBicycle_height(), V.getBicycle_color(),V.getBicycle_construction_material());
		
		Next = null;
		
	}
	public static Linked_List Head()  
	{
		return Nodes;
	}
	public void Insert()  
	{
		
	
		if (Nodes == null)  
		{
			Nodes = this;
			return;
		}
		if (Bicycle.return_compare_param(ShowBike.getArg_type_sorting(), link_bike)<Bicycle.return_compare_param(ShowBike.getArg_type_sorting(), Nodes.link_bike) )  
		{
			Next = Nodes;
			Nodes = this;
			return;
		}
		else if (Nodes.Next == null)  
		{
			Nodes.Next = this;
			return;
		}
		for (Linked_List N = Nodes; N.Next != null; N = N.Next)  
		{
			if (Bicycle.return_compare_param(ShowBike.getArg_type_sorting(), link_bike) <Bicycle.return_compare_param(ShowBike.getArg_type_sorting(), N.Next.link_bike))  
			{
				
				Next = N.Next;
				N.Next = this;
				return;
			}
			else if (N.Next.Next == null)  
			{
				N.Next.Next = this;
				return;
				}
			}
		}
	public static void PrintList()  
	{
		if (Nodes == null) 
			return;
		for (Linked_List N = Nodes; N != null; N = N.Next)
			System.out.println("Bicycle Type: "+N.link_bike.getBicycle_type()+" Bicycle Color: "+N.link_bike.getBicycle_color()+" Bicycle Construction Material : "+N.link_bike.getBicycle_construction_material()+" Bicycle Height : "+N.link_bike.getBicycle_height()+" Bicycle number of gears : "+N.link_bike.getBicycle_no_of_gears()+" Bicycle wheel base : "+N.link_bike.getBicycle_wheel_base());
	}
}
