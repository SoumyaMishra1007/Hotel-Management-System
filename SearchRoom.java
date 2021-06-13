

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class SearchRoom implements ActionListener
{
	JFrame frame, frame1;
	JLabel l1,l2;
	JComboBox c1;
	JButton search,back;
	static JTable table;
	TableModel tm;
	DefaultTableModel model;
	String s=null;
	
	Conn c=new Conn();
	String[] columnNames ={"room", "avilable", "status", "price", "type"};

    SearchRoom()
	{
		frame = new JFrame();	
	
	l1 = new JLabel("Search For Room");
	l1.setFont(new Font("Arial",Font.PLAIN,20));
	l1.setBounds(50,30,200,30);
	frame.add(l1);
	
	l2 = new JLabel("Room bed type");
	l2.setBounds(50,100,100,20);
	frame.add(l2);
	
	c1 = new JComboBox(new String[]{"Single Bad", "Double Bad"});
	c1.setBounds(150,100,150,25);
	c1.setBackground(Color.WHITE);
	frame.add(c1);
	
	
	table= new JTable();
	table.setBounds(0,200,400,300);
	frame.add(table);
	
	search = new JButton("Search");
	search.setForeground(Color.WHITE);
	search.setBackground(Color.BLACK);
	search.setBounds(20,500,120,30);
	search.addActionListener(this);
	frame.add(search);
	
	back= new JButton("Back");
	back.setForeground(Color.WHITE);
	back.setBackground(Color.BLACK);
	back.setBounds(160,500,120,30);
	back.addActionListener(this);
	frame.add(back);
	
	frame.getContentPane().setBackground(Color.WHITE);
	frame.setLayout(null);
	frame.setBounds(150,200,400,700);
	frame.setVisible(true);
	}	
		
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()== search)
		{
		    s=(String)c1.getSelectedItem();
			System.out.println("Showing Table Data.......");
			showTableData();
				
		}			
		
		if(ae.getSource()== back)
		{
			new Reception();
		    frame.setVisible(false);
			frame1.setVisible(false);
		
		
	}	
	}
	
	public void showTableData()
	{
		
		frame1 = new JFrame("Database Search Result");
		frame1.setBounds(500,200,400,300);
		frame1.setLayout(new BorderLayout());		
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		table = new JTable();
		table.setModel(model);
        
		frame.add(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setFillsViewportHeight(true);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setHorizontalScrollBarPolicy(
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		String room = "";
		String avilable = "";
		String status = "";
		String price = "";
		String type = "";
		try
		{			
			String sql = "select * from rooms where type = '"+s+"' and avilable ='avilable'";
			PreparedStatement ps = c.c.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();
	        int i =0;
			while(rs.next())
	        {
				room = rs.getString("room");
				avilable = rs.getString("avilable");
				status = rs.getString("status");
				price = rs.getString("price");
				type = rs.getString("type");
				
				model.addRow(new Object[]{room, avilable, status, price, type});
				i++;				
	        }
			if(i <1)
			{
				JOptionPane.showMessageDialog(null, "No Record Found","Error",
						JOptionPane.ERROR_MESSAGE);
			}
			if(i ==1)
			{
			System.out.println(i+" Record Found");
			}
			else
			{
				System.out.println(i+" Records Found");
			}
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
					JOptionPane.ERROR_MESSAGE);
		}
		frame1.add(scroll);
		frame1.setVisible(true);
	
	}
	
	public static void main(String args[])
	{
         new SearchRoom();
		        		        
	}
}
