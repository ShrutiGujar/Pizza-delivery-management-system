package pizza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
//import java.util.Date;

public class pay_details {
void pay_det(String u_name,int tot_amt,String mode)
{
	try 
	{
		Class.forName("Oracle.jdbc.driver.OracleDriver");
	} catch (ClassNotFoundException e) {}
	Connection con=null;
	PreparedStatement st=null;
	try 
	{
		long millis=System.currentTimeMillis();  
		java.sql.Date d=new java.sql.Date(millis);
		con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		String s="insert into pay_det values(?,?,?,?)";
		st= con.prepareStatement(s);
		st.setString(1, u_name);
		st.setInt(2, tot_amt);
		st.setString(3, mode);
		st.setDate(4, d);
		st.executeUpdate();
	} 
	catch ( SQLIntegrityConstraintViolationException e ) 
	{
		System.out.println("item already exists....");
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	finally
	{
		try 
		{
			st.close();
			con.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}//finally
}
}
