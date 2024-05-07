package college_app;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



public class mainpage extends JFrame {
	
	public void box()
	{
		setResizable(false);
		setSize(400,400);
		setVisible(true);
		setLayout(null);
	}

	mainpage()
	{
		       
		        String[] columns = {"Name", "email" , "Phone_number"};
		        DefaultTableModel model = new DefaultTableModel(columns, 0);
		        JTable table = new JTable(model);
		        
		        JScrollPane scrollPane = new JScrollPane(table);
		        add(scrollPane, BorderLayout.CENTER);
		        
		        try 
		        {
		            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/himesh1","root","");
		            Statement stmt = con.createStatement();
		           // String query="select * from student";
		            ResultSet resultset = stmt.executeQuery("select * from student");

		            while (resultset.next()) {
		                String name = resultset.getString("name");
		                String email =resultset.getString("email");
		               String Phone_number = resultset.getString("Phone_number");

		                // Add data to the table model
		                model.addRow(new Object[]{name,email,Phone_number});
		            }
		        } 
		        
		        
		        
		        catch (Exception e) 
		        {
		            e.printStackTrace();
		        }
		        
		        JButton delete  = new JButton("delete");
		      delete.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					
				}
			});
		        add(delete,BorderLayout.SOUTH);
		        
		     box();
		    }
		

	

	public static void main(String[] args) {
		new mainpage();
		

	}

}
 // Connection con = DriverManager.getconnection("jdbc:mysql://Localhost:3306/himesh1","root","");