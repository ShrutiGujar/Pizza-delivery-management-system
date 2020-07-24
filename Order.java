package pizza;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class Order {
	static Scanner sc=new Scanner(System.in);
	static int tot_order;
	Vector<Integer> v=new Vector<>();
	
	void get_order() 
	{
		int x=0;
		Menu m=new Menu();
		m.show_menu();
		System.out.println("please enter -1 after giving your order\nenter order and quantity:");
		while(x>=0){
			x=sc.nextInt();
			if(x>0)
				v.add(x);
		}
	}
	void disp_ord(String u_name)
	{
		System.out.println("Your order is:");
		Iterator<Integer> i=v.iterator();
		while(i.hasNext())
			System.out.println("item:"+i.next()+" quantity:"+i.next());
		Pay p=new Pay();
		p.tot_cost(v,u_name);
	}
}
