package assignment4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Package {

	int package_tracking_number;
	String package_weight;
	String package_sig_services;
	String package_packaging;
	String package_service;
	String package_dimensions;
	String package_pieces;
	String package_special_handling;
	String package_date_time;
	public String getPackage_date_time() {
		return package_date_time;
	}
	public void setPackage_date_time(String package_date_time) {
		this.package_date_time = package_date_time;
	}
	public Package() {
		// TODO Auto-generated constructor stub
	}
	public Package(int package_tracking_number, String package_weight, String package_sig_services,
			String package_packaging, String package_service, String package_dimensions, String package_pieces,
			String package_special_handling) {
		super();
		
	
		this.package_tracking_number = package_tracking_number;
		this.package_weight = package_weight;
		this.package_sig_services = package_sig_services;
		this.package_packaging = package_packaging;
		this.package_service = package_service;
		this.package_dimensions = package_dimensions;
		this.package_pieces = package_pieces;
		this.package_special_handling = package_special_handling;
		
	}
	public int getPackage_tracking_number() {
		return package_tracking_number;
	}
	public void setPackage_tracking_number(int package_tracking_number) {
		this.package_tracking_number = package_tracking_number;
	}
	public String getPackage_weight() {
		return package_weight;
	}
	public void setPackage_weight(String package_weight) {
		this.package_weight = package_weight;
	}
	public String getPackage_sig_services() {
		return package_sig_services;
	}
	public void setPackage_sig_services(String package_sig_services) {
		this.package_sig_services = package_sig_services;
	}
	public String getPackage_packaging() {
		return package_packaging;
	}
	public void setPackage_packaging(String package_packaging) {
		this.package_packaging = package_packaging;
	}
	public String getPackage_service() {
		return package_service;
	}
	public void setPackage_service(String package_service) {
		this.package_service = package_service;
	}
	public String getPackage_dimensions() {
		return package_dimensions;
	}
	public void setPackage_dimensions(String package_dimensions) {
		this.package_dimensions = package_dimensions;
	}
	public String getPackage_pieces() {
		return package_pieces;
	}
	public void setPackage_pieces(String package_pieces) {
		this.package_pieces = package_pieces;
	}
	public String getPackage_special_handling() {
		return package_special_handling;
	}
	public void setPackage_special_handling(String package_special_handling) {
		this.package_special_handling = package_special_handling;
	}
	public void create_new_package(String source) throws NumberFormatException, IOException, ClassNotFoundException, SQLException
	{
		java.util.Date d=new java.util.Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String date_time=dateFormat.format(date); //2016/11/16 12:08:43
	/*	System.out.println("Enter the package details");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Package number:");
		this.package_tracking_number=Integer.parseInt(br.readLine());
		System.out.println("Package weight:");
		this.package_weight=(br.readLine());
		System.out.println("Package dimensions:");
		this.package_dimensions=br.readLine();
		System.out.println("Package signature services:");
		this.package_sig_services=br.readLine();
		System.out.println("Package number of pieces:");
		this.package_pieces=br.readLine();
		System.out.println("Package special handling:");
		this.package_special_handling=br.readLine();
		System.out.println("Package packaging details:");
		this.package_packaging=br.readLine();
		System.out.println("Package service details:");
		this.package_service=br.readLine();
		*/
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/fedex","root","pluto1234");
		String query="INSERT INTO packagetable VALUES (?,?,?,?,?,?,?,?,default,?,?)";
		PreparedStatement preparedstmt=c.prepareStatement(query);
		
		preparedstmt.setInt(1, this.package_tracking_number);
		preparedstmt.setString(2, this.package_weight);
		preparedstmt.setString(3,this.package_dimensions);
		preparedstmt.setString(4,this.package_sig_services );
		preparedstmt.setString(5,this.package_pieces);
		preparedstmt.setString(6,this.package_packaging);
		preparedstmt.setString(7,this.package_service);
		preparedstmt.setString(8,this.package_special_handling);
		preparedstmt.setString(9,source);
		preparedstmt.setString(10, date_time);
		
		preparedstmt.executeUpdate();

		
		
		c.close();
		
	}
	
}
