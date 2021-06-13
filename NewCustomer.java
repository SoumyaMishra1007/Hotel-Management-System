import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
class NewCustomer implements ActionListener
{
	JFrame frame;
	JLabel id,number,name,gender,country,roomno,checkedin,deposit,l1,l2;
	JTextField tnumber,tname,tcountry,tcheckedin,tdeposit;
	JRadioButton male,female;
	JComboBox c1;
	Choice choice1;
	JButton register,back;
	String[] ID={"Passport", "Adhar card", "Voter Id", "Driving licence"};
	ImageIcon img=new ImageIcon("h39.jpg");
	NewCustomer()
	{
		frame=new JFrame();
	frame.setBounds(400,200,850,550);
	
	l1=new JLabel(img);
	l1.setBounds(400,30,400,400);
	frame.add(l1);
	
	l2=new JLabel(" ADD CUSTOMERS DETAIL ");
	l2.setBounds(60,20,400,30);
	l2.setForeground(Color.RED);
    l2.setFont(new Font("serif",Font.PLAIN,20)); 
	frame.add(l2);
	
	id=new JLabel(" ID ");
    id.setFont(new Font("serif",Font.PLAIN,17));
	id.setBounds(60,60,120,30);
	frame.add(id);
	
	c1=new JComboBox(ID);
	c1.setBounds(200,60,150,30);
	frame.add(c1);
	
	number=new JLabel(" Id Number");
    number.setFont(new Font("serif",Font.PLAIN,17));
	number.setBounds(60,100,120,30);
	frame.add(number);
	
	tnumber=new JTextField();
	tnumber.setBounds(200,100,150,25);
	frame.add(tnumber);
	
	name=new JLabel("name");
    name.setFont(new Font("serif",Font.PLAIN,17));
	name.setBounds(60,140,120,30);
	frame.add(name);
	
	tname=new JTextField();
	tname.setBounds(200,140,150,25);
	frame.add(tname);
	
	gender=new JLabel("Gender");
    gender.setFont(new Font("serif",Font.PLAIN,17));
	gender.setBounds(60,180,120,30);
	frame.add(gender);
	
	male=new JRadioButton("Male");
	male.setFont(new Font("serif",Font.PLAIN,14));
	male.setBounds(200,180,80,25);
	male.setBackground(Color.WHITE);
	frame.add(male);
	
	female=new JRadioButton("Female");
	female.setFont(new Font("serif",Font.PLAIN,14));
	female.setBounds(290,180,80,25);
	female.setBackground(Color.WHITE);
	frame.add(female);
	
	country=new JLabel("Country");
    country.setFont(new Font("serif",Font.PLAIN,17));
	country.setBounds(60,220,120,30);
	frame.add(country);
	
    tcountry=new JTextField();
	tcountry.setBounds(200,220,150,25);
    frame.add(tcountry);
	
	roomno=new JLabel("Room Number");
    roomno.setFont(new Font("serif",Font.PLAIN,17));
	roomno.setBounds(60,260,120,30);
	frame.add(roomno);
	
	
	choice1=new Choice();
	try
	{
		Conn c=new Conn();
	    String  str= "select * from rooms where avilable = 'avilable'";
		ResultSet rs=c.s.executeQuery(str);
		while(rs.next())
		{
			choice1.add(rs.getString("room"));
		}
		
	}catch(Exception e){}
	
	
	choice1.setBounds(200,265,150,25);
	frame.add(choice1);
	
	checkedin=new JLabel("Check In");
    checkedin.setFont(new Font("serif",Font.PLAIN,17));
	checkedin.setBounds(60,300,120,30);
	frame.add(checkedin);
    
	tcheckedin=new JTextField();
	tcheckedin.setBounds(200,300,150,25);
    frame.add(tcheckedin);
	
	deposit=new JLabel("Deposit");
    deposit.setFont(new Font("serif",Font.PLAIN,17));
	deposit.setBounds(60,340,120,30);
	frame.add(deposit);
    
	tdeposit=new JTextField();
	tdeposit.setBounds(200,340,150,25);
    frame.add(tdeposit);
	
	register=new JButton("User Register");
	register.setForeground(Color.WHITE);
	register.setBackground(Color.BLACK);
	register.setBounds(60,400,135,25);
	register.addActionListener(this);
	frame.add(register);
	
	back=new JButton("Back");
	back.setForeground(Color.WHITE);
	back.setBackground(Color.BLACK);
	back.setBounds(220,400,135,25);
	back.addActionListener(this);
	frame.add(back);
	
	frame.getContentPane().setBackground(Color.CYAN);
	frame.setLayout(null);
	frame.setVisible(true);
	}
	 
	public void actionPerformed(ActionEvent ae)
	{

		
		
		if(ae.getSource()==register)
		{
		String id=(String)c1.getSelectedItem();
		String number = tnumber.getText();
        String gender=null;		
	    if(male.isSelected())
	   
	   {
		      gender="Male";
	   } 
	      else if(female.isSelected())
	   {
		    gender="Female";
	   }	
			String name = tname.getText();
			String country= tcountry.getText();
			String roomno = (String)choice1.getSelectedItem();
			String checkedin = tcheckedin.getText();
			String deposit = tdeposit.getText();
			
			Conn c=new Conn();
	String str="insert into user values('"+id+"', '"+number+"', '"+gender+"', '"+name+"', '"+country+"', '"+roomno+"', '"+checkedin+"', '"+deposit+"')";
    String str2="update rooms set avilable = 'Ocupied' where room = '"+roomno+"'"; 
	try{
		c.s.executeUpdate(str);
		c.s.executeUpdate(str2);
		JOptionPane.showMessageDialog(null,"New Customer Added");
		c.c.close();
		frame.setVisible(false);
		}catch(Exception e)
	{
		System.out.println(e);
	}
			
			
		}
		else if(ae.getSource()==back)
		{
			new Reception();
			frame.setVisible(false);
		}
	}
	
	public static void main(String[] args)
	{
		new NewCustomer();
	}
}	