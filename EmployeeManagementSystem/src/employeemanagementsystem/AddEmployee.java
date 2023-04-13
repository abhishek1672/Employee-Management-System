
package employeemanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.Random;

public class AddEmployee extends JFrame implements ActionListener{
    
    Random r=new Random();
    int num=r.nextInt(999999);
    JTextField tfname,tffname,tfaddress,tfphone,tfaadhar,tfemail,tfsalary,tfeducation,tfdesignation;
    JDateChooser dcdob;
    JButton add,back;
    JLabel lblempid;
    JComboBox ceducation;
    
    AddEmployee()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading=new JLabel("Add Employee Details");
        heading.setBounds(300, 30, 400, 40);
        heading.setFont(new Font("serif",Font.BOLD,25));
        add(heading);
        
        
        JLabel name=new JLabel("Name");
        name.setBounds(50, 130, 150, 30);
        name.setFont(new Font("serif",Font.BOLD,20));
        add(name);
        
         tfname=new JTextField();
        tfname.setBounds(200, 130, 120, 30);
        add(tfname);
        
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
        
         dcdob=new JDateChooser();
        dcdob.setBounds(200,200,120,30);
        add(dcdob);
        
              
        
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
        
        
        String courses[]={"BCA","BBA","BCOM","BSC","BTech","MBA","MCA","MSC"};
         ceducation=new JComboBox(courses);
        ceducation.setBackground(Color.WHITE);
        ceducation.setBounds(500,340, 120, 30);
        add(ceducation);
        
        
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
        
         tfaadhar=new JTextField();
        tfaadhar.setBounds(500,410, 120, 30);
        add(tfaadhar);
        
         JLabel empid=new JLabel("Employee ID");
        empid.setBounds(50, 480, 200, 30);
        empid.setFont(new Font("serif",Font.BOLD,20));
        add(empid);
        
          lblempid=new JLabel(""+num);
        lblempid.setBounds(200, 480, 200, 30);
        lblempid.setFont(new Font("serif",Font.BOLD,20));
        add(lblempid);
        
       add=new JButton("Add Details");
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
            String name=tfname.getText();
            String fname=tffname.getText();
            String address=tfaddress.getText();
            String dob;
            dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String salary=tfsalary.getText();
            String education=(String)ceducation.getSelectedItem();
            String designation=tfdesignation.getText();
            String email=tfemail.getText();
            String phone=tfphone.getText();
            String aadhar=tfaadhar.getText();
            String empid=lblempid.getText();
            
            
            try{
                
                Conn con=new Conn();
                String query="insert into employee values('"+empid+"','"+name+"','"+fname+"','"+dob+"','"+address+"','"+email+"','"+salary+"','"+phone+"','"+education+"','"+designation+"','"+aadhar+"')";
                con.stmt.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details Added Successfully...");
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
        new AddEmployee();
    }
}
