import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class AddDriver implements ActionListener
{
JFrame frame;
JLabel title,name,age,gender,carcompany,carmodel,available,location,l1;
JTextField tname,tage,tcarcompany,tcarmodel,tlocation;
JComboBox cb1,cb2;
JButton adddriver,back;
String Gender[]={"Male","Female","Others"};
String Available[]={"Available","Not-Available"};
ImageIcon img=new ImageIcon("h20.jpg");


	public AddDriver()
	{
	frame = new JFrame();
	frame.setBounds(280,180,1000,600);

	l1=new JLabel(img);
	l1.setBounds(450,60,500,400);
	l1.setBackground(Color.WHITE);
	frame.add(l1);
	
	
	title=new JLabel("Add Drivers");
	title.setBounds(150,10,150,30);
	title.setFont (new Font("Arial",Font.BOLD,20));
	frame.add(title);

	name=new JLabel("Name ");
    name.setBounds(60,80,120,30);
	name.setFont (new Font("Arial",Font.PLAIN,16));
	frame.add(name);
	
	tname=new JTextField(20);
	tname.setBounds(250,80,150,30);
	frame.add(tname);
	
	age=new JLabel("Age ");
	age.setBounds(60,130,120,30);
	age.setFont (new Font("Arial",Font.PLAIN,16));
	frame.add(age);
	
	tage=new JTextField(20);
	tage.setBounds(250,130,150,30);
	frame.add(tage);
	
	gender=new JLabel("Gender ");
	gender.setBounds(60,180,120,30);
	gender.setFont (new Font("Arial",Font.PLAIN,16));
	frame.add(gender);
	
	cb1=new JComboBox(Gender);
	cb1.setBounds(250,180,150,30);
	frame.add(cb1);

	carcompany=new JLabel("Car Company ");
	carcompany.setBounds(60,230,120,30);
	carcompany.setFont (new Font("Arial",Font.PLAIN,16));
	frame.add(carcompany);
	
	tcarcompany=new JTextField(20);
	tcarcompany.setBounds(250,230,150,30);
	frame.add(tcarcompany);
	
	carmodel=new JLabel("Car Model  ");
	carmodel.setBounds(60,280,120,30);
	carmodel.setFont (new Font("Arial",Font.PLAIN,16));
	frame.add(carmodel);
	
	tcarmodel=new JTextField(20);
	tcarmodel.setBounds(250,280,150,30);
	frame.add(tcarmodel);
	
	available=new JLabel("Available ");
	available.setBounds(60,330,120,30);
	available.setFont (new Font("Arial",Font.PLAIN,16));
    frame.add(available);
	
    cb2=new JComboBox(Available);
    cb2.setBounds(250,330,150,30);
	frame.add(cb2);
	
	location=new JLabel("Location ");
	location.setBounds(60,380,120,30);
	location.setFont (new Font("Arial",Font.PLAIN,16));
    frame.add(location);
	 
	tlocation=new JTextField();
	tlocation.setBounds(250,380,150,30);
    frame.add(tlocation);
	
	adddriver=new JButton("Add Driver");
	adddriver.setBounds(60,430,150,30);
	adddriver.setFont (new Font("Arial",Font.PLAIN,16));
	adddriver.addActionListener(this);
	adddriver.setForeground(Color.WHITE);
	adddriver.setBackground(Color.BLACK);
	frame.add(adddriver);

	back=new JButton("Back");
	back.setBounds(250,430,150,30);
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
		if(ae.getSource() ==adddriver)
		{
		String name=tname.getText();
		String age=tage.getText();
		String carcompany=tcarcompany.getText();
		String carmodel=tcarmodel.getText();
		String location=tlocation.getText();
		String gender=(String)cb1.getSelectedItem();
		String avilable=(String)cb2.getSelectedItem();
		Conn c=new Conn();
	    String str="insert into driver values('"+name+"', '"+age+"', '"+gender+"', '"+carcompany+"', '"+carmodel+"', '"+avilable+"', '"+location+"')";
	    try{
		c.s.executeUpdate(str);
		JOptionPane.showMessageDialog(null,"New Employe Added");
		c.c.close();
		frame.setVisible(false);
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

	public static void main(String args[])
	{
	new AddDriver();
	}
}