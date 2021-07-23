package sem3;
import java.util.ArrayList;
import java.util.Scanner;

//The main class
public class AP_Assignment2 {
	static float zotato_money=0;
	static int delivery_money=0;

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int counter=1;
		
		ArrayList<Restaurant> rarr= new ArrayList<Restaurant>(5);	//Restaurant array
		ArrayList<Customer> carr= new ArrayList<Customer>(5);		//Customer array
		
		Restaurant r=new Restaurant("Shah","Authentic","Delhi"); rarr.add(r);
		r=new Restaurant("Ravi's","None","Mumbai");  rarr.add(r);
		r=new Restaurant("The Chinese","Authentic","Pune");  rarr.add(r);
		r=new Restaurant("Wang's","Fast Food","Bangalore");  rarr.add(r);
		r=new Restaurant("Paradise","None","Delhi");  rarr.add(r);
		
		Customer c=new Customer("Ram","Elite","Delhi"); carr.add(c);
		c=new Customer("Sam","Elite","Pune"); carr.add(c);
		c=new Customer("Tim","Special","Bangalore"); carr.add(c);
		c=new Customer("Kim","Regular","Delhi"); carr.add(c);
		c=new Customer("Jim","Regular","Mumbai"); carr.add(c);
		
		
	do {	
		System.out.println("Welcome to Zotato:\r\n" + 
				"1) Enter as Restaurant Owner\r\n" + 
				"2) Enter as Customer\r\n" + 
				"3) Check User Details\r\n" + 
				"4) Company Account details\r\n" + 
				"5) Exit");		
		int n=input.nextInt();
		
		if(n==1)
		{   System.out.println("Choose Restaurant");
			for(int i=0;i<5;i++)
			{ 
				System.out.print(i+1+") "+rarr.get(i).name);
				if(rarr.get(i).category.equals("Authentic"))
					System.out.print(" (Authentic)");
				else if(rarr.get(i).category.equals("Fast Food"))
					System.out.print(" (Fast Food)");
				System.out.println();
			}
			
			int q=input.nextInt();
			rarr.get(q-1).get();
		}
		
		else if(n==2)
		{   System.out.println();
			for(int i=0;i<5;i++)
			{ 
				System.out.print(i+1+") "+carr.get(i).name);
				if(carr.get(i).category.equals("Elite"))
					System.out.print(" (Elite)");
				else if(carr.get(i).category.equals("Special"))
					System.out.print(" (Special)");
				System.out.println();
			}
			
			int q=input.nextInt();
			carr.get(q-1).get(rarr);
		}
		
		else if(n==3)
		{
			System.out.println("1) Customer List\r\n" + 
					"2) Restaurant List");
			int q=input.nextInt();
			
			if(q==1)
			{
				for(int i=0;i<5;i++)
					System.out.println(i+1+") "+carr.get(i).name);
				int cust=input.nextInt();							//which customer
				carr.get(cust-1).disp();
			}
			
			else if(q==2)
			{
				for(int i=0;i<5;i++)
					System.out.println(i+1+") "+rarr.get(i).name);
				int cust=input.nextInt();							//which restaurant
				rarr.get(cust-1).disp();
			}
		}
		
		else if(n==4)
		{
			System.out.println("Total Company balance - INR "+zotato_money+"\r\n" + 
					"Total Delivery Charges Collected - INR "+delivery_money);
		}

		else if(n==5)
			counter=0;
			
	}while(counter==1);
	
  }
}
