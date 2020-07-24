package pizza;

import java.util.Iterator;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class Pay implements payment
{
static Scanner sc=new Scanner(System.in);
int tot_amt=0;
@Override
	public void tot_cost(@SuppressWarnings("rawtypes") Vector v,String u_name) 
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
			@SuppressWarnings("unchecked")
			Iterator<Integer> i=v.iterator();
			while(i.hasNext())
			{
				int z=i.next();
				int q=i.next();
				rs=st.executeQuery(s);
				while(rs.next())
					if(rs.getInt(1)==z)
						tot_amt+=q*rs.getInt(3);
			}
			System.out.println("total bill : "+tot_amt);
			pay(u_name);
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

	public void pay(String u_name) 
	{
	// TODO Auto-generated method stub
		int ch;
		pay_details p=new pay_details();
		
		System.out.println("1.online\n2.cash\nenter your choice :");
		ch=sc.nextInt();
		switch(ch)
		{
		case 1:
			System.out.println("enter card no:");
			@SuppressWarnings("unused") int id=sc.nextInt();
			System.out.println("enter cv :");
			@SuppressWarnings("unused") int cv=sc.nextInt();
			p.pay_det(u_name,tot_amt,"online");
			System.out.println("payment done...\npreparing your order...");
			break;
		case 2:
			System.out.println("Total bill amount :"+tot_amt);
			p.pay_det(u_name,tot_amt,"cash");
			break;
		default:
			System.out.println("invalid choice");
			break;
		}
	}
}