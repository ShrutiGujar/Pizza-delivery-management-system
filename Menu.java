package pizza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
class Menu 
{
	void show_menu() 
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
			String s="select * from MENU";
			st= con.createStatement();
			st.executeQuery(s);
			rs=st.executeQuery(s);
			System.out.println("item no\t"+"item name\t"+"price");
			while(rs.next())
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3));
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
	}//menu()
}//class