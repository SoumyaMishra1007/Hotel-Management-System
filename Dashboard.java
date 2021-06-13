import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Dashboard implements ActionListener
{
	JFrame frame;
	JMenuBar mb;
	JMenu m1,m2;
	JMenuItem i1,i2,i3,i4;
	JLabel l1,l2;
	ImageIcon img=new ImageIcon("h14.jpg");
	Dashboard()
	{
		frame=new JFrame();
		frame.setBounds(0,0,1840,1000);
		
		mb=new JMenuBar();
		frame.add(mb);
		mb.setBounds(0,0,1820,30);
		
		m1=new JMenu("Hotel Management ");
        m1.setForeground(Color.RED);
		mb.add(m1);
		
		m2=new JMenu("Admin");
		m2.setForeground(Color.RED);
		mb.add(m2);
        
		i1=new JMenuItem("Reception");
        i1.addActionListener(this);
		m1.add(i1);
		
        
		i2=new JMenuItem("Add Employe");
        i2.addActionListener(this);
		m2.add(i2);
          
		
		i3=new JMenuItem("Add Rooms");
        i3.addActionListener(this);
	    m2.add(i3);
      
		i4=new JMenuItem("Remove Employe");
        i4.addActionListener(this);
		m2.add(i4);	
		
		l1=new JLabel(img);
		l1.setBounds(0,30,1820,1000);
		frame.add(l1);
		
		l2=new JLabel(" WELCOME ");
		l2.setBounds(720,50,600,50);
		l2.setForeground(Color.WHITE);
        l2.setFont(new Font("serif",Font.PLAIN,50)); 
		l1.add(l2);
          		
	    frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getActionCommand().equals("Reception"))
		{
		         new Reception(); 
		}
		else if(ae.getActionCommand().equals("Add Employe"))
		{
		         new AddEmploye();
		}
		else if(ae.getActionCommand().equals("Add Rooms"))
		{
                 new AddRoom();		
		}
		else if(ae.getActionCommand().equals("Remove Employe"))
		{
		         new RemoveEmploye();
		}
		
		
		
	}
	
	public static void main(String[] args)
	{
		new Dashboard();
	}
}
		