package assignment3;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public  class DeleteRow {
	public static void row_del() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		Scanner s=new Scanner(System.in);
		System.out.println("Enter date of the row you want to delete");
		String date=s.nextLine();
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/Feedback","root","pluto1234");
		String query="DELETE FROM Comments WHERE Date=?;";
		PreparedStatement stmt=c.prepareStatement(query);
		 
		stmt.setString(1, date);
		stmt.execute();
		c.close();
}
}