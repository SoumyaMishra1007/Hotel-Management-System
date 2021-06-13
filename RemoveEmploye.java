import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.awt.Font;

class RemoveEmploye implements ActionListener
{
JFrame frame;
JLabel id,title;
JButton remove,back;
Choice c1;
 
 RemoveEmploye()
 {
	 frame = new JFrame();
	 frame.setBounds(300,200,600,300);
	 
	 title=new JLabel("Remove Employe");
	 title.setBounds(40,20,200,30);
	 title.setFont(new Font("Arial",Font.PLAIN,20));
	 title.setForeground(Color.RED);
	 frame.add(title);
	 
	
	 
	 id=new JLabel("Employe id");
	 id.setBounds(40,60,130,30);
	 frame.add(id);
	 
	 c1=new Choice();
	try
	{
		Conn c = new Conn();
		ResultSet rs=c.s.executeQuery("select * from employe");
		while(rs.next())
		{
			c1.add(rs.getString("id"));
		}
	}catch(Exception e){}
	c1.setBounds(200,60,150,25);
	frame.add(c1);
	
	
	remove=new JButton("Remove");
	remove.setBounds(40,160,100,30);
	remove.setForeground(Color.WHITE);
	remove.setBackground(Color.BLACK);
    remove.addActionListener(this);
	frame.add(remove);
	
	back=new JButton("Back");
	back.setBounds(160,160,100,30);
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
	 if(ae.getSource() == remove)
	 {
		 String id = c1.getSelectedItem();
		 Conn c=new Conn();
	String str = "delete from employe where id='"+id+"'";
	try{
		 c.s.executeUpdate(str);
		 JOptionPane.showMessageDialog(null,"Employe Removed");
		 frame.setVisible(false);
		 new Reception();
		}catch(Exception e)
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
	 new RemoveEmploye();
 }
}