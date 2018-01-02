package assignment3;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class Test_my_feedback {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		int val,i=1;
		Scanner s=new Scanner(System.in);
		System.out.println("The table has been populated");
		System.out.println("If you want to insert a new row enter 1, to delete an existing row enter 2 and to search the table enter 3");
		val=s.nextInt();
		while(i==1)
			try {
				{
					i=0;
				switch(val)
				{
				case 1:
					InsertRow.row_insert();
					break;
					
				case 2:
					DeleteRow.row_del();
					break;
				case 3:
					SearchTable.search_table();
					break;
				
				}
				System.out.println("Do you wish to continue?");
				i=s.nextInt();
				if(i==1)
				{
					System.out.println("If you want to insert a new row enter 1, to delete an existing row enter 2 and to search the table enter 3");
					val=s.nextInt();
				}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	

}
}
