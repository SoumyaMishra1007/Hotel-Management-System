import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
class UpdateRoomStatus implements ActionListener
{
	JFrame frame;
	JLabel id,roomno,avilable,status,l1,l2;
	JTextField troomno,tavilable,tstatus;
	Choice choice1;
	JButton check,update,back;
	ImageIcon img=new ImageIcon("h21.jpg");
	
	UpdateRoomStatus()
	{
	frame=new JFrame();
	frame.setBounds(400,200,1070,500);
	
	l1=new JLabel(img);
	l1.setBounds(400,30,600,400);
	frame.add(l1);
		
	l2=new JLabel(" Update Room Status ");
	l2.setBounds(60,20,200,30);
	l2.setForeground(Color.RED);
    l2.setFont(new Font("serif",Font.PLAIN,20)); 
	frame.add(l2);
	
	id=new JLabel(" Customer ID ");
    id.setFont(new Font("serif",Font.PLAIN,16));
	id.setBounds(60,80,120,30);
	frame.add(id);
	
	choice1=new Choice();
	try
	{
		Conn c=new Conn();
	    String  str= "select * from user ";
		ResultSet rs=c.s.executeQuery(str);
		while(rs.next())
		{
			choice1.add(rs.getString("number"));
		}
		c.c.close();
		
	}catch(Exception e){}
	
	choice1.setBounds(200,80,140,30);
	frame.add(choice1);
	
	roomno=new JLabel(" Room Number ");
    roomno.setFont(new Font("serif",Font.PLAIN,15));
	roomno.setBounds(60,130,120,30);
	frame.add(roomno);
	
	troomno=new JTextField();
	troomno.setBounds(200,130,140,25);
	frame.add(troomno);
	
	avilable=new JLabel(" Availability ");
    avilable.setFont(new Font("serif",Font.PLAIN,15));
	avilable.setBounds(60,180,120,30);
	frame.add(avilable);
	
	tavilable=new JTextField();
	tavilable.setBounds(200,180,140,25);
	frame.add(tavilable);
	
	status=new JLabel(" Cleaning Status ");
    status.setFont(new Font("serif",Font.PLAIN,15));
	status.setBounds(60,230,120,30);
	frame.add(status);
	
    tstatus=new JTextField();
	tstatus.setBounds(200,230,140,25);
    frame.add(tstatus);
	
	
	check=new JButton("Check");
	check.setForeground(Color.WHITE);
	check.setBackground(Color.BLACK);
	check.setBounds(20,350,100,25);
	check.addActionListener(this);
	frame.add(check);
	
	update=new JButton("Update");
	update.setForeground(Color.WHITE);
	update.setBackground(Color.BLACK);
	update.setBounds(140,350,100,25);
	update.addActionListener(this);
	frame.add(update);
	
	back=new JButton("Back");
	back.setBounds(260,350,100,25);
	back.setFont (new Font("Arial",Font.PLAIN,16));
	back.addActionListener(this);
	back.setForeground(Color.WHITE);
	back.setBackground(Color.BLACK);
    frame.add(back);
	
	frame.getContentPane().setBackground(Color.CYAN);
	frame.setLayout(null);
	frame.setVisible(true);
	}
	 
	public void actionPerformed(ActionEvent ae)
	{
        if(ae.getSource() == check)
		{   
	        String room = null;
			String s =(String) choice1.getSelectedItem();		
			Conn c=new Conn();
	String str2 = "select * from user where number='"+s+"'";
	
	try{
	ResultSet rs =c.s.executeQuery(str2);
	while(rs.next())
	{
	troomno.setText(rs.getString("roomno"));
	room=rs.getString("roomno");
		}
		String str3 = "select * from rooms where room='"+room+"'";
		
	ResultSet rs1 =c.s.executeQuery(str3);
	while(rs1.next())
	{
	tavilable.setText(rs1.getString("avilable"));
	tstatus.setText(rs1.getString("status"));
		}
		
	}catch(Exception e)
	{
		System.out.println(e);
	}
		}
		
		
		else if(ae.getSource() == update)
		{
	
		String room = troomno.getText();
        String avilable = tavilable.getText();
        String status = tstatus.getText();			
		Conn c=new Conn();
     
	 String str4 ="update rooms set avilable='"+avilable+"' where room='"+room+"'"; 
	 String str5 ="update rooms set status='"+status+"' where room='"+room+"'";
	try{
		c.s.executeUpdate(str4);
		c.s.executeUpdate(str5);
		JOptionPane.showMessageDialog(null,"Room Status Updated Successfully");
		frame.setVisible(false);
		new Reception();
		}catch(Exception e)
	{
		System.out.println(e);
	}
			}
		
	if(ae.getSource()==back)
		{
			new Reception();
			frame.setVisible(false);
		}
	}
	

		
	public static void main(String[] args)
	{
		new UpdateRoomStatus();
	}
}	