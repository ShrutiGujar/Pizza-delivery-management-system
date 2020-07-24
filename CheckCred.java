package pizza;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CheckCred {
	static Scanner sc=new Scanner(System.in);
	String user;
	String pass;
	boolean f=false;
	void getCred()
	{
		System.out.println("enter username :");
		user=sc.next();
		System.out.println("enter password :");
		pass=sc.next();
	}
	boolean check()
	{
		try 
		{
			Class.forName("Oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {}

		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try 
		{
			con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
			String s="select * from admin";
			st= con.createStatement();
			st.executeQuery(s);
			rs=st.executeQuery(s);
			while(rs.next())
			{
				if((user.compareTo(rs.getString(1))>=0) && pass.compareTo(rs.getString(2))>=0)
						f=true;
			} 
			if(f==true)
				//System.out.println("access granted");
				return f;
			else
				//System.out.println("access denied");
				return f;
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				rs.close();
				st.close();
				con.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}//finally
		return f;
	}
}