package college_app;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.protocol.Resultset;


public class admin_login extends JFrame {
     public void box()
     {
    	 setTitle("Student login");
    	 setSize(400,400);
    	 setLayout(null);
    	 setVisible(true);
    	 setResizable(false);
     }
	admin_login()
	{

		JButton back= new JButton("Back");
		back.setBounds(0, 0, 100, 40);
		 Font backFont = back.getFont();
	        back.setFont(new Font(backFont.getName(), Font.PLAIN, 16));
	        back.addActionListener(new ActionListener() {
				
			
				public void actionPerformed(ActionEvent e) {
				home.main(new String[] {});
				dispose();
					
				}
			});
		add(back);
		
		JLabel uname= new JLabel("Username:");
		uname.setBounds(100, 100, 150, 30);
		Font buttonFont = uname.getFont();
        uname.setFont(new Font(buttonFont.getName(), Font.PLAIN, 16));
		add(uname);
		
		JTextField tname= new JTextField();
		tname.setBounds(200,100,150,30);
		add(tname);
		
		
		JLabel Lpassword= new JLabel("Password:");
		Lpassword.setBounds(100, 150, 150, 30);
		Font passwordFont = Lpassword.getFont();
		Lpassword.setFont(new Font(passwordFont.getName(), Font.PLAIN, 16));
        add(Lpassword);
        
		JPasswordField Password= new JPasswordField();
		Password.setBounds(200, 150, 150, 30);
		add(Password);
		
		JButton login = new JButton("login");
		login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String name=tname.getText();
				String pass= Password.getText();
				if(name.isBlank()||pass.isEmpty())
				{
					JOptionPane.showMessageDialog(admin_login.this, "login fail");
				}
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/himesh1","root","");
					String query= "select * from student where username=? and PASSWORD=?";
					PreparedStatement pst = con.prepareStatement(query);
					pst.setString(1,name );
					pst.setString(2,pass);
				ResultSet resultSet= pst.executeQuery();	
				if(resultSet.next())
				{
					JOptionPane.showMessageDialog(admin_login.this, "login successfull");
					mainpage.main(new String[] {});
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(admin_login.this, "username or password wrong or you need to register");

				}
				 }
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
				
				
			
			}
		});
		login.setBounds(150, 250, 80, 30);
		add(login);
		
		box();
	}
	public static void main(String[] args) {
		new admin_login();

	}
     
}

