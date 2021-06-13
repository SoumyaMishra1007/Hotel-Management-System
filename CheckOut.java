import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.awt.Font;

class CheckOut implements ActionListener
{
JFrame frame;
JLabel id,roomno,title;
JTextField troomno;
JButton checkout,check,back;
Choice c1;

 
 CheckOut()
 {
	 frame = new JFrame();
	 frame.setBounds(300,200,800,300);
	 
	 title=new JLabel("Check Out");
	 title.setBounds(40,20,150,30);
	 title.setFont(new Font("Arial",Font.PLAIN,20));
	 title.setForeground(Color.RED);
	 frame.add(title);
	 
	 
	 id=new JLabel("Coustomer id");
	 id.setBounds(40,60,130,30);
	 frame.add(id);
	 
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
	c1.setBounds(200,60,150,25);
	frame.add(c1);
	
	 roomno=new JLabel("Room Number");
	 roomno.setBounds(40,100,130,30);
	 frame.add(roomno);
	 
	 troomno=new JTextField();
	 troomno.setBounds(200,100,150,25);
	 frame.add(troomno);
	
	checkout=new JButton("CheckOut");
	checkout.setBounds(40,160,100,30);
	checkout.setForeground(Color.WHITE);
	checkout.setBackground(Color.BLACK);
    checkout.addActionListener(this);
	frame.add(checkout);
	
	check=new JButton("Check");
	check.setBounds(160,160,100,30);
	check.setForeground(Color.WHITE);
	check.setBackground(Color.BLACK);
    check.addActionListener(this);
	frame.add(check);
	
	back=new JButton("Back");
	back.setBounds(280,160,100,30);
	back.setForeground(Color.WHITE);
	back.setBackground(Color.BLACK);
    back.addActionListener(this);
	frame.add(back);
	
	frame.getContentPane().setBackground(Color.CYAN);
	frame.setLayout(null);
	frame.setVisible(true);
 }
 
 public void actionPerformed(ActionEvent ae)
 {
	 if(ae.getSource() == checkout)
	 {
		 String id = c1.getSelectedItem();
		 String room=troomno.getText();
		 Conn c=new Conn();
	String str = "delete from user where number='"+id+"'";
	String str2="update rooms set avilable='avilable' where room='"+room+"'";
	try{
		 c.s.executeUpdate(str);
         c.s.executeUpdate(str2);
		 JOptionPane.showMessageDialog(null,"CheckOut Done");
		 frame.setVisible(false);
		 new Reception();
		}catch(Exception e)
	{
		System.out.println(e);
	}
	
	 }
	else if(ae.getSource()==check)
		{
		try{
			Conn c = new Conn();
			String id = c1.getSelectedItem();
			String str= "select * from user where number = '"+id+"'";
			ResultSet rs = c.s.executeQuery(str);
			while(rs.next())
			{
				troomno.setText(rs.getString("roomno"));
			}
		}
			catch(Exception e)
	{
		System.out.println(e);
	}
		}
		
	 if (ae.getSource() == back)
	 {
		 new Reception();
		 frame.setVisible(false);
	 }
	 
 }
 
 public static void main(String[] args)
 {
	 new CheckOut();
 }
}