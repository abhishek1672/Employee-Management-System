
package employeemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class RemoveEmployee extends JFrame implements ActionListener {
    
    JButton remove,back;
    Choice cempid;
    JLabel empId,name,email,fname,designation;
    JTextField tfname,tffname,tfdesignation,tfemail;
    
    public RemoveEmployee()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        empId=new JLabel("Employee id:");
        empId.setBounds(20, 60,100,30);
        add(empId);
        
        
        cempid=new Choice();
        cempid.setBounds(120,60,120,30);
        add(cempid);
        
        try{
            Conn con=new Conn();
            String query="select * from employee";
            ResultSet rs=con.stmt.executeQuery(query);
            while(rs.next())
            {
                cempid.add(rs.getString("empid"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        name=new JLabel("Name");
        name.setBounds(20,120,120,30);
        add(name);
        
        
         tfname=new JTextField();
        tfname.setBounds(200, 120, 120, 30);
        add(tfname);
        
        
        fname=new JLabel("Father's Name");
        fname.setBounds(20,170,120,30);
        add(fname);
        
         tffname=new JTextField();
        tffname.setBounds(200, 170, 120, 30);
        add(tffname);
        
        email=new JLabel("Email");
        email.setBounds(20,220,120,30);
        add(email);
        
        tfemail=new JTextField();
        tfemail.setBounds(200, 220, 120, 30);
        add(tfemail);
        
        designation=new JLabel("Designation");
        designation.setBounds(20,270,120,30);
        add(designation);
        
        tfdesignation=new JTextField();
        tfdesignation.setBounds(200, 270, 120, 30);
        add(tfdesignation);
        
        
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2=i1.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
       
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new  JLabel(i3);
        image.setBounds(400,0,500,500);
        add(image);
        
        remove=new JButton("Delete record");
       remove.setBounds(30, 500, 150, 30);
       remove.addActionListener(this);
       add(remove);
       
         back=new JButton("Back");
         back.setBounds(200,500,150,30);
         back.addActionListener(this);
         add(back);
         
         
         try{
            Conn con=new Conn();
            String query="select * from employee where empid='"+cempid.getSelectedItem()+"'";
            ResultSet rs=con.stmt.executeQuery(query);
            while(rs.next())
            {
                tfname.setText(rs.getString("name"));
                tffname.setText(rs.getString("fname"));
                tfemail.setText(rs.getString("name"));
                tfdesignation.setText(rs.getString("designation"));
            }
        }
                catch(Exception e)
        {
            e.printStackTrace();
        }
       
         
               cempid.addItemListener(new ItemListener()
               {
                  

            @Override
            public void itemStateChanged(ItemEvent ie) {
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                  
try{
            Conn con=new Conn();
            String query="select * from employee where empid='"+cempid.getSelectedItem()+"'";
            ResultSet rs=con.stmt.executeQuery(query);
            while(rs.next())
            {
                tfname.setText(rs.getString("name"));
                tffname.setText(rs.getString("fname"));
                tfemail.setText(rs.getString("name"));
                tfdesignation.setText(rs.getString("designation"));
            }
        }
                catch(Exception e)
        {
            e.printStackTrace();
        }
            }
               });
                 
         
        setSize(1000,800);
        setLocation(40,20);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==remove)
        {
           try{
                Conn con=new Conn();
            String query="delete from employee where empid='"+cempid.getSelectedItem()+"'";
            con.stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Record Deleted Successfully...");
               setVisible(false);
               new Home();
           }
           catch(Exception e)
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
        new RemoveEmployee();
    }
    
}
