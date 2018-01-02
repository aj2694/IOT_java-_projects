package assignment3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertRow {

	public static void row_insert() throws ClassNotFoundException, SQLException, IOException{
		String date="", what_excited_me="", job_skills_gathered="",concepts_learned="",questions_I_asked="",how_I_was_challeged="",research_I_have_to_do="",what_I_would_like="",emp_discussions="",help_offered="";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		
		Scanner s=new Scanner(System.in);
		System.out.println("Enter Date");
		date=br.readLine();
		System.out.println("Enter what excited you");
		what_excited_me=br.readLine();
		System.out.println("Enter job skills learned");
		job_skills_gathered=br.readLine();
		System.out.println("Enter Questions asked");
		questions_I_asked=br.readLine();
		System.out.println("Enter How I was challenged");
		how_I_was_challeged=br.readLine();
		System.out.println("Research I have to do");
		research_I_have_to_do=br.readLine();
		System.out.println("Enter what you would like");
		what_I_would_like=br.readLine();
		System.out.println("Enter employer diacussions");
		emp_discussions=br.readLine();
		System.out.println("Help I offered");
		help_offered=br.readLine();
		
		
		
		Class.forName("com.mysql.jdbc.Driver");
	
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/Feedback","root","pluto1234");
		String query="INSERT INTO Comments VALUES (?,?,?,?,?,?,?,?,?,?,default)";
		PreparedStatement preparedstmt=c.prepareStatement(query);
		
		preparedstmt.setString(1, date);
		preparedstmt.setString(2, what_excited_me);
		preparedstmt.setString(3,job_skills_gathered);
		preparedstmt.setString(4,concepts_learned );
		preparedstmt.setString(5,questions_I_asked);
		preparedstmt.setString(6,how_I_was_challeged);
		preparedstmt.setString(7,research_I_have_to_do );
		preparedstmt.setString(8,what_I_would_like );
		preparedstmt.setString(9,emp_discussions );
		preparedstmt.setString(10, help_offered);
		
		preparedstmt.executeUpdate();

		
		
		c.close();
}
}
