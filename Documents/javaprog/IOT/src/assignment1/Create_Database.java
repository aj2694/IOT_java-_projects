package assignment1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Create_Database {
	public static void main(String[] args) throws IOException {
		String[] Type ={"mountain_bike","race_bike","street_bike"};
		int[] Number_Of_Gears={4,5,6,7,8,9,10};
		int[] Wheel_Base={36,42,48,54,60};
		int[] Height= {1, 2, 3, 4};
		String[] Color={"steel","red","blue","black"};
		String[] Construction_Material={"carbon","steel","aluminium"};
		FileWriter writer=new FileWriter("database.txt");
		BufferedWriter buffered_writer=new BufferedWriter(writer);
		for(String a:Type)
		{
			for(int num:Number_Of_Gears)
			{
				for(int wheels:Wheel_Base)
				{
					for(int h:Height)
					{
						for(String col:Color)
						{
							for(String mat:Construction_Material)
							{
								buffered_writer.write("Type "+a+" "+"Number Of Gears "+num+" "+"Wheel Base "+wheels+" "+"Height "+h+" "+"Color "+col+" "+"Construction Material "+mat);
								buffered_writer.newLine();
							}
						}
					}
				}
			}
		}
		buffered_writer.close();
		
	}
}
