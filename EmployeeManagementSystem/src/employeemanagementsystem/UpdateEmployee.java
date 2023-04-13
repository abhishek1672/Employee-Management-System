
package employeemanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.Random;
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener{
    
    JTextField tteducation,tffname,tfaddress,tfphone,tfaadhar,tfemail,tfsalary,tfeducation,tfdesignation;
    JButton add,back;
    JLabel lblempid;
    String empid1;
    
    UpdateEmployee(String empid1)
    {
        this.empid1=empid1;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading=new JLabel("Update Employee Details");
        heading.setBounds(300, 30, 400, 40);
        heading.setFont(new Font("serif",Font.BOLD,25));
        add(heading);
        
        
        JLabel name=new JLabel("Name");
        name.setBounds(50, 130, 150, 30);
        name.setFont(new Font("serif",Font.BOLD,20));
        add(name);
        
        JLabel lbname=new JLabel();
        lbname.setBounds(200, 130, 120, 30);
        add(lbname);
        
          JLabel fname=new JLabel("Father's Name");
        fname.setBounds(350, 130, 200, 30);
        fname.setFont(new Font("serif",Font.BOLD,20));
        add(fname);
        
         tffname=new JTextField();
        tffname.setBounds(500,130, 120, 30);
        add(tffname);
        
        JLabel dob=new JLabel("Date Of Birth");
        dob.setBounds(50, 200, 150, 30);
        dob.setFont(new Font("serif",Font.BOLD,20));
        add(dob);
        
         JLabel lbdcdob=new JLabel();
        lbdcdob.setBounds(200,200,120,30);
        add(lbdcdob);
        
              
        
          JLabel lsalary=new JLabel("Salary");
        lsalary.setBounds(350, 200, 200, 30);
        lsalary.setFont(new Font("serif",Font.BOLD,20));
        add(lsalary);
        
         tfsalary=new JTextField();
        tfsalary.setBounds(500,200, 120, 30);
        add(tfsalary);
        
        
         JLabel address=new JLabel("Address");
        address.setBounds(50, 270, 150, 30);
        address.setFont(new Font("serif",Font.BOLD,20));
        add(address);
        
         tfaddress=new JTextField();
        tfaddress.setBounds(200, 270, 120, 30);
        add(tfaddress);
        
         JLabel phone=new JLabel("Phone");
        phone.setBounds(350, 270, 200, 30);
        phone.setFont(new Font("serif",Font.BOLD,20));
        add(phone);
        
         tfphone=new JTextField();
        tfphone.setBounds(500,270, 120, 30);
        add(tfphone);
        
         JLabel email=new JLabel("Email");
        email.setBounds(50, 340, 150, 30);
        email.setFont(new Font("serif",Font.BOLD,20));
        add(email);
        
         tfemail=new JTextField();
        tfemail.setBounds(200, 340, 120, 30);
        add(tfemail);
        
         JLabel education=new JLabel("Education");
        education.setBounds(350, 340, 200, 30);
        education.setFont(new Font("serif",Font.BOLD,20));
        add(education);
        
        
//        String courses[]={"BCA","BBA","BCOM","BSC","BTech","MBA","MCA","MSC"};
         tteducation=new JTextField();
//        tteducation.setBackground(Color.WHITE);
        tteducation.setBounds(500,340, 120, 30);
        add(tteducation);
        
        
         JLabel designation=new JLabel("Designation");
        designation.setBounds(50, 410, 150, 30);
        designation.setFont(new Font("serif",Font.BOLD,20));
        add(designation);
        
         tfdesignation=new JTextField();
        tfdesignation.setBounds(200, 410, 120, 30);
        add(tfdesignation);
        
         JLabel aadhar=new JLabel("Aadthar Number");
        aadhar.setBounds(350, 410, 200, 30);
        aadhar.setFont(new Font("serif",Font.BOLD,20));
        add(aadhar);
        
        JLabel ttfaadhar=new JLabel();
        ttfaadhar.setBounds(500,410, 120, 30);
        add(ttfaadhar);
        
         JLabel empId=new JLabel("Employee ID");
        empId.setBounds(50, 480, 200, 30);
        empId.setFont(new Font("serif",Font.BOLD,20));
        add(empId);
        
          lblempid=new JLabel();
        lblempid.setBounds(200, 480, 200, 30);
        lblempid.setFont(new Font("serif",Font.BOLD,20));
        add(lblempid);
        
        try{
            Conn con=new Conn();
            String query="select * from employee where empid='"+empid1+"'";
            ResultSet rs=con.stmt.executeQuery(query);
            while(rs.next())
            {
                lbname.setText(rs.getString("name"));
                tffname.setText(rs.getString("fname"));
                lbdcdob.setText(rs.getString("dob"));
                tfsalary.setText(rs.getString("salary"));
                tfemail.setText(rs.getString("email"));
                tfaddress.setText(rs.getString("address"));
                tteducation.setText(rs.getString("education"));
                tfdesignation.setText(rs.getString("designation"));
                ttfaadhar.setText(rs.getString("aadhar"));
                lblempid.setText(rs.getString("empid"));
                tfphone.setText(rs.getString("phone"));
            }
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
       add=new JButton("Update Details");
       add.setBounds(250, 550, 150, 30);
       add.setBackground(Color.BLACK);
       add.setForeground(Color.WHITE);
     add.addActionListener(this);
       add(add);
       
       
       
       back=new JButton("Back");
       back.setBounds(450, 550, 150, 30);
     back.addActionListener(this);
       back.setBackground(Color.BLACK);
       back.setForeground(Color.WHITE);
       add(back);
        
        setSize(900,700);
        setLocation(200,20);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==add)
        {
            String fname=tffname.getText();
            String address=tfaddress.getText();
            String salary=tfsalary.getText();
            String education=(String)tteducation.getText();
            String designation=tfdesignation.getText();
            String email=tfemail.getText();
            String phone=tfphone.getText();
           
            
            
            try{
                
                Conn con=new Conn();
                String query="update  employee set fname='"+fname+"', address='"+address+"', email='"+email+"', salary='"+salary+"', phone='"+phone+"', education='"+education+"',designation='"+designation+"' where empid='"+empid1+"'" ;
                con.stmt.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details Updated Successfully...");
                setVisible(false);
                new Home();
                
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
//        new UpdateEmployee();
    }
}
