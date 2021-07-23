package sem3;
import java.util.ArrayList;
import java.util.Scanner;

class Item {
	int id;
	String name;
	int price;
	int qty;
	String cgy;
	int offer;
	
	public Item(String n,int p,int q,String c,int off)
	{
		this.name=n;
		this.price=p;
		this.qty=q;
		this.cgy=c;
		this.offer=off;
	}
	
	public void disp()
	{  System.out.println(this.id+" "+this.name+" "+this.price+" "+this.qty+" "+this.cgy+" "+this.offer+"% off");  }
	
	public void edit()
	{ Scanner input=new Scanner(System.in);
	
		System.out.println("Choose an attribute to edit:\r\n" + 
				"1) Name\r\n" + 
				"2) Price\r\n" + 
				"3) Quantity\r\n" + 
				"4) Category\r\n" + 
				"5) Offer");
		int a=input.nextInt();
		
		if(a==1)
		{
			System.out.println("Enter the new name:");
			String b=input.next();
			this.name=b;
		}
		
		else if(a==2)
		{
			System.out.println("Enter the new price:");
			int b=input.nextInt();
			this.price=b;
		}
		
		else if(a==3)
		{
			System.out.println("Enter the new quantity:");
			int b=input.nextInt();
			this.qty=b;
		}
		
		else if(a==4)
		{
			System.out.println("Enter the new category:");
			String b=input.next();
			this.cgy=b;
		}
		
		else if(a==5)
		{
			System.out.println("Enter the new offer:");
			int b=input.nextInt();
			this.offer=b;
		}
		
		this.disp();
	}
}
