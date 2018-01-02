package assignment3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PopTable {

public static void main(String[] args)  throws IOException, ClassNotFoundException, SQLException {
	BufferedReader reader = new BufferedReader(new FileReader(
			"C:/Users/Manku/Documents/Uncc Courses/IOT/Assignment3_1.txt"));

	
	String line = null;
	Scanner scanner = null;
	int index = 0;
	List<String> Input_from_file = new ArrayList<String>();

	while ((line = reader.readLine()) != null) {
	
	scanner = new Scanner(line);
		scanner.useDelimiter("\\|");
		while (scanner.hasNext()) {
			String data=scanner.next();
			Input_from_file.add(data);
			
		}
	
}
	for(int i=0;i<Input_from_file.size();i++)
	{
		System.out.println(i+" "+Input_from_file.get(i));
	}
	Class.forName("com.mysql.jdbc.Driver");
	
	Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/Feedback","root","pluto1234");


	String query="INSERT INTO Comments VALUES (?,?,?,?,?,?,?,?,?,?,default)";
	PreparedStatement preparedstmt=c.prepareStatement(query);
	int j=1;
	for(int i=10;i<Input_from_file.size()-10;i+=10)
	{
		

	preparedstmt.setString(1, Input_from_file.get(i));
	preparedstmt.setString(2, Input_from_file.get(i+1));
	preparedstmt.setString(3, Input_from_file.get(i+2));
	preparedstmt.setString(4, Input_from_file.get(i+3));
	preparedstmt.setString(5, Input_from_file.get(i+4));
	preparedstmt.setString(6, Input_from_file.get(i+5));
	preparedstmt.setString(7, Input_from_file.get(i+6));
	preparedstmt.setString(8, Input_from_file.get(i+7));
	preparedstmt.setString(9, Input_from_file.get(i+8));
	preparedstmt.setString(10, Input_from_file.get(i+9));
	preparedstmt.executeUpdate();
	j++;
	}
	c.close();

}
}
