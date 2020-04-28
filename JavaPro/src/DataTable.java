import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame; 
import javax.swing.JScrollPane; 
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel; 
public class DataTable {
	
	JFrame f;
	JTable j;
	DefaultTableModel model;
	
	DataTable(){
		 f = new JFrame();
		 model = new DefaultTableModel(0,0);
		 j = new JTable(model);
		 
	        String[] columnNames = {  "passtypein","phone ","emailid ", "fullname ", "organization","gender", "age","adharid ","startd","end ", "purpose ","justify"  }; 
	        model.setColumnIdentifiers(columnNames);
		  
	        // Frame Title 
	        f.setTitle("E-pass Database"); 
	        
	        
	  
	        try {
//				
				Connection con = DBC.getConnection();
				System.out.println(con);
				Statement stmt=con.createStatement(); 
				
				
				ResultSet rs=stmt.executeQuery("select * from epassdata");

				
				
				while(rs.next())  
					{System.out.println(rs.getString(1)+" \n "+rs.getString(2)+" \n"+rs.getString(3)+" \n"+rs.getString(4)+" \n"+rs.getString(5)+" \n"+rs.getString(6)+" \n"+rs.getString(7)+" \n"+rs.getString(8)+" \n"+rs.getString(9)+" \n"+rs.getString(10)+" \n"+rs.getString(11)+"\n"+rs.getString(12)); 
				 	model.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12)});}
				con.close(); 
				System.out.println("===============================");
				
			}
			
			
			catch(Exception e1)
			{ 
				System.out.println(e1);
			} 

	  
	       
	        
	        j.setBounds(100, 100, 800, 800); 
	  
	        // adding it to JScrollPane 
	        JScrollPane sp = new JScrollPane(j); 
	        f.add(sp); 
	        // Frame Size 
	        f.setSize(800, 800); 
	        
	        // Frame Visible = true 
	        f.setVisible(true); 
//	        f.getDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	  
	}
	
	
	
	
	
}
