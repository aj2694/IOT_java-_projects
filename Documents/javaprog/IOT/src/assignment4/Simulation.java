package assignment4;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Simulation  extends Package implements Runnable{
	
	private Thread t;
	private String threadName;
	   private Package p;
	   private String source;
	   private String dest;
	   private CalculatePath cal;
	   public Simulation( String name,String source,String dest, Package pack) {
	      threadName = name;
	      System.out.println("Creating " +  threadName);
	      p=pack;
	      cal=new CalculatePath();
	      this.source=source;
	      this.dest=dest;
	   }
	   
	   public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDest() {
		return dest;
	}

	public void setDest(String dest) {
		this.dest = dest;
	}

	public void run() {
	      System.out.println("Running " +  threadName );
	  	try {
	  		Class.forName("com.mysql.jdbc.Driver");
			
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/fedex","root","pluto1234");
				      
	    	  
					p.create_new_package(source);
					cal.testExcute(source,dest);
					
					 for (Vertex vertex :cal.getpath()) {
						 
						 java.util.Date d=new java.util.Date();
							DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
							Date date = new Date();
							String date_time=dateFormat.format(date); //2016
							      
						 String query="INSERT INTO packagetable VALUES (?,?,?,?,?,?,?,?,default,?,?)";
							PreparedStatement preparedstmt=c.prepareStatement(query);
							
							preparedstmt.setInt(1, p.package_tracking_number);
							preparedstmt.setString(2, p.package_weight);
							preparedstmt.setString(3,p.package_dimensions);
							preparedstmt.setString(4,p.package_sig_services );
							preparedstmt.setString(5,p.package_pieces);
							preparedstmt.setString(6,p.package_packaging);
							preparedstmt.setString(7,p.package_service);
							preparedstmt.setString(8,p.package_special_handling);
							preparedstmt.setString(9,vertex.toString());
							preparedstmt.setString(10,date_time);
							preparedstmt.executeUpdate();
							System.out.println("update");
							
				            Thread.sleep(10000);
				            
				        }c.close();
				} catch (NumberFormatException | ClassNotFoundException | IOException | SQLException | InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	  

	      
	      System.out.println("Thread " +  threadName + " exiting.");
	   }
	   
	   public void start () {
	      System.out.println("Starting " +  threadName );
	      if (t == null) {
	         t = new Thread (this, threadName);
	         t.start ();
	      }
	   }

	

}
