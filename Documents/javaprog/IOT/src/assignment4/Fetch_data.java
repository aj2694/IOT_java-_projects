package assignment4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Fetch_data implements Runnable{
	Thread t;
	int trackno;
	String todisplay_Service;
	String todisplay_Weight;
	String todisplay_Dimensions;
	String todisplay_SigServices;
	String todisplay_Special_handle;
	String todisplay_package;
	String todisplay_Numberofpieces;
	String todiplay_Location;
	String todisplay_Time;
	String todisplay_source;
	String todisplay_dest;
	public String getTodisplay_source() {
		return todisplay_source;
	}

	public void setTodisplay_source(String todisplay_source) {
		this.todisplay_source = todisplay_source;
	}

	public String getTodisplay_dest() {
		return todisplay_dest;
	}

	public void setTodisplay_dest(String todisplay_dest) {
		this.todisplay_dest = todisplay_dest;
	}

	public String getTodisplay_Time() {
		return todisplay_Time;
	}

	public void setTodisplay_Time(String todisplay_Time) {
		this.todisplay_Time = todisplay_Time;
	}

	public String getTodiplay_Location() {
		return todiplay_Location;
	}

	public void setTodiplay_Location(String todiplay_Location) {
		this.todiplay_Location = todiplay_Location;
	}

	public String getTodisplay_Service() {
		return todisplay_Service;
	}

	public void setTodisplay_Service(String todisplay_Service) {
		this.todisplay_Service = todisplay_Service;
	}

	public String getTodisplay_Weight() {
		return todisplay_Weight;
	}

	public void setTodisplay_Weight(String todisplay_Weight) {
		this.todisplay_Weight = todisplay_Weight;
	}

	public String getTodisplay_Dimensions() {
		return todisplay_Dimensions;
	}

	public void setTodisplay_Dimensions(String todisplay_Dimensions) {
		this.todisplay_Dimensions = todisplay_Dimensions;
	}

	public String getTodisplay_SigServices() {
		return todisplay_SigServices;
	}

	public void setTodisplay_SigServices(String todisplay_SigServices) {
		this.todisplay_SigServices = todisplay_SigServices;
	}

	public String getTodisplay_Special_handle() {
		return todisplay_Special_handle;
	}

	public void setTodisplay_Special_handle(String todisplay_Special_handle) {
		this.todisplay_Special_handle = todisplay_Special_handle;
	}

	public String getTodisplay_package() {
		return todisplay_package;
	}

	public void setTodisplay_package(String todisplay_package) {
		this.todisplay_package = todisplay_package;
	}

	public String getTodisplay_Numberofpieces() {
		return todisplay_Numberofpieces;
	}

	public void setTodisplay_Numberofpieces(String todisplay_Numberofpieces) {
		this.todisplay_Numberofpieces = todisplay_Numberofpieces;
	}

	public Fetch_data(int trackno) {
		// TODO Auto-generated constructor stub
		t=new Thread("new");
		this.trackno=trackno;
		t.start();
		
	}

	@Override
	public void run() {
		System.out.println("here");
	//	int track;
//		Scanner s=new Scanner(System.in);
	//	System.out.println("Enter tracking number");
		//track=Integer.parseInt(s.nextLine());
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/fedex","root","pluto1234");
		
		
		String query="SELECT * FROM packagetable where package_tracking_number=?";
		PreparedStatement preparedstmt=c.prepareStatement(query);
		
		preparedstmt.setInt(1, trackno);
		ResultSet rs=preparedstmt.executeQuery();
		while(rs.next())
		{
		//	System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7)+" "+rs.getString(8)+" "+rs.getString(9));
			setTodisplay_Dimensions(rs.getString(3));
			setTodisplay_Numberofpieces(rs.getString(5));
			setTodisplay_package(rs.getString(6));
			setTodisplay_Service(rs.getString(7));
			setTodisplay_SigServices(rs.getString(4));
			setTodisplay_Special_handle(rs.getString(8));
			setTodisplay_Weight(rs.getString(2));
			setTodiplay_Location(rs.getString(10));
			setTodisplay_Time(rs.getString(11));
			
			
		}
		System.out.println("here in fetch");
		String query1="SELECT curr_location, package_date_time from packagetable where package_tracking_number=?";
		PreparedStatement preparedstmt1=c.prepareStatement(query1);
		
		preparedstmt1.setInt(1,trackno);
		ResultSet rs1=preparedstmt1.executeQuery();
		String result="";
		while(rs1.next())
		{
			
			result+=rs1.getString(1)+" "+rs1.getString(2)+System.lineSeparator();
					
		}
		setTodiplay_Location(result);
		
	c.close();
} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
}