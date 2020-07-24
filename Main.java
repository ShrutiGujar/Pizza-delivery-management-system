package pizza;

import java.util.Scanner;

public class Main {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		int ch1,ch2;
			System.out.println("WELCOME TO s&s ");
			System.out.println("1.admin panel\n2.menu and order\n3.exit\nenter choice:");
			ch1=sc.nextInt();
			do
			{
				Menu m=new Menu();
			switch(ch1)
			{
			case 1:Admin a=new Admin();
				CheckCred c=new CheckCred();
				c.getCred();
				boolean s=c.check();
				if(s==true)
				{
				do
				{
					System.out.println("1.add new item\n2.update item\n3.delete item\n4.main menu\n5.today's revenue\nenter choice:");
					ch2=sc.nextInt();
					switch(ch2)
					{
					case 1:m.show_menu();
						System.out.println("how many items do you want to add");
						int n=sc.nextInt();
						for(int i=0;i<n;i++)
							a.add();
					break;
					case 2:m.show_menu();
						a.update();
					break;
					case 3:m.show_menu();
						a.del();
					case 4:
						break;
					case 5:
						a.tot_revenue();
					break;
					default:
						System.out.println("please enter correct choice");
					break;
					}	//switch
					m.show_menu();
					System.out.println("1.add new item\n2.update item\n3.delete item\n4.main menu\nenter choice:");
					ch2=sc.nextInt();
				}while(ch2!=4);
				}
				else
					System.out.println("invalid credential");
				break;
			case 2:
				System.out.println("enter your name :");
				String u_name=sc.next();
				Order o=new Order();
				o.get_order();
				o.disp_ord(u_name);
				break;
			case 3:
				break;
			default:
				System.out.println("please enter correct choice");
				break;
			}
			System.out.println("1.admin panel\n2.menu\n3.exit\nnenter choice:");
			ch1=sc.nextInt();
			}while(ch1!=3);
	}

}
