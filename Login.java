import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class Login extends JFrame implements ActionListener
{
	JFrame frame;
	JLabel l1,l2,l3;
	JTextField t1;
	JPasswordField p1;
	JButton b1,b2;
	ImageIcon img=new ImageIcon("h13.jpg");
	
	Login()
	{
		frame=new JFrame();
		l1=new JLabel("User Name");
		l2=new JLabel("Password");
        l3=new JLabel(img);
		t1=new JTextField();
		p1=new JPasswordField();
		b1=new JButton("Login");
		b2=new JButton("Cancel");
		frame.setBounds(150,150,600,400);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		l1.setBounds(40,20,100,30);
		frame.add(l1);
		l2.setBounds(40,70,100,30);
		frame.add(l2);
		t1.setBounds(150,20,150,30);
		frame.add(t1);
		p1.setBounds(150,70,150,30);
		frame.add(p1);
		b1.setBackground(Color.WHITE);
		b1.setForeground(Color.BLACK);
		b1.setBounds(40,150,120,30);
		b1.addActionListener(this);
		frame.add(b1);
		b2.setBackground(Color.WHITE);
		b2.setForeground(Color.BLACK);
		b2.setBounds(160,150,120,30);
		b2.addActionListener(this);
		frame.add(b2);
		l3.setBounds(350,30,200,200);
		frame.add(l3);
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			String username=t1.getText();
			String password=p1.getText();
			Conn c=new Conn();
			String str="select * from login where username = '"+username+"' and password = '"+password+"'";
			try
			{
				ResultSet rs=c.s.executeQuery(str);
				if(rs.next())
				{
					new Dashboard();
					this.frame.setVisible(false);
				}
				else{
					JOptionPane.showMessageDialog(null, "Invalid Username and Password");
					this.frame.setVisible(false);
				}
			} catch(Exception e)
				{
					
				}
				
		}
		else if(ae.getSource()==b2)
		{
			System.exit(0);
		}
	}
public static void main(String[] args)
{
	new Login();
}
}
	