package assignment3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SearchTable {

	public static void search_table() throws ClassNotFoundException, SQLException
	{
		Scanner s=new Scanner(System.in);
		System.out.println("How do you want to search?");
		System.out.println("Enter c for columnwise, r for rowwise and b for both");
		String how_to_search=s.next();
		Class.forName("com.mysql.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/Feedback","root","pluto1234");
		System.out.println(how_to_search);
		if(how_to_search.equals("c"))
		{
		System.out.println("Enter column number you want to search");
		int index=Integer.parseInt(s.next());
		Statement stmt=c.createStatement();
		ResultSet rs=stmt.executeQuery("select*from Comments");
		while(rs.next()){
			System.out.println(rs.getString(index));
				
		}
		}
		else if(how_to_search.equals("r"))
		{
			
			System.out.println("Enter row number you want to search");
			int index=Integer.parseInt(s.next());
			String query="select Date, What_excited_me,Job_Skills,Concepts_Learned,Questions_I_Asked,How_I_was_challenged,Research_I_have_to_do,What_I_would_like,Employer_discussions,Help_I_offered from Comments WHERE no=?;";
			PreparedStatement prepstmt=c.prepareStatement(query);
			prepstmt.setInt(1, index);
			ResultSet r=prepstmt.executeQuery();
			while(r.next()){
				System.out.println(r.getString(1)+" "+r.getString(2)+" "+r.getString(3)+" "+r.getString(4)+" "+r.getString(5)+" "+r.getString(6)+" "+r.getString(7)+" "+r.getString(8)+" "+r.getString(9)+" "+r.getString(10));
					
			}
		}
		else
		{
				System.out.println("Enter row number you want to search");
				int row=Integer.parseInt(s.next());
				System.out.println("Enter col number you want to search");
				int col=Integer.parseInt(s.next());
				String query="select Date, What_excited_me,Job_Skills,Concepts_Learned,Questions_I_Asked,How_I_was_challenged,Research_I_have_to_do,What_I_would_like,Employer_discussions,Help_I_offered from Comments WHERE no=?;";
				PreparedStatement prepstmt=c.prepareStatement(query);
				prepstmt.setInt(1, row);
				ResultSet r=prepstmt.executeQuery();
				while(r.next()){
					System.out.println(r.getString(col));
						
				}
		}
		c.close();
	
	}
}
