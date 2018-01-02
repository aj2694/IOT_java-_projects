package assignment1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class ShowBike {
public static String arg_type_sorting;
	
	
	
	public static String getArg_type_sorting() {
		return arg_type_sorting;
	}



	public static void setArg_type_sorting(String arg_type_sorting) {
		ShowBike.arg_type_sorting = arg_type_sorting;
	}



	public static void main(String[] args) {
		ArrayList<Bicycle> b=new ArrayList<Bicycle>();
		BufferedReader buffered_reader;
		try {
			buffered_reader = new BufferedReader(new FileReader("database.txt"));
		
		String line;
		String[] parts_of_line;
		Linked_List bike_list;
		String arg_type_bicycle_type="";
		String arg_type_bicycle_gears = "";
		String arg_type_bicycle_wheels="";
		String arg_type_bicycle_height="";
		String arg_type_bicycle_color = "";
		String arg_type_bicycle_material="";
		String arg_type_sorting="";
		ShowBike.setArg_type_sorting(args[args.length-1]);
			
		for(int i=0;i<args.length-1;i++)
		{
	
			if(args[i].equals("Type"))
			{
						
						try{
						
							if(args[i+1].equals("mountain_bike")||args[i+1].equals("street_bike")||args[i+1].equals("race_bike"))
							{
								arg_type_bicycle_type=args[i+1];
							}
							else
							{
								Exception e=new Exception("Invalid bike type");
								throw e;
							}
						
						}
						catch(Exception e)
						{
							
							System.out.println("Unacceptable Type Error:Data does not exit in database");
							System.exit(0);
						}
						
			}
			if(args[i].equals("Number_of_gears"))
			{
				try{
					
					if(args[i+1].equals("4")||args[i+1].equals("5")||args[i+1].equals("6")||args[i+1].equals("7")||args[i+1].equals("8")||args[i+1].equals("9")||args[i+1].equals("10"))
					{
						arg_type_bicycle_gears=args[i+1];
					}
					else
					{
						Exception e=new Exception("Invalid Bike Gear Type:Data does not exist in database ");
						throw e;
					}
				
				}
				catch(Exception e)
				{
					
					System.out.println("Unacceptable Gear Specification Error:Data does not exist in database");
					System.exit(0);
				}
						
			}
			if(args[i].equals("Wheel_Base"))
			{
					try{
					
					if(args[i+1].equals("36")||args[i+1].equals("42")||args[i+1].equals("48")||args[i+1].equals("54")||args[i+1].equals("60"))
					{
						arg_type_bicycle_wheels=(args[i+1]);
					}
					else
					{
						Exception e=new Exception("Invalid Bike Wheel type");
						throw e;
					}
				
				}
				catch(Exception e)
				{
					
					System.out.println("Invalid Bike Wheel Base Specification:Data does not exist in database");
					System.exit(0);
				}
						
			}
			if(args[i].equals("Height"))
			{
				try{
					
					if(args[i+1].equals("1")||args[i+1].equals("2")||args[i+1].equals("3")||args[i+1].equals("4"))
					{
						arg_type_bicycle_height=(args[i+1]);
					}
					else
					{
						Exception e=new Exception("Invalid bike height type");
						throw e;
					}
				
				}
				catch(Exception e)
				{
					
					System.out.println("Unacceptable Bike Height Specification Error:Data does not exist in database");
					System.exit(0);
				}
						
			}
			if(args[i].equals("Color"))
			{
try{
					
					if(args[i+1].equals("red")||args[i+1].equals("blue")||args[i+1].equals("steel")||args[i+1].equals("black"))
					{
						arg_type_bicycle_color=args[i+1];
						
					}
					else
					{
						Exception e=new Exception("Invalid bike color type");
						throw e;
					}
				
				}
				catch(Exception e)
				{
					
					System.out.println("Unacceptable Color Specification Error:Data does not exist in database");
					System.exit(0);
				}
						
			}
			if(args[i].equals("Construction_Material"))
			{
				try{
			
				if(args[i+1].equals("aluminium")||args[i+1].equals("steel")||args[i+1].equals("carbon"))
				{
					arg_type_bicycle_material=args[i+1];
					
				}
				else
				{
					Exception e=new Exception("Invalid bike material type");
					throw e;
				}
			
				}
			catch(Exception e)
			{
				
				System.out.println("Unacceptable Material Specification Error:Data does not exist in database");
				System.exit(0);
			}
						
			
		}
		}
		
		while((line=buffered_reader.readLine())!=null)
		{
		
			if(line.contains("Construction Material "+arg_type_bicycle_material)&&line.contains("Color "+arg_type_bicycle_color)&&line.contains("Type "+arg_type_bicycle_type)&&line.contains("Number Of Gears "+arg_type_bicycle_gears)&&line.contains("Height "+arg_type_bicycle_height)&&line.contains("Wheel Base "+arg_type_bicycle_wheels))
			{parts_of_line=line.split(Pattern.quote(" "));
			
			b.add(new Bicycle(parts_of_line[1], Integer.parseInt(parts_of_line[5]), Integer.parseInt(parts_of_line[8]),Integer.parseInt( parts_of_line[10]), parts_of_line[12], parts_of_line[15]));
			}
		
		}
		for(Bicycle temp:b)
		{
			Linked_List l=new Linked_List(temp);
			l.Insert();
			
			
		}
		buffered_reader.close();
		System.out.println("final sorted list:");
		Linked_List.PrintList();
	}
		catch(Exception a ){
			a.printStackTrace();
		}
	}
		

}

