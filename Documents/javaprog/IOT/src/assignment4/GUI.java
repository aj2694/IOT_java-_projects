package assignment4;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class GUI extends JFrame {
	JButton btn1Submit,btn2Clear,btn3Createnew;
	JTextField txt1Tracking_number,txt2Service,txt3Weight,txt4Dimensions,txt5SigServices,txt6SpecialHandle,txt7Package,txt8Pieces,txt10source,txt11dest;
	JTextArea txt9Location;
	JScrollPane scbar;
	JLabel lbl1Tracking_number,lbl2Service,lbl3Weight,lbl4Dimensions,lbl5Sig_services,lbl6Special_handling,lbl7_package,lbl8pieces,lbl9location,lbl10source,lbl11dest;
	//JCheckBox chck1FE,chckSE,chckTE,chckBE;
	//JRadioButton radMale,radFemale;
	ButtonGroup group1Branch;
	Fetch_data f;
	Package p;
	String location_string;
	public GUI() {
		// TODO Auto-generated constructor stub
		instantiation();
		preparingGUI();
		addingHandlers();
		location_string="";
		
	}
	public void  instantiation(){

		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("FEDEX PACKAGE TRACKER");
		this.setLayout(new FlowLayout());
		btn1Submit=new JButton("Submit");
		btn2Clear=new JButton("Clear");
		btn3Createnew=new JButton("Create new package");
		lbl1Tracking_number=new JLabel("Tracking Number");
		txt1Tracking_number=new JTextField(10);
		lbl2Service=new JLabel("Service");
		txt2Service=new JTextField(10);
		lbl3Weight=new JLabel("Weight");
		txt3Weight=new JTextField(10);
		lbl4Dimensions=new JLabel("Dimensions");
		txt4Dimensions=new JTextField(10);
		lbl5Sig_services=new JLabel("Signature Services");
		txt5SigServices=new JTextField(10);
		lbl6Special_handling=new JLabel("Special handling required:");
		txt6SpecialHandle=new JTextField(10);
		lbl7_package=new JLabel("Package");
		txt7Package=new JTextField(10);
		lbl8pieces=new JLabel("Number of pieces");
		txt8Pieces=new JTextField("10");
		lbl9location=new JLabel("Location and Date Time");
		txt9Location=new JTextArea(25,25);
		lbl10source=new JLabel("Source");
		txt10source=new JTextField(10);
		lbl11dest=new JLabel("Destination");
		txt11dest=new JTextField(10);
		group1Branch= new ButtonGroup();
		scbar=new JScrollPane(txt9Location);
	
		this.setVisible(true);
		
	}
	public void preparingGUI(){
		this.add(lbl1Tracking_number);
		this.add(txt1Tracking_number);
		this.add(lbl2Service);
		this.add(txt2Service);
		this.add(lbl3Weight);
		this.add(txt3Weight);
		this.add(lbl4Dimensions);
		this.add(txt4Dimensions);
		this.add(lbl5Sig_services);
		this.add(txt5SigServices);
		this.add(lbl6Special_handling);
		this.add(txt6SpecialHandle);
		this.add(lbl7_package);
		this.add(txt7Package);
		this.add(lbl8pieces);
		this.add(txt8Pieces);
		this.add(lbl9location);
		this.add(scbar);
		this.add(txt9Location);
		
		this.add(lbl10source);
		this.add(txt10source);
		this.add(lbl11dest);
		this.add(txt11dest);
		
		this.add(btn1Submit);
		this.add(btn2Clear);
		this.add(btn3Createnew);
	}
	
	public void addingHandlers(){
		
		btn1Submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f=new Fetch_data(Integer.parseInt(txt1Tracking_number.getText()));
				f.run();
				txt2Service.setText(f.getTodisplay_Service());
				txt3Weight.setText(f.getTodisplay_Weight());
				txt4Dimensions.setText(f.getTodisplay_Dimensions());
				txt5SigServices.setText(f.getTodisplay_SigServices());
				txt6SpecialHandle.setText(f.getTodisplay_Special_handle());
				txt7Package.setText(f.getTodisplay_package());
				txt8Pieces.setText(f.getTodisplay_Numberofpieces());
			
				
			
				txt9Location.setText(f.getTodiplay_Location());
			
				
				
			}
		});
		btn2Clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txt1Tracking_number.setText("");
				txt2Service.setText("");
				txt3Weight.setText("");
				txt4Dimensions.setText("");
				txt5SigServices.setText("");
				txt6SpecialHandle.setText("");
				txt7Package.setText("");
				txt8Pieces.setText("");
				txt9Location.setText("");
				txt10source.setText("");
				txt11dest.setText("");
				
			}
		});
		btn3Createnew.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				p=new Package();
				p.setPackage_tracking_number(Integer.parseInt(txt1Tracking_number.getText()));
				p.setPackage_dimensions(txt4Dimensions.getText());
				p.setPackage_packaging(txt7Package.getText());
				p.setPackage_pieces(txt8Pieces.getText());
				p.setPackage_sig_services(txt5SigServices.getText());
				p.setPackage_special_handling(txt6SpecialHandle.getText());
				p.setPackage_weight(txt3Weight.getText());
				p.setPackage_service(txt2Service.getText());
				Simulation s=new Simulation("packnew", txt10source.getText(), txt11dest.getText(), p);
				s.start();
				
			}
		});
			

}
	public static void main(String[] args) {
	GUI f=new GUI();
	Package p1=new Package(1, "20", "req", "FEDEX", "none", "10x2x40", "3", "not req");
	Package p2=new Package(2, "34", "req", "FEDEX", "none", "45x32x56", "1", "not req");
	Package p3=new Package(3, "27", "req", "FEDEX", "none", "1x2x40", "1", "not req");
	Package p4=new Package(4, "209", "req", "FEDEX", "none", "10x2x50", "1", "not req");
	Package p5=new Package(5, "1", "req", "FEDEX", "none", "12x2x40", "1", "not req");
	
	Simulation s1=new Simulation("pack1", "Martinsburg, WV","Indianapolis, IN",p1);
	Simulation s2=new Simulation("pack2", "St. Louis, MO", "New Berlin, WI", p2);
	Simulation s3=new Simulation("pack3", "Atlanta, GA", "Sacramento, CA",p3);
	Simulation s4=new Simulation("pack4", "Phoenix, AZ", "Chino, CA",p4);
	Simulation s5=new Simulation("pack5", "St. Louis, MO", "Orlando, FL",p5);
	
	s1.start();
	s2.start();
	s3.start();
	s4.start();
	s5.start();

	
	
	
	}
}

