
package employeemanagementsystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
public class ViewEmployee extends JFrame implements ActionListener{
    
    JTable table;
    Choice cempid;
    JButton search,print,update,back;
     ViewEmployee()
     {
         getContentPane().setBackground(Color.WHITE);
         setLayout(null);
         
         JLabel searchl=new JLabel("Search By Employee id");
         searchl.setBounds(20, 20, 150, 20);
         add(searchl);
         
         cempid=new Choice();
         cempid.setBounds(200, 20, 140, 20);
         add(cempid);
         
         
         try{
             Conn con=new Conn();
             ResultSet rs=con.stmt.executeQuery("select * from employee");
             
             while(rs.next())
             {
                 cempid.add(rs.getString("empid"));
             }
         
         }catch(Exception e)
         {
             e.printStackTrace();
         }
         
         
         table =new JTable();
         
         try{
             Conn con=new Conn();
             ResultSet rs=con.stmt.executeQuery("select * from employee");
             table.setModel(DbUtils.resultSetToTableModel(rs));
             
            
         }catch(Exception e)
         {
             e.printStackTrace();
         }
         
         
         JScrollPane jsp=new JScrollPane(table);
         jsp.setBounds(0, 100, 990, 600);
         add(jsp);
         
         search=new JButton("Search");
         search.setBounds(20,70,80,20);
         search.addActionListener(this);
         add(search);
         
         print=new JButton("Print");
         print.setBounds(110,70,80,20);
         print.addActionListener(this);
         add(print);
         
         update=new JButton("Update");
         update.setBounds(200,70,80,20);
         update.addActionListener(this);
         add(update);
         
         back=new JButton("Back");
         back.setBounds(290,70,80,20);
         back.addActionListener(this);
         add(back);
         
         setSize(1000,600);
         setLocation(90,30);
         setVisible(true);
         
     }
     
     public void actionPerformed(ActionEvent ae)
     {
         if(ae.getSource()==search)
         {
            
             
             String query="select * from employee where empid='"+cempid.getSelectedItem()+"'";
         
             try{
                 Conn con=new Conn();
                 ResultSet rs=con.stmt.executeQuery(query);
                 table.setModel(DbUtils.resultSetToTableModel(rs));
                 
             }
             catch(Exception e)
             {
                 e.printStackTrace();
                        
             }
         }
         else if(ae.getSource()==update)
         {
             setVisible(false);
             new UpdateEmployee(cempid.getSelectedItem());
         }
         else if(ae.getSource()==print)
         {
             try{
                 table.print();
                 JOptionPane.showMessageDialog(null,"Data printed Successfully...");
             }catch(Exception e)
             {
                 e.printStackTrace();
             }
         }
         
         else
         {
             setVisible(false);
             new Home();
         }
     }
    public static void main(String[] args) {
        new ViewEmployee();
    }
}
