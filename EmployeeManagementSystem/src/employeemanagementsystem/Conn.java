
package employeemanagementsystem;
import java.sql.*;

public class Conn {
    
    Connection con;
    Statement stmt;
    public Conn()
    {
        try{
            String url="jdbc:mysql://localhost:3306/employeemanagementsystem";
            String username="root";
            String password="";
            con=DriverManager.getConnection(url,username,password);
            stmt=con.createStatement();
            
        }
        
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
