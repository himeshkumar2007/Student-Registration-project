package college_app;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class student_signup extends JFrame {
	
	void frame()
	{
		setTitle("Student signup");
	    setSize(400, 400);
		setResizable(false);
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setVisible(true);
	}
	student_signup()
	{
		JButton back= new JButton("Back");
		back.setBounds(0, 0, 100, 40);
		 Font buttonFont = back.getFont();
	        back.setFont(new Font(buttonFont.getName(), Font.PLAIN, 16));
	        back.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				home.main(new String[] {});
				dispose();
				}
			});
		add(back);
		
		JLabel username= new JLabel("Username:");
		Font fusername=username.getFont();
		username.setFont(new Font(fusername.getName(), Font.PLAIN,18));
		username.setBounds(60, 70, 100, 30);
		add(username);
		
		JTextField Tusername= new JTextField();
		Tusername.setBounds(160, 70, 100, 30);
		add(Tusername);
		
		JLabel password= new JLabel("Password:");
		Font fpassword=password.getFont();
		password.setFont(new Font(fpassword.getName(), Font.PLAIN,18));
		password.setBounds(60, 120, 100, 30);
		add(password);
		
		JPasswordField pass= new JPasswordField();
		pass.setBounds(160, 120, 100, 30);
		add(pass);
		
		JLabel email = new JLabel("Email:");
		Font femail= email.getFont();
		email.setFont(new Font(femail.getName(),Font.PLAIN,18));
		email.setBounds(60, 170, 100, 30);
		add(email);
		
		JTextField Temail= new JTextField();
		Temail.setBounds(160, 170, 100, 30);
		add(Temail);
		

		JLabel name= new JLabel("name:");
		Font fname=name.getFont();
		name.setFont(new Font(fname.getName(), Font.PLAIN,18));
		name.setBounds(60, 220, 100, 30);
		add(name);
		
		JTextField Tname= new JTextField();
		Tname.setBounds(160, 220, 100, 30);
		add(Tname);
		
		JLabel phone= new JLabel("phone:");
		Font fphone=phone.getFont();
		phone.setFont(new Font(fphone.getName(), Font.PLAIN,18));
		phone.setBounds(60, 270, 100, 30);
		add(phone);
		
		JTextField Tphone= new JTextField();
		Tphone.setBounds(160, 270, 100, 30);
		add(Tphone);
		
		JButton signin= new JButton("Signin");
		signin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String username= Tusername.getText();
				String password=pass.getText();
				String email= Temail.getText();
				String name= Tname.getText();
				String phone=Tphone.getText();
				
				if(username.isEmpty()||password.isEmpty()||email.isEmpty()||name.isEmpty()||phone.isEmpty())
				{
					JOptionPane.showMessageDialog(student_signup.this, "please fill the entries");
				}
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/himesh1", "root", "");
					String query="insert into student(username,Name,email,PASSWORD,Phone_number) values(?,?,?,?,?)";
					PreparedStatement pst= con.prepareStatement(query);
					pst.setString(1,username);
					pst.setString(2,name);
					pst.setString(3,email);
					pst.setString(4,password);
					pst.setString(5,phone);
					int i= pst.executeUpdate();
					if(i==1)
					{
						JOptionPane.showMessageDialog(student_signup.this, "successfull");
						Student_login.main(new String[] {});
						dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(student_signup.this, "failed");
					}
					
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
				
			}
		});
		signin.setBounds(120,310,100,30);
		add(signin);
		
		
		frame();
		
	}
	public static void main(String[] args) {
		
		new student_signup();
	}

}
