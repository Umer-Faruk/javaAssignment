import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;



//import com.sun.media.sound.Toolkit;

//phone,emailid,fullname,orga,gendar,age,id,startdate,enddate.purpose,justification

public class Mainhome {
	
	
public static void main(String args[]) {
	
		
		JFrame fr = new JFrame("Essential Pass");
		
		
		
		
		 
	         
		DefaultTableModel model = new DefaultTableModel(new String[]{"passtypein","phone ","emailid ", "fullname ", "organization","gender", "age","adharid ","startd","end ", "purpose ","justify"  }, 0);
		 JTable T = new JTable();
		JLabel titlel = new JLabel("Essential Services Form");
		titlel.setBounds(300,30,300,50);

		JLabel passtypel = new JLabel("Pass Type");
		passtypel.setBounds(50,100,100,40);
		  String ptype[]={"individual","group"};        
		   JComboBox passtypein =new JComboBox(ptype);
		   passtypein.setBounds(150,100,100,40);  
		   
		JLabel phonel = new JLabel("Phone No");
		phonel.setBounds(50,150,200,40);
		JTextField phonein = new JTextField();
		phonein.setBounds(150,150,100,40);

		JLabel emailidl = new JLabel("Email Id");
		emailidl.setBounds(50,200,100,40);
		JTextField emailidin = new JTextField();
		emailidin.setBounds(150,200,300, 40);

		JLabel fullnamel = new JLabel("Full Name");
		fullnamel.setBounds(50,250,100,40);
		JTextField fullnamein = new JTextField();
		fullnamein.setBounds(150,250,300, 40);

		JLabel organizationl = new JLabel("Organization");
		organizationl.setBounds(50,300,100,40);
		JTextField organizationin = new JTextField();
		organizationin.setBounds(150,300,250, 40);

		JLabel genderl = new JLabel("Gender");
		genderl.setBounds(50, 350, 100, 40);
		  String gtype[]={"Male","Female"};        
		   JComboBox genderin =new JComboBox(gtype);
		   genderin.setBounds(150,350,150,40);

		JLabel agel = new JLabel("Age");
		agel.setBounds(50,400,100,40);
		JTextField agein = new JTextField();
		agein.setBounds(150,400,70, 40);

		JLabel adharidl = new JLabel("Adhaar Id");
		adharidl.setBounds(50,450,100,40);
		JTextField adharidin = new JTextField();
		adharidin.setBounds(150,450,200, 40);
///##################################################33
		JLabel startdl = new JLabel("Start Date");
		startdl.setBounds(500,100,100,40);
		JTextField startdin = new JTextField();
		startdin.setBounds(580,100,200, 40);
		
		

		JLabel endl = new JLabel("End Date");
		endl.setBounds(500,150,100,40);
		JTextField endin = new JTextField();
		endin.setBounds(580,150,200,40);

		JLabel purposel = new JLabel("Purpose");
		purposel.setBounds(500,200,100,40);
		  String putype[]={"Essential Service","Medical Pass","Emergency Pass"};        
		   JComboBox purposein =new JComboBox(putype);
		   purposein.setBounds(580,200,200,40);

		JLabel justifyl = new JLabel("Justify");
		justifyl.setBounds(500,250,100,100);
		JTextField justifyin = new JTextField();
		justifyin.setBounds(580,250,300,100);
					
		JButton b1 = new JButton("Add");
		b1.setBounds(300, 550, 100, 40);
		
		JButton b2 = new JButton("show");
		b2.setBounds(200, 550, 100, 40);
		
		
		
		
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			
						new DataTable();
						
		

		 }
			
		});
			
		
		b1.addActionListener(new ActionListener() {
			
			
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				String passtype = passtypein.getSelectedItem().toString();
				String phone = phonein.getText();
				String emailid = emailidin.getText();
				String fullname = fullnamein.getText();
				String organization =organizationin.getText();
				String gender = genderin.getSelectedItem().toString();
				String age =agein.getText();
				String adharid = adharidin.getText();
				String startd = startdin.getText();
				String end = endin.getText();
				String purpose =purposein.getSelectedItem().toString();
				String justify = justifyin.getText();
				

				 if (passtype.hashCode() == 0 || phone.hashCode() == 0 || emailid.hashCode() == 0 || fullname.hashCode() == 0 || organization.hashCode() == 0 || gender.hashCode() == 0||age.hashCode() == 0|| adharid.hashCode() == 0 
						 || startd.hashCode() == 0 || end.hashCode() ==0 ||purpose.hashCode() == 0 || justify.hashCode() == 0)
				    {
				        JOptionPane.showMessageDialog(null, "Some fields are empty!");
				    }
				 else {
				
				try {
//					
					Connection con = DBC.getConnection();
					System.out.println(con);
					Statement stmt=con.createStatement(); 
					
					
					String sql = "INSERT INTO epassdata values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
					java.sql.PreparedStatement statement = con.prepareStatement(sql);
					statement.setString(1, passtype);
					statement.setString(2,phone );
					statement.setString(3, emailid);
					statement.setString(4,fullname );
					
					statement.setString(5, organization);
					statement.setString(6,gender );
					statement.setString(7, age);
					statement.setString(8,adharid );
					statement.setString(9,startd );
					statement.setString(10, end);
					statement.setString(11,purpose );
					statement.setString(12, justify);
					

					
					
					statement.executeUpdate();
					JOptionPane.showMessageDialog(null, "Data update successfully !");
					cliar();
//					
					
					
					}
					catch(Exception e1)
					{ 
						System.out.println(e1);
						
					}  
					
				
			}
			}

			private void cliar() {
				// TODO Auto-generated method stub
//				passtypein.setText("This is a text");
				  phonein.setText(null);
				 emailidin.setText(null);
				 fullnamein.setText(null);
				 organizationin.setText(null);
//				 genderin.getSelectedItem().toString();
				 agein.setText(null);
				 adharidin.setText(null);
				 startdin.setText(null);
				 endin.setText(null);
//				 purposein.setText(null);
				 justifyin.setText(null);
				
			}
		});
		
		
//		  T.setBounds(5, 5, 800, 800); 
//		  
//	        // adding it to JScrollPane 
//	        JScrollPane sp = new JScrollPane(T); 
//	        fr.add(sp);
//	        fr.add(T);
		fr.add(titlel);
		fr.add(passtypel);
		fr.add(b1);
		fr.add(b2);
		fr.add(passtypein);
		fr.add(phonel);
		fr.add(phonein);
		fr.add(emailidl);
		fr.add(emailidin);
		fr.add(fullnamel);
		fr.add(fullnamein);
		fr.add(organizationl);
		fr.add(organizationin);
		fr.add(genderl);
		fr.add(genderin);
		fr.add(agel);
		fr.add(agein);
		fr.add(adharidl);
		fr.add(adharidin);
		fr.add(startdl);
		fr.add(startdin);
		fr.add(endl);
		fr.add(endin);
		fr.add(purposel);
		fr.add(purposein);
		fr.add(justifyl);
		fr.add(justifyin);

//		
		fr.setSize(800,800);  
		fr.setLayout(new BorderLayout());  
		fr.setVisible(true);  
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}




}