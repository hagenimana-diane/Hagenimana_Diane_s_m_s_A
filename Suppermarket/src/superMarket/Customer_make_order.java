package superMarket;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;



import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
//import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;





import java.awt.BorderLayout;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;



public class Customer_make_order implements ActionListener,MenuListener{
	private static final Object Successful = null;

	JFrame frame;
	
	private JLabel formtitle=new JLabel("MAKING ORDER !! ON ORDER ID WRITE YOUR CHOICE NUMBER THAT YOU WILL REMEMBER");
	private JLabel reg_lb=new JLabel("CustomerID");
	JTextField NAME=new JTextField();
	
	private JLabel fname_label=new JLabel("ProductID");
	JTextField Lname_f=new JTextField();
	
	private JLabel lname_label=new JLabel("OrderDate");
	JTextField lname_f=new JTextField();
	
	private JLabel id_label=new JLabel("ORDER ID");
	JTextField pid_f=new JTextField();
//	
	private JLabel email_label=new JLabel("ORDER STATUS");
	JTextField email_f=new JTextField();
//	
//	private JLabel pl=new JLabel("PASSWORD");
//	JTextField pf=new JTextField();
	
	private

	JButton submit=new JButton("SUBMIT");
	JButton resetbtn=new JButton("CLEAN");
//	JButton change=new JButton("SAVE CHANGE");
	
	
	
	
	private JLabel code_l=new JLabel("ENTER YOUR ORDER ID TO CHECK");
	JTextField code_f=new JTextField();
	
//	JButton delete=new JButton("DELETE");
	JButton view=new JButton("VIEW");
	
	
	
	//menu
	

	JMenuBar myMenuBar = new JMenuBar();
	
    JMenu myMenuS =new JMenu("HOME");
   
    JMenu myMenuL =new JMenu("LOGOUT");
    
    
    //title
    
	JButton list=new JButton("VIEW LIST OF CUSTOMERS");
    private JLabel title=new JLabel("make sure you write correct IDs of product and customer");
    
	JButton list1=new JButton("VIEW LIST OF PRODUCTS");
  private JLabel title1=new JLabel("CLICK HERE TO DISPLAY PRODUCTS");
    
	
	public Customer_make_order() {
		createWindow();
		setLocationAndSize();
		AddComponenttoFrame();
		addActionEvent();
	}
	private void addActionEvent() {
		resetbtn.addActionListener(this);
		submit.addActionListener(this);
//		delete.addActionListener(this);
		view.addActionListener(this);
//		update.addActionListener(this);
//		change.addActionListener(this);
		list.addActionListener(this);
		list1.addActionListener(this);
		
		//menu
		myMenuS.addMenuListener(this);
//		myMenuP.addMenuListener(this);
//		myMenuC.addMenuListener(this);
//		myMenuV.addMenuListener(this);
		myMenuL.addMenuListener(this);
	}
	private void AddComponenttoFrame() {
		
		frame.add(formtitle);
		frame.add(reg_lb);
		frame.add(NAME);
		
		frame.add(fname_label);
		frame.add(Lname_f);
		
		frame.add(lname_label);
		frame.add(lname_f);
		
		frame.add(id_label);
		frame.add(pid_f);
//		
		frame.add(email_label);
		frame.add(email_f);
//		
//		frame.add(pl);
//		frame.add(pf);
//		
		
		frame.add(list);
		frame.add(list1);

		frame.add(resetbtn);
		frame.add(submit);
//		frame.add(change);
		
		frame.add(code_l);
		frame.add(code_f);
		
//		frame.add(delete);
		frame.add(view);
//		frame.add(update);
		
		//menu
		
        frame.add(myMenuBar);
		
		myMenuBar.add(myMenuS);
//		myMenuBar.add(myMenuC);
//		myMenuBar.add(myMenuP);
//		myMenuBar.add(myMenuV);
		myMenuBar.add(myMenuL);
		
		frame.add(title);
	}
	private void setLocationAndSize() {
		formtitle.setBounds(120, 60, 3000, 30);
		
		reg_lb.setBounds(20, 100, 200, 30);
		NAME.setBounds(120, 100, 200, 30);
		
		fname_label.setBounds(20, 150, 200, 30);
		Lname_f.setBounds(120, 150, 200, 30);
		
		lname_label.setBounds(20, 200, 200, 30);
		lname_f.setBounds(120, 200, 200, 30);
		
		id_label.setBounds(20, 250, 200, 30);
		pid_f.setBounds(120, 250, 200, 30);
//		
		email_label.setBounds(20, 300, 200, 30);
		email_f.setBounds(120, 300, 200, 30);
//		
//		pl.setBounds(20, 350, 200, 30);
//		pf.setBounds(120, 350, 200, 30);
		
		submit.setBounds(20, 400, 80, 30);
		resetbtn.setBounds(110, 400, 80, 30);
//		change.setBounds(200, 400, 120, 30);

		// second part
		
		code_l.setBounds(20, 500, 200, 30);
		code_f.setBounds(220, 500, 100, 30);
		
		//buttons
//		delete.setBounds(20, 540, 90, 30);
		view.setBounds(220, 540, 100, 30);
//		update.setBounds(220, 540, 100, 30);
		
				//bar
		myMenuBar.setBounds(10, 20, 700, 30);
		
		title.setBounds(360, 150, 350, 60);
		list.setBounds(360, 200, 350, 60);
		
		title1.setBounds(360, 190, 350, 60);
		list1.setBounds(360, 290, 350, 60);

		


	}
	private void createWindow() {
		frame=new JFrame();
		frame.setTitle("ADMIN  MANAGE CUSTOMERS");
		frame.setBounds(10,10,790,690);
		frame.getContentPane().setBackground(Color.white);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
//		update.getRootPane().setBackground(Color.gray);
	}
	@SuppressWarnings("unlikely-arg-type")
	@Override
	
	public void actionPerformed(ActionEvent e) {
if (e.getSource() == submit) {
		    try {
		        // Load the MySQL JDBC driver
		        Class.forName("com.mysql.jdbc.Driver");

		        // Establish a connection to the database
		        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/supermarketdb", "root", "");
		        Statement st = con.createStatement();

		        // Get values from text fields
		        String reg = NAME.getText();
		        String fname = Lname_f.getText();
		        String lname = lname_f.getText();
		        String phone = pid_f.getText();
		        String status = "pending";

		        // Check if required fields are not empty
		        if (!reg.equals("") && !fname.equals("") && !lname.equals("") && !phone.equals("")) {
		            // Execute the SQL query to insert data
		            st.executeUpdate("INSERT INTO orders VALUES('" + phone + "', '" + reg + "', '" + fname + "', '" + lname + "', '" + status + "')");
		            
		            // Display success message
		            JOptionPane.showMessageDialog(null, "Order Submit Successful");
		        } else {
		            // Display a message if any required field is empty
		            JOptionPane.showMessageDialog(null, "Fill all fields, please");
		        }

		        // Close resources
		        st.close();
		        con.close();
		    } catch (ClassNotFoundException | SQLException ex) {
		        // Handle exceptions, display an error message, or log the exception
		        ex.printStackTrace();
		        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		    }
		}
else if(e.getSource()==resetbtn) {
		NAME.setText("");
		Lname_f.setText("");
		lname_f.setText("");
		pid_f.setText("");
//		email_f.setText("");
//		pf.setText("");
		
	}

else if(e.getSource()==view) {
		
		 try {  
			 
			 if(!code_f.getText().equals("")){
		        Class.forName("com.mysql.jdbc.Driver");  
		        // establish connection  
		        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/supermarketdb", "root", "");  
		        
		        PreparedStatement ps = con.prepareStatement("select FirstName,Name,OrderDate,status from orders,customer,product WHERE orders.CustomerID=customer.CustomerID and product.ProductID=orders.ProductID and orders.OrderID="+code_f.getText()+""); 
		          ResultSet rs = ps.executeQuery(); 

		          while (rs.next()) {
		              String Quantity = rs.getString("FirstName");
		              String price = rs.getString("Name");
		              String Name = rs.getString("OrderDate");
		              String pid = rs.getString("status");
//		         
//		              
		              
		              
		              NAME.setText(Quantity);
		      		Lname_f.setText(price);
		      		lname_f.setText(Name);
		      		email_f.setText(pid);
//		      		email_f.setText(email);
//		      		pf.setText(pass);
//		              
		          
		          }
			   }else {
		        	JOptionPane.showMessageDialog(null, "fill order id fields please");	
		        }
		   
		    } catch (SQLException | ClassNotFoundException e1) {  
		         
		    }  
		
		
	}	


	else if(e.getSource()==list) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					List_of_customers frame = new List_of_customers();
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			//product_supermarketdb anyname=new product_supermarketdb();
		});
		
		
	}//end of if change

	else if(e.getSource()==list1) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					List_of_products frame = new List_of_products();
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			//product_supermarketdb anyname=new product_supermarketdb();
		});
		
		
	}//end of if change



	}
	
	
	 public void menuSelected(MenuEvent e) {
	      JMenu myMenuS = (JMenu) e.getSource();
	      JMenu myMenuP = (JMenu) e.getSource();
	      JMenu myMenuC = (JMenu) e.getSource();
	      JMenu myMenuV = (JMenu) e.getSource();
	      JMenu myMenuL = (JMenu) e.getSource();
	      
	      
	      
//	      System.out.println("Menu Selected: "+myMenuS.getText());
	      
	      if(myMenuS.getText()=="HOME")
	      {
	    	
	    	  Customer_make_order anyname=new Customer_make_order();
	   			frame.dispose();
	      }
	      if(myMenuP.getText()=="POSITION")
	      {
	    	  
//	    	  PreparedStatement ps = con.prepareStatement("select product.product_reg,fname,lname,title from product,position,candidate"
//		        		+ " where product.product_reg=candidate.candidate_reg and position.pcode=candidate.pid and candidate.candidate_reg='"+code_f.getText()+"'"); 
//		          ResultSet rs = ps.executeQuery();
	    	
//	    	  Admin_position anyname=new Admin_position();	
//	    	  frame.dispose();
	      }
	      
	      if(myMenuC.getText()=="CANDIDATE")
	      {
	    	
	    	  Admin_orders anyname=new Admin_orders();	
	    	  frame.dispose();
	      }
	      
	      if(myMenuV.getText()=="VOTES")
	      {
	    	

	    	  frame.dispose();
	      }
	      if(myMenuL.getText()=="LOGOUT")
	      {
	    	
	    	  LoginForm obj = new LoginForm();
//	    	  obj.my_update(v_code.getText());
	    	  frame.dispose();
	    	  
	    	  
	    	  
	    	  
	      }
	   }
//	
	
	
	
public static void main(String []args) {
	Customer_make_order anyname=new Customer_make_order();
}

@Override
public void menuDeselected(MenuEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void menuCanceled(MenuEvent e) {
	// TODO Auto-generated method stub
	
}



}
