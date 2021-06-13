import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class FrontPage extends JFrame implements ActionListener
{
JFrame frame;
JLabel l1,l2;
JButton b1;
ImageIcon i1=new ImageIcon("h12.jpg");

FrontPage()
{
frame=new JFrame();
l1=new JLabel(i1);
l2=new JLabel("HOTEL MANAGEMENT SYSTEM");
b1=new JButton("NEXT");
frame.setBounds(200,200,1300,555);
frame.setLayout(null);
frame.setVisible(true);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
l1.setBounds(0,0,1300,555);
l2.setBounds(20,450,1000,70);
frame.add(l1);
l1.add(l2);
l2.setForeground(Color.WHITE);
l2.setFont(new Font("serif",Font.PLAIN,50));
b1.setBackground(Color.WHITE);
b1.setForeground(Color.BLACK);
b1.setBounds(1100,450,150,50);
l1.add(b1);
b1.addActionListener(this);
while(true)
{
	l2.setVisible(false);
	try{
		Thread.sleep(500);
	}
	catch(Exception e){
		}
		l2.setVisible(true);
	try{
		Thread.sleep(500);
	}
	catch(Exception e){
		}
}
}
 
  public void actionPerformed(ActionEvent ae)
  {
    new Login();
    frame.setVisible(false);
  }
public static void main(String[] args)
{
new FrontPage();	
}
}
