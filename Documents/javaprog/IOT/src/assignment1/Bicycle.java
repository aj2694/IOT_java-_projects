package assignment1;

public class Bicycle {

	private String bicycle_type;
	private int bicycle_no_of_gears;
    private	int bicycle_wheel_base;
	private int bicycle_height;
	private String bicycle_color;
	private String bicycle_construction_material;
	
	Bicycle(String bicycle_type,int bicycle_no_of_gears,int bicycle_wheel_base,int bicycle_height,String bicycle_color,String bicycle_construction_materia)
	{
		this.bicycle_type=bicycle_type;
		this.bicycle_no_of_gears=bicycle_no_of_gears;
		this.bicycle_height=bicycle_height;
		this.bicycle_color=bicycle_color;
		this.bicycle_wheel_base=bicycle_wheel_base;
		this.bicycle_construction_material=bicycle_construction_materia;
	}
	static public int return_compare_param(String param_compare,Bicycle bike)
	{
	
		//System.out.println(param_compare);
		if(param_compare.equals("Height"))
		{
			return bike.getBicycle_height();
		}
		else if(param_compare.equals("Number_of_gears"))
		{
			return bike.getBicycle_no_of_gears();
		}
		else if(param_compare.equals("Wheel_Base"))
		{
			return bike.getBicycle_wheel_base();
		}
		else
		{
			return 0;
		}
		
	}
	
	public String getBicycle_type() {
		return bicycle_type;
	}
	public void setBicycle_type(String bicycle_type) {
		this.bicycle_type = bicycle_type;
	}
	public int getBicycle_no_of_gears() {
		return bicycle_no_of_gears;
	}
	public void setBicycle_no_of_gears(int bicycle_no_of_gears) {
		this.bicycle_no_of_gears = bicycle_no_of_gears;
	}
	public int getBicycle_wheel_base() {
		return bicycle_wheel_base;
	}
	public void setBicycle_wheel_base(int bicycle_wheel_base) {
		this.bicycle_wheel_base = bicycle_wheel_base;
	}
	public int getBicycle_height() {
		return bicycle_height;
	}
	public void setBicycle_height(int bicycle_height) {
		this.bicycle_height = bicycle_height;
	}
	public String getBicycle_color() {
		return bicycle_color;
	}
	public void setBicycle_color(String bicycle_color) {
		this.bicycle_color = bicycle_color;
	}
	public String getBicycle_construction_material() {
		return bicycle_construction_material;
	}
	public void setBicycle_construction_material(String bicycle_construction_material) {
		this.bicycle_construction_material = bicycle_construction_material;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
