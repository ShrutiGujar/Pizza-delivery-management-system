package pizza;

import java.sql.*;
import java.util.*;

public class Admin {
	static Scanner sc=new Scanner(System.in);
void add()
{
	try 
	{
		Class.forName("Oracle.jdbc.driver.OracleDriver");
	} catch (ClassNotFoundException e) {}
	Connection con=null;
	PreparedStatement st=null;
	try 
	{
		con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		String s="insert into MENU values(?,?,?)";
		st= con.prepareStatement(s);
		System.out.println("item no:");
		int item_no=sc.nextInt();
		System.out.println("item name:");
		String item_name=sc.next();
		System.out.println("item price:");
		int price=sc.nextInt();
		st.setInt(1, item_no);
		st.setString(2, item_name);
		st.setInt(3, price);
		int i=st.executeUpdate();
		System.out.println("added "+i+" items");
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
}//add

void update()
{
	try 
	{
		Class.forName("Oracle.jdbc.driver.OracleDriver");
	} catch (ClassNotFoundException e) {}
	Connection con=null;
	PreparedStatement st=null;
	try 
	{
		con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		String s="update menu set PRICE=?,ITEM_NAME=? where ITEM_NO=?";
		st= con.prepareStatement(s);
		System.out.println("item no:");
		int item_no=sc.nextInt();
		System.out.println("item name:");
		String item_name=sc.next();
		System.out.println("item price:");
		int price=sc.nextInt();
		st.setInt(3, item_no);
		st.setString(2, item_name);
		st.setInt(1, price);
		int i=st.executeUpdate();
		System.out.println("updated "+i+" items");
	} 
	catch (SQLException e) 
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
}//update()

void del()
{
	try 
	{
		Class.forName("Oracle.jdbc.driver.OracleDriver");
	} catch (ClassNotFoundException e) {}
	Connection con=null;
	PreparedStatement st=null;
	try 
	{
		con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		String s="delete from menu where ITEM_ID=?";
		st= con.prepareStatement(s);
		System.out.println("item no:");
		int item_no=sc.nextInt();
		st.setInt(1, item_no);
		int i=st.executeUpdate();
		System.out.println("deleted "+i+" items");
	} 
	catch (SQLException e) 
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
}//del()


void tot_revenue()
{
	try 
	{
		Class.forName("Oracle.jdbc.driver.OracleDriver");
	} catch (ClassNotFoundException e) {}

	Connection con=null;
	PreparedStatement st =null; 
	ResultSet rs=null;
	try 
	{
		con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		String s="select count(tot_amt),sum(tot_amt) from pay_det where date_o=TO_CHAR(CURRENT_DATE)";
		st=con.prepareStatement(s);
		st.executeQuery(s);
		rs=st.executeQuery(s);
		while(rs.next())
		{
			System.out.println("total orders:"+rs.getInt(1)+"\ntotal amount:"+rs.getInt(2));
		}
		//return;
	} 
	catch (SQLException e) 
	{
		System.out.println("EXC CAUGHT");
	}
	finally
	{
		try 
		{
			//rs.close();
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
