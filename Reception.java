import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Reception implements ActionListener
{
	JFrame frame;
	JButton newcoustomer,room,Department,employeinfo,coustomerinfo,managerinfo,Checkout,Status,roomstatus,driver,searchroom,logout;
	JLabel l1,l2;
	ImageIcon img =new ImageIcon("h30.jpg");
	Reception()
	{
		frame=new JFrame();
		frame.setBounds(300,200,1010,610);
		
		l1=new JLabel(img);
		l1.setBounds(300,60,690,490);
		frame.add(l1);
		
		l2=new JLabel("RECEPTION");
		l2.setFont(new Font("serif",Font.BOLD,19));
		l2.setBounds(70,20,150,30);
		frame.add(l2);
		
		newcoustomer=new JButton("New Coustomer Form");
		newcoustomer.addActionListener(this);
		newcoustomer.setBackground(Color.BLACK);
		newcoustomer.setForeground(Color.WHITE);
		newcoustomer.setBounds(40,60,180,30);
		
		frame.add(newcoustomer);
		
		searchroom=new JButton("Search Rooms");
		searchroom.setBackground(Color.BLACK);
		searchroom.setForeground(Color.WHITE);
		searchroom.setBounds(40,100,180,30);
		searchroom.addActionListener(this);
		frame.add(searchroom);
		
		room=new JButton("Rooms Info");
		room.setBackground(Color.BLACK);
		room.setForeground(Color.WHITE);
		room.setBounds(40,140,180,30);
		room.addActionListener(this);
		frame.add(room);
		
		Department=new JButton("Department");
		Department.setBackground(Color.BLACK);
		Department.setForeground(Color.WHITE);
	    Department.setBounds(40,180,180,30);
		Department.addActionListener(this);
		frame.add(Department);
		
		Checkout=new JButton("Check Out");
		Checkout.setBackground(Color.BLACK);
		Checkout.setForeground(Color.WHITE);
		Checkout.setBounds(40,220,180,30);
		Checkout.addActionListener(this);
		frame.add(Checkout);
		
		Status=new JButton("Update Check Status");
		Status.setBackground(Color.BLACK);
		Status.setForeground(Color.WHITE);
		Status.setBounds(40,260,180,30);
		Status.addActionListener(this);
		frame.add(Status);
		
		coustomerinfo=new JButton("Coustomer Info");
		coustomerinfo.setBackground(Color.BLACK);
		coustomerinfo.setForeground(Color.WHITE);
		coustomerinfo.setBounds(40,300,180,30);
		coustomerinfo.addActionListener(this);
		frame.add(coustomerinfo);
		
		roomstatus=new JButton("Update Room Status");
		roomstatus.setBackground(Color.BLACK);
		roomstatus.setForeground(Color.WHITE);
		roomstatus.setBounds(40,340,180,30);
		roomstatus.addActionListener(this);
		frame.add(roomstatus);
		
		driver=new JButton("Add Driver");
		driver.setBackground(Color.BLACK);
		driver.setForeground(Color.WHITE);
		driver.setBounds(40,380,180,30);
		driver.addActionListener(this);
		frame.add(driver);
		
		employeinfo=new JButton("Employe Info");
		employeinfo.setBackground(Color.BLACK);
		employeinfo.setForeground(Color.WHITE);
		employeinfo.setBounds(40,420,180,30);
		employeinfo.addActionListener(this);
		frame.add(employeinfo);
		
		managerinfo=new JButton("Manager Info");
		managerinfo.setBackground(Color.BLACK);
		managerinfo.setForeground(Color.WHITE);
		managerinfo.setBounds(40,460,180,30);
		managerinfo.addActionListener(this);
		frame.add(managerinfo);
		
		logout=new JButton("Logout");
		logout.setBackground(Color.BLACK);
		logout.setForeground(Color.WHITE);
		logout.setBounds(40,500,180,30);
		logout.addActionListener(this);
		frame.add(logout);
		
		frame.getContentPane().setBackground(Color.CYAN);
        frame.setLayout(null);
	    frame.setVisible(true);
	   
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()== newcoustomer)
		{
			new NewCustomer();
		}
		else if(ae.getSource()==searchroom)
		{
			new SearchRoom();
		}
		else if(ae.getSource()==room)
		{
			new RoomInfo();
		}
		else if(ae.getSource()==Department)
		{
			new Department();
		}
		else if(ae.getSource()==Checkout)
		{
			new CheckOut();
		}
		else if(ae.getSource()==Status)
		{
			new UpdateCheck();
		}
		else if(ae.getSource()==coustomerinfo)
		{
			new CustomerInfo();
		}
		else if(ae.getSource()==roomstatus)
		{
			new UpdateRoomStatus();
		}
		else if(ae.getSource()==driver)
		{
			new AddDriver();
		}
		else if(ae.getSource()==employeinfo)
		{
			new EmployeInfo();
		}
		else if(ae.getSource()==managerinfo)
		{
			new ManagerInfo();
		}
		else if(ae.getSource()==logout)
		{
			new Logout();
		}
	}
	
	public static void main(String[] args)
	{
		new Reception();
	}
}