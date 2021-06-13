import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class AddRoom implements ActionListener
{
	
	JFrame frame;
	JLabel l1,room,avilable,status,price,type,l2;
	JTextField t1,t2;
	JComboBox c1,c2,c3;
	JButton b1,b2;
	ImageIcon img=new ImageIcon("h16.jpg");
	AddRoom()
	{
		frame=new JFrame();
		frame.setBounds(280,180,1000,500);
		
		l1=new JLabel("Add Rooms");
		l1.setBounds(200,20,100,20);
		l1.setFont(new Font("serif",Font.BOLD,19));
		frame.add(l1);
		
		room=new JLabel("Room Number");
		room.setBounds(60,80,120,30);
		room.setFont(new Font("serif",Font.PLAIN,16));
		frame.add(room);
		
		t1=new JTextField();
		t1.setBounds(200,83,150,25);
		frame.add(t1);
		
		avilable=new JLabel("Avilable");
		avilable.setBounds(60,130,120,30);
		avilable.setFont(new Font("serif",Font.PLAIN,16));
		frame.add(avilable);
		
		c1=new JComboBox(new String[] {"Avilable","Ocupied"});
		c1.setBounds(200,130,150,30);
		frame.add(c1);
		
		status=new JLabel("Cleaning Status");
		status.setBounds(60,180,130,20);
		status.setFont(new Font("serif",Font.PLAIN,16));
		frame.add(status);
		
		c2=new JComboBox(new String[] {"Cleaned","Not Cleaned"});
		c2.setBounds(200,180,150,30);
		frame.add(c2);
		
		price=new JLabel("Room Price");
		price.setBounds(60,230,120,30);
		price.setFont(new Font("serif",Font.PLAIN,16));
		frame.add(price);
		
		t2=new JTextField();
		t2.setBounds(200,233,150,25);
		frame.add(t2);
		
		type=new JLabel("Bed Type");
		type.setBounds(60,280,120,30);
		type.setFont(new Font("serif",Font.PLAIN,16));
		frame.add(type);
		
		c3=new JComboBox(new String[] {"Single Bad","Double Bad"});
		c3.setBounds(200,280,150,30);
		frame.add(c3);
		
		b1=new JButton("Add Room");
		b1.setBounds(60,350,130,30);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		frame.add(b1);
		
		
		b2=new JButton("Cancel");
		b2.setBounds(220,350,130,30);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);
		frame.add(b2);
		
		l2=new JLabel(img);
		l2.setBounds(420,60,500,334);
		frame.add(l2);
		
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setLayout(null);
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == b1)
		{
		String room=t1.getText();
		String price=t2.getText();
		String avilable=(String)c1.getSelectedItem();
		String status=(String)c2.getSelectedItem();
		String type=(String)c3.getSelectedItem();	

		Conn c=new Conn();
	String str="insert into rooms values('"+room+"', '"+avilable+"', '"+status+"', '"+price+"', '"+type+"')";
	try{
		c.s.executeUpdate(str);
		JOptionPane.showMessageDialog(null,"New Room Added");
		c.c.close();
		frame.setVisible(false);
		}catch(Exception e)
	{
		System.out.println(e);
	}
		}

		if(ae.getSource() == b2)
		{
		System.exit(0);
		}

	}
	
	public static void main(String[] args)
	{
		new AddRoom();
	}
}