import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Queue
{
	private int maxSize;
	private long[] queArray;
	private int front;
	private int rear;
	private int nItems;
	public long runningTally; 
	public boolean justAdded; 

	public Queue(int s)
	{
		maxSize = s;
		queArray = new long[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
		runningTally = 0;
	}

	public void insert(long j)
	{
		if(rear == maxSize -1)
			rear = -1;
		queArray[++rear] = j;
		nItems++;
	}

	public long remove()
	{
		long temp = queArray[front++];
		if(front == maxSize)
			front = 0;
		nItems--;
		return temp;
	}

	public long peekFront()
	{
		return queArray[front];
	}

	public long itemAt(int i)
	{
		return queArray[i];
	}

	public boolean isEmpty()
	{
		return(nItems==0);
	}

	public boolean isFull()
	{
		return(nItems==maxSize);
	}

	public int size()
	{
		return nItems;
	}

	public void display()	
	{
		int temp = front;
		for(int i = 0; i < nItems; i++)
		{
			System.out.print(queArray[temp] + " ");
			temp++;
			if(temp == maxSize) temp = 0;
		}
		System.out.println("");
	}
}
class Checkout
{
	private int numQueues;
	private int maxQueSize;
	private Queue[] queues;
	private Queue fastLane; 
	private long base; 
	private double percent;		
	public Checkout(int nQueues, int nSize, boolean fast)
	{
		numQueues = nQueues;
		maxQueSize = nSize;
		queues = new Queue[numQueues];
		if(fast) fastLane = new Queue(maxQueSize);
		for(int i = 0; i < numQueues; i++)
			queues[i] = new Queue(maxQueSize);
		
		base = 15;
		percent = 10;
	}
		public void addCustomer()
		{
			long customer = (long) (Math.ceil(Math.random() * 30));	
		
			int shortest = 0;	
			long shortestLength = 9999;	
		
			long temp = 0;
		
			if(fastLane != null && customer <= 10) 
			{
				temp = base * fastLane.size();
				for(int j = 0; j < fastLane.size(); j++)
					temp += fastLane.itemAt(j);
				if(shortestLength > temp) 
				{
					shortest = -1;
					shortestLength = temp;
				}	
			}
			for(int i = 0; i < queues.length; i++)
			{
				temp = base * queues[i].size();
				for(int j = 0; j < queues[i].size(); j++)
					temp += ( queues[i]).itemAt(j);
				if(shortestLength > temp) 
				{
					shortest = i;
					shortestLength = temp;
				}
			}
		
			if(shortest == -1) 
			{
				fastLane.insert(customer);
				System.out.println("Customer " + customer + " added to fast-lane.");
				System.out.println();
				fastLane.justAdded = true;
			}
			else 
			{
				queues[shortest].insert(customer);
				System.out.println("Customer " + customer + " added to line " + (shortest+1));
				System.out.println();
				if(queues[shortest].runningTally <= 0)
					queues[shortest].justAdded = true;
			}
		
		}
	
	public void process(int time)	

	{
		for(int i = 0; i < time; i++) 
		{
			for(int j = 0; j < queues.length; j++) 
		
			{
				if(queues[j].runningTally <= 0) 
				
				{
	
					if(!queues[j].isEmpty() && !queues[j].justAdded) queues[j].remove();
					queues[j].runningTally = queues[j].peekFront();
				}
				else queues[j].runningTally--; 
	
				queues[j].justAdded = false;
	
			}
			
			if(fastLane != null)
			{
				if(fastLane.runningTally <= 0)
				{
					if(!fastLane.isEmpty() && !fastLane.justAdded) fastLane.remove();
					fastLane.runningTally = fastLane.peekFront();
				}
				else fastLane.runningTally--;
				fastLane.justAdded = false;
			}
			
			if((Math.random() * 100) <= percent) 
				addCustomer();
		}
	}
	
	public void display()
	{
		for(int i = 0; i < queues.length; i++)
		{
			System.out.print("Line " + (i+1) + ": ");
			queues[i].display();
			System.out.println();
			System.out.println("Running Tally: " + queues[i].runningTally);
			System.out.println();
		}
		if(fastLane != null) 
		{
			System.out.print("Fast-Lane: ");
			fastLane.display();
			System.out.println();
			System.out.println("Running Tally: " + fastLane.runningTally);
			System.out.println();
		}
	}
	
	public void initialize()	
	{
		for(int i = 0; i < queues.length; i++)
		{
			for(int j = 0; j < (Math.floor(Math.random() * 4)); j++)
			{
				queues[i].insert((long)(Math.ceil(Math.random() * 30)));
			}
			queues[i].runningTally = queues[i].peekFront(); 
			
				}
		if(fastLane != null)
		{
			for(int j = 0; j < (Math.floor(Math.random() * 4)); j++)
			{
				fastLane.insert((long)(Math.ceil(Math.random() * 10)));
			}
			fastLane.runningTally = fastLane.peekFront(); 
		}	
	}
}
		
class cust_Q
{
	public static void main(String[] args) throws IOException
	{
		String input;
		Checkout grocery = new Checkout(2, 5, true);
		/*
		grocery.initialize();
		grocery.display();
		grocery.addCustomer();
		grocery.addCustomer();
		grocery.display();
		grocery.addCustomer();
		grocery.display();
		*/
		int tmp=-1;
		Scanner sc = new Scanner(System.in);
		while(tmp!=0)
		{
			System.out.println("Options\n");
			System.out.println("1).Add Customers");
			System.out.println("2).Checkout Customer");
			System.out.println("3).Dispaly");
			System.out.println("0).Exit");
			System.out.println();
			System.out.println("Please enter your choice");
			System.out.println();
			int ch=sc.nextInt();
			if(ch==1)
			{
				grocery.addCustomer();
				//grocery.display();
			}
			else if (ch==2)
			{
				grocery.initialize();
				//grocery.display();
			}
			else if(ch==3)
			{
				grocery.display();
			}
			else if(ch==0)
				tmp=0;
		}
		
		while(true)
		{
			System.out.print("Time to Pass: ");
			System.out.flush();
			input = getString();
			if (input.equals("") ) break;
			grocery.process(Integer.parseInt(input) );
			
			grocery.display();
		}			
	}
	
	public static String getString() throws IOException
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
}
