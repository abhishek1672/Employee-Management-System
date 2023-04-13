
package employeemanagementsystem;
import java.awt.*;

import java.awt.event.*;
import javax.swing.*;


public class Splash extends JFrame implements ActionListener{
    Splash()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading=new JLabel("Employee Management System");
        heading.setBounds(80, 30, 1200, 50);
        heading.setFont(new Font("serif",Font.PLAIN,60));
        heading.setForeground(Color.RED);
       
        add(heading);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        Image i2=i1.getImage().getScaledInstance(1100,700,Image.SCALE_DEFAULT)
       ;
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new  JLabel(i3);
        image.setBounds(50,100,1050,500);
        add(image);
        
        JButton ClickHere=new JButton("Click Here to Continue");
        ClickHere.setBounds(400,400,300,70);
        ClickHere.setBackground(Color.BLACK);
         ClickHere.setForeground(Color.WHITE);
         ClickHere.addActionListener(this);
        image.add(ClickHere);
        
        
        
        setSize(900,650);
        setLocation(200,50);
        setVisible(true);
        
        while(true)
        {
            heading.setVisible(false);
            
            try{
                Thread.sleep(500);
            }
            catch(Exception e)
            {
                
            }
              
            heading.setVisible(true);
            try{
                Thread.sleep(500);
            }
            catch(Exception e)
            {
                
            }
        }
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        setVisible(false);
        new Login();
    }
    public static void main(String args[])
    {
        new Splash();
    }
}
