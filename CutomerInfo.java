import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.*;
class CustomerInfo implements ActionListener
{
	JFrame frame;
	static JTable table;
	JButton showdata,back;
	DefaultTableModel model;
	JScrollPane pane;
	String[] columnNames ={"ID", "Number", "Gender", "Name", "country", "Room no", "Check in", "Deposit"};
	CustomerInfo()
	{
	frame=new JFrame();
	frame.setBounds(240,100,1200,700);
		
	showdata=new JButton("Show Data");
	showdata.setBounds(350,530,150,30);
	showdata.setFont (new Font("Arial",Font.PLAIN,16));
	showdata.addActionListener(this);
	showdata.setForeground(Color.WHITE);
	showdata.setBackground(Color.BLACK);
	frame.add(showdata);

	back=new JButton("Back");
	back.setBounds(550,530,150,30);
	back.setFont (new Font("Arial",Font.PLAIN,16));
	back.addActionListener(this);
	back.setForeground(Color.WHITE);
	back.setBackground(Color.BLACK);
    frame.add(back);
	
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLayout(new BorderLayout());	
	frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==showdata)
		{
			showTableData();
			
		}
		else if(ae.getSource()==back)
		{
			new Dashboard();
			frame.setVisible(false);
		}
	}
	 
	public void showTableData()
	 {
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		table = new JTable();
		table.setModel(model);	
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setFillsViewportHeight(true);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setHorizontalScrollBarPolicy(
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);		
		String id = "";
		String number = "";
		String gender = "";
		String name = "";
        String country = "";
		String roomno = "";
		String checkedin = "";
		String deposit = "";
		
		try
		{			
			Conn c=new Conn();
			String sql = "select * from user";
			PreparedStatement ps = c.c.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();
	        int i =0;
			while(rs.next())
	        {
				id = rs.getString("ID");
				number = rs.getString("number");
				gender = rs.getString("gender");
				name = rs.getString("name");
				country = rs.getString("country");
				roomno= rs.getString("roomno");
				checkedin= rs.getString("checkedin");
				deposit=rs.getString("deposit");
						
				model.addRow(new Object[]{id, number, gender, name, country, roomno, checkedin, deposit});
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
		frame.add(scroll);
		frame.setVisible(true);
		
	}
	
	 public static void main(String[] args)
	{
		new CustomerInfo();
	}
}