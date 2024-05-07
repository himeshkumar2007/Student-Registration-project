package college_app;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class home extends JFrame {
	public void box()
	{
		setTitle("home page");
		getContentPane().setBackground(Color.pink);
		setSize(400, 400);
		setResizable(false);
		setLayout(null);
		setVisible(true);
		
	}
	home()
	{
	
		JLabel l=new JLabel("Login");
		l.setBounds(180, 50, 110, 50);
		l.setForeground(Color.red);
		l.setBackground(Color.black);
		add(l);
		
		JButton b1= new JButton("STUDENT");
		b1.setBounds(100, 100, 100, 50);
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Student_login.main(new String[] {});
				dispose();
				
			}
		});
		add(b1);
		
		JButton b2= new JButton("ADMIN");
		b2.setBounds(200, 100, 100, 50);
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				admin_login.main(new String[] {});
				dispose();
			}
		});
		add(b2);
		
		JLabel l1=new JLabel("Signup");
		l1.setBounds(180, 150, 110, 50);
		l1.setForeground(Color.red);
		l1.setBackground(Color.black);
		 
		add(l1);
		
		JButton b3= new JButton("STUDENT");
		b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				student_signup.main(new String[] {});
				dispose();
				
			}
		});
		b3.setBounds(100, 200, 100, 50);
		add(b3);
		
		JButton b4= new JButton("ADMIN");
		b4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				admin_signup.main(new String[] {});
				dispose();
				
			}
		});
		b4.setBounds(200, 200, 100, 50);
		add(b4);
		
		box();	
	}

	public static void main(String[] args) {
	new home();
	

	}
}
//to use this keyword in inheritance