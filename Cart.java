package sem3;
import java.util.ArrayList;
import java.util.Scanner;

class Cart {
	ArrayList<Item> items;
	int no_of_items;
	int delivery;
	float bill_amt;
	Restaurant restaurant;
	
	public Cart()
	{
		items=new ArrayList<Item>(10);
		no_of_items=0;
		delivery=0;
		bill_amt=0;
	}
	
	public void checkout()
	{
		if(this==null)
			System.out.println("empty");
		else
		for(int i=0;i<1;i++)
		{
			System.out.println(this.restaurant.name+" - "+items.get(i).name+" - "+items.get(i).price+" - "+this.no_of_items+" - "+items.get(i).offer+"% off");
			System.out.println("Delivery charge - "+this.delivery);
			System.out.println("Total order value - "+this.bill_amt);
		}
	}
	
}
