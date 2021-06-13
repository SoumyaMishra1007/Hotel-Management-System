import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class AddEmploye implements ActionListener
{
JFrame frame;
JLabel name,age,gender,job,salary,phone,id,email,l1,l2;
JTextField t1,t2,t3,t4,t5,t6;
JRadioButton r1,r2;
JComboBox c1;
JButton b1;
String[] jobs={"Manager","Guard","Waiter/waitress","Front Desk Clark","Housekeping","kitchen Staff","Room Service"};
ImageIcon img=new ImageIcon("h15.jpg"); 
AddEmploye()
{
	frame=new JFrame();
	frame.setBounds(400,200,800,550);
	
	l1=new JLabel(img);
	l1.setBounds(360,30,480,480);
	frame.add(l1);
	
	name=new JLabel("Name");
    name.setFont(new Font("serif",Font.PLAIN,17));
	name.setBounds(60,30,120,30);
	frame.add(name);
	
	t1=new JTextField();
	t1.setBounds(200,30,120,30);
	frame.add(t1);
	
	age=new JLabel("Age");
    age.setFont(new Font("serif",Font.PLAIN,17));
	age.setBounds(60,80,120,30);
	frame.add(age);
	
	t2=new JTextField();
	t2.setBounds(200,80,120,30);
    frame.add(t2);
	
	gender=new JLabel("Gender");
    gender.setFont(new Font("serif",Font.PLAIN,17));
	gender.setBounds(60,130,120,30);
	frame.add(gender);
	
	r1=new JRadioButton("Male");
	r1.setFont(new Font("serif",Font.PLAIN,14));
	r1.setBounds(200,130,80,30);
	r1.setBackground(Color.WHITE);
	frame.add(r1);
	
	r2=new JRadioButton("Female");
	r2.setFont(new Font("serif",Font.PLAIN,14));
	r2.setBounds(290,130,100,30);
	r2.setBackground(Color.WHITE);
	frame.add(r2);
	
	job=new JLabel("Job");
    job.setFont(new Font("serif",Font.PLAIN,17));
	job.setBounds(60,180,120,30);
	frame.add(job);
	
	c1=new JComboBox(jobs);
	c1.setBounds(200,180,120,30);
	frame.add(c1);
	
	salary=new JLabel("Salary");
    salary.setFont(new Font("serif",Font.PLAIN,17));
	salary.setBounds(60,230,120,30);
	frame.add(salary);
    
	t3=new JTextField();
	t3.setBounds(200,230,120,30);
    frame.add(t3);
	
	phone=new JLabel("Phone number");
    phone.setFont(new Font("serif",Font.PLAIN,17));
	phone.setBounds(60,280,120,30);
	frame.add(phone);
    
	t4=new JTextField();
	t4.setBounds(200,280,120,30);
    frame.add(t4);
	
	id=new JLabel("Personal ID");
    id.setFont(new Font("serif",Font.PLAIN,17));
	id.setBounds(60,330,120,30);
	frame.add(id);
	
    t5=new JTextField();
	t5.setBounds(200,330,120,30);
    frame.add(t5);
	
	email=new JLabel("Email");
    email.setFont(new Font("serif",Font.PLAIN,17));
	email.setBounds(60,380,120,30);
	frame.add(email);
    
	t6=new JTextField();
	t6.setBounds(200,380,120,30);
    frame.add(t6);
	
	b1=new JButton("Register");
	b1.setForeground(Color.WHITE);
	b1.setForeground(Color.BLACK);
	b1.setBounds(200,430,150,30);
	b1.addActionListener(this);
	frame.add(b1);
	
	l2=new JLabel(" ADD EMPLOYE DETAIL ");
	l2.setBounds(460,30,400,30);
	l2.setForeground(Color.RED);
    l2.setFont(new Font("serif",Font.BOLD,20)); 
	frame.add(l2);
    frame.getContentPane().setBackground(Color.WHITE);
	frame.setLayout(null);
    frame.setVisible(true);
	
}	

public void actionPerformed(ActionEvent ae)
{
	String name=t1.getText();
	String age=t2.getText();
	String salary=t3.getText();
	String phone=t4.getText();
	String id=t5.getText();
	String email=t6.getText();
	String gender=null;
    if(r1.isSelected())
	{
		gender="Male";
	}		else if(r2.isSelected())
	{
		gender="Female";
	}	
	String job=(String)c1.getSelectedItem();
	
	Conn c=new Conn();
	String str="insert into employe values('"+name+"', '"+age+"', '"+gender+"', '"+job+"', '"+salary+"', '"+phone+"', '"+id+"', '"+email+"')";
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
public static void main(String[] args)
{
	new AddEmploye();
}
}
