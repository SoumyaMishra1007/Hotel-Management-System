import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class UpdateCheck implements ActionListener
{
JFrame frame;
JLabel l1,l2,l3,l4,l5,l6,l7,l8;
JButton b1,b2;
JTextField t1,t2,t3,t4,t5;
Choice c1;


   UpdateCheck()
	{
	frame = new JFrame();	
	frame.setBounds(300,200,1050,500);
	
	l1 = new JLabel("Check-In Details");
	l1.setFont(new Font("Arial",Font.PLAIN,20));
	l1.setForeground(Color.RED);
	l1.setBounds(80,30,200,30);
	frame.add(l1);
	
    l2 = new JLabel("Customer-ID");
	l2.setBounds(30,80,100,20);
	frame.add(l2);
	
	c1=new Choice();
	try
	{
		Conn c = new Conn();
		ResultSet rs=c.s.executeQuery("select * from user");
		while(rs.next())
		{
			c1.add(rs.getString("number"));
		}
	}catch(Exception e){}
	
	c1.setBounds(200,80,150,25);
	frame.add(c1);
	
	l3 = new JLabel("Room Number");
	l3.setBounds(30,120,100,20);
	frame.add(l3);
	
	t1 = new JTextField();
	t1.setBounds(200,120,150,25);
	frame.add(t1);
	
	l4 = new JLabel("Name");
	l4.setBounds(30,160,100,20);
	frame.add(l4);
	
	t2 = new JTextField();
	t2.setBounds(200,160,150,25);
	frame.add(t2);
	
    l5 = new JLabel("Check-In");
	l5.setBounds(30,200,100,20);
	frame.add(l5);
	
	t3 = new JTextField();
	t3.setBounds(200,200,150,25);
	frame.add(t3);
	
	l6 = new JLabel("Amount Paid");
	l6.setBounds(30,240,100,20);
	frame.add(l6);
	
	t4 = new JTextField();
	t4.setBounds(200,240,150,25);
	frame.add(t4);
	
	l7 = new JLabel("Pending Amount");
	l7.setBounds(30,280,100,20);
	frame.add(l7);
	
	t5 = new JTextField();
	t5.setBounds(200,280,150,25);
	frame.add(t5);
	
	b1 = new JButton("Check");
	b1.setForeground(Color.WHITE);
	b1.setBackground(Color.BLACK);
	b1.setBounds(30,340,100,30);
	b1.addActionListener(this);
	frame.add(b1);


	b2 = new JButton("Back");
	b2.setBounds(270,340,100,30);
	b2.setForeground(Color.WHITE);
	b2.setBackground(Color.BLACK);
	b2.addActionListener(this);
	frame.add(b2);
	
	ImageIcon i1 = new ImageIcon("h22.jpg");
	l8 = new JLabel(i1);
	l8.setBounds(400,50,600,334);
	frame.add(l8);

	frame.getContentPane().setBackground(Color.CYAN);
	frame.setLayout(null);
	frame.setVisible(true);
	
	}
	
	public void actionPerformed(ActionEvent ae)
	{
	if(ae.getSource()==b1)
		{
		try{
			int n=0;
			int n1=0;
			int n2=0;
			String room = null;
			String deposit = null;
			String amountPaid = null;
			String price = null;
			Conn c = new Conn();
			String id = c1.getSelectedItem();
			String str= "select * from user where number = '"+id+"'";
			ResultSet rs = c.s.executeQuery(str);
			while(rs.next())
			{
				t1.setText(rs.getString("roomno"));
				t2.setText(rs.getString("name"));
				t3.setText(rs.getString("checkedin"));
				t4.setText(rs.getString("deposit"));
				room = rs.getString("roomno");
				deposit = rs.getString("deposit");
			}
			ResultSet rs2 = c.s.executeQuery("select * from rooms where room ='"+room+"'");
			while(rs2.next())
			{
				price = rs2.getString("price");
				n=Integer.parseInt(price);
				n1=Integer.parseInt(deposit);
				n2=n-n1;
				System.out.println(n2);
				amountPaid=Integer.toString(n2);
				t5.setText(Integer.toString(n2));
			}	
			}catch (Exception e){}
		}

	else if(ae.getSource()==b2)
		{
		new Reception();
		frame.setVisible(false);
		}
	}	
	
	public static void main(String args[])
	{
		new UpdateCheck();
	}
}	