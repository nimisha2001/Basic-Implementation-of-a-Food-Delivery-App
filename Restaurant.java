package sem3;
import java.util.ArrayList;
import java.util.Scanner;

class Restaurant implements Execute {
	String name;
	String category;
	ArrayList<Item> list;			//List of Food Items
	int no_of_item;					//No of Food Items
	String address;
	int orders;
	int discount;
	int reward;
	int ctr;
	
	public Restaurant(String n, String c,String add)
	{
		this.name=n;
		this.category=c;
		this.address=add;
		list=new ArrayList<Item>(10);
		this.no_of_item=0;
		this.orders=0;
		this.discount=0;
		this.reward=0;
		this.ctr=0;
	}
	
	public void get()
	{ Scanner input=new Scanner(System.in);
	  int counter=1;
	do {
		System.out.println("Welcome "+ this.name +"\r\n" + 
				"1) Add item\r\n" + 
				"2) Edit item\r\n" + 
				"3) Print Rewards\r\n" + 
				"4) Discount on bill value\r\n" + 
				"5) Exit");
		
		int nq=input.nextInt();
		
		if(nq==1)
		{
			Item i=new Item(input.next(), input.nextInt(), input.nextInt(), input.next(), input.nextInt());
			list.add(i);
			ctr++; i.id=ctr;
			this.no_of_item+=1;
			i.disp();
		}
		
		else if(nq==2)
		{
			System.out.println("Choose item by code:\n");
			this.disp_list();
			int ic=input.nextInt();
			
			for(int i=0;i<no_of_item;i++)
			{
				if(ic==list.get(i).id)
					list.get(i).edit();
			}
		}
		
		else if(nq==3)
			System.out.println("Reward Points:"+this.reward);
		
		else if(nq==4)
			{ System.out.println("Offer on bill value: ");
			  if(this.category.equals("None"))
				  System.out.println("0");
			  else
				  {
				    this.discount=input.nextInt();
				    System.out.println(this.discount+"% off");
				  }
			}
		
		else if(nq==5)
			counter=0;
		
	}while(counter==1);
  }

	@Override
	public void disp() {
		System.out.println(this.name+" "+this.category+" "+this.address+" "+this.orders);
	}
	
	public void disp_list() {
		for(int i=0;i<no_of_item;i++)
			list.get(i).disp();		
	}
	
}
