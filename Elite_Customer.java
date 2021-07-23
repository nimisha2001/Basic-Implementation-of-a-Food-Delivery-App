package sem3;
import java.util.ArrayList;
import java.util.Scanner;

//CLASS FOR THE ELITE CUSTOMER
class Elite extends Customer {

	public Elite(String n, String cat, String add) {
		super(n, cat, add);
	}
	
	
	public void discount()
	{
		if(this.acc_bal>200)
			this.acc_bal-=50;
	}
	
	public void reward()
	{
		if(cart.restaurant.category.equals("Fast Food"))
		{
			if(cart.bill_amt>=150)
			{
				cart.restaurant.reward+=10;
				this.reward+=10;
			}				
		}
		
		else if(cart.restaurant.category.equals("Authentic"))
		{
			if(cart.bill_amt>=200)
			{
				cart.restaurant.reward+=25;
				this.reward+=25;
			}				
		}
		
		else
		{
			if(cart.bill_amt>=100)
			{
				cart.restaurant.reward+=5;
				this.reward+=5;
			}				
		}
	}
	
}
