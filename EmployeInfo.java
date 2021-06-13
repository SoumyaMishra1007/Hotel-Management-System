import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.*;
class EmployeInfo implements ActionListener
{
	JFrame frame;
	static JTable table;
	JButton showdata,back;
	DefaultTableModel model;
	JScrollPane pane;
	String[] columnNames ={"Name", "Age", "Gender", "job", "Salary", "Phone no", "ID", "Email"};
	EmployeInfo()
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
	
	frame.getContentPane().setBackground(Color.WHITE);
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
			new Reception();
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

		String name = "";
		String age = "";
		String gender = "";
		String job = "";
		String salary = "";
		String phone = "";
		String id = "";
		String email = "";
		
		try
		{			
			Conn c=new Conn();
			String sql = "select * from employe";
			PreparedStatement ps = c.c.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();
	        int i =0;
			while(rs.next())
	        {
				name = rs.getString("name");
				age = rs.getString("age");
				gender = rs.getString("gender");
				job = rs.getString("Job");
				salary = rs.getString("salary");
				phone = rs.getString("Phone");
				id = rs.getString("ID");
                email = rs.getString("Email");				
				model.addRow(new Object[]{name, age, gender, job, salary, phone, id, email});
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
		new EmployeInfo();
	}
}