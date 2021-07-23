package sem3;
import java.util.ArrayList;
import java.util.Scanner;

class Customer implements Execute {
	protected String name;
	protected String category;
	protected String address;
	protected float acc_bal;
	protected int reward;
	protected Cart cart;
	
	public Customer(String n,String cat,String add)
	{
		this.name=n;
		this.category=cat;
		this.address=add;
		this.acc_bal=1000;
		this.reward=0;
		this.cart=new Cart();
	}
	
	
	public void get(ArrayList<Restaurant> rarr) 
	{ Scanner input=new Scanner(System.in);
	  int counter=1;
	
	do {
		System.out.println("Welcome "+ this.name +"\r\n" + 
				"Customer Menu\r\n" + 
				"1) Select Restaurant\r\n" + 
				"2) checkout cart\r\n" + 
				"3) Reward won\r\n" + 
				"4) print the recent orders\r\n" + 
				"5) Exit");
		int nq=input.nextInt();
		
		if(nq==1)
		{
			System.out.println("Choose Restaurant");
			for(int i=0;i<5;i++)
			{ 
				System.out.print(i+1+") "+rarr.get(i).name);
				if(rarr.get(i).category.equals("Authentic"))
					System.out.print(" (Authentic)");
				else if(rarr.get(i).category.equals("Fast Food"))
					System.out.print(" (Fast Food)");
				System.out.println();
			}
			
			int ic=input.nextInt();   //which restaurant
			cart.restaurant=rarr.get(ic-1);
			System.out.println("Choose item by code:");
			cart.restaurant.disp_list();
			
			int it=input.nextInt();		//which item
			System.out.println("Enter item quantity -");
			int iq=input.nextInt();		//qty 
			
			float bill=0;
			bill+=(float)(cart.restaurant.list.get(it-1).price)*iq;	//total bill

//DISCOUNTS	 
			bill=(float)(bill*(100-cart.restaurant.list.get(it-1).offer)/100);	//item discount
			
//restaurant discount	
			if(cart.restaurant.category.equals("Fast Food"))
			{
				bill=(float)(bill*(100-cart.restaurant.discount)/100);
			}
				
			else if(cart.restaurant.category.equals("Authentic"))
			{
				bill=(float)(bill*(100-cart.restaurant.discount)/100);
				if(bill>100)
					bill-=50;
			}

//Customer discount
			if(this.category.equals("Elite"))
			{
				if(bill>200)
					bill-=50;
			}
			
			else if(this.category.equals("Special"))
			{
				if(bill>200)
					bill-=25;
				cart.delivery+=20;
			}
			
			else
				cart.delivery+=40;
			cart.bill_amt=bill;
//DISCOUNTS			
			
			cart.items.add(cart.restaurant.list.get(it-1));		//added item to cart
			cart.no_of_items+=iq;
			System.out.println("Items added to cart");
			
			
		}
		
		
		else if(nq==2)
		{
			cart.checkout();
			System.out.println("1) Proceed to checkout");
			int p=input.nextInt();
			
			if(p==1)
			{
				cart.bill_amt-=this.reward;
				this.reward=0;
				this.acc_bal-=cart.bill_amt;
//				cart.bill_amt=0;
				this.acc_bal-=cart.delivery;
				cart.restaurant.orders+=1;			//orders taken by restaurant
				
//REWARD
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
//REWARD
				System.out.println(cart.no_of_items+" items successfully bought for INR "+cart.bill_amt);
				AP_Assignment2.zotato_money+=(float)(0.01*cart.bill_amt);		//zotato money
				AP_Assignment2.delivery_money+=cart.delivery;					//delivery money
				
				cart.items.get(0).qty-=cart.no_of_items;
				cart=new Cart();
			}
		}
		
		else if(nq==3)
			System.out.println("Rewards: "+this.reward);
		
		else if(nq==4)
			System.out.println("Rewards: "+this.reward);
		
		else if(nq==5)
			counter=0;
		
	}while(counter==1);
	}
	
	@Override
	public void disp() {
		System.out.println(this.name+"("+this.category+") "+this.address+" "+this.acc_bal);
	}

}
