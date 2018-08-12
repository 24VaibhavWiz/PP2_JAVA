import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Chapter 4

//exercise 4.2
public class Deque {
	
	private int maxSize;;
	private long[] arr;
	private int n_items;
	private int left;
	private int right;
	
	public Deque(int s)
	{
		maxSize = s;
		arr=new long[maxSize];
		n_items=0;
		left = 1;
		right=0;
	}
	public long peek_left()
	{
		return arr[left];
	}
	public long peek_right()
	{
		return arr[right];
	}
	public void insert_left(long value)
	{
		if(!is_full()) {
			left--;
			if(left<0)left = maxSize-1;
			arr[left]=value;
			n_items++;
		}
		else 
			System.out.println("The Queue is full...!!!");
	}
	public long remove_left()
	{
		if(!is_empty())
		{
			long temp= arr[left];
			left++;
			if(left>=maxSize)left=0;
			n_items--;
			return temp;
		}
		else
		{
			System.out.println("The Queue is empty....!!!");
			return -1;
		}
	}
	public void insert_rt(long value)
	{
		if(!is_full())
		{
			right++;
			if(right >= maxSize) right = 0;
			arr[right] = value;
			n_items++;
		}
		else 
			System.out.println("The Queue is full....!!!");
	}
	public long removeRight()
	{
		if(!is_empty())
		{
			long temp = arr[right];
			right--;
			if(right < 0) right = maxSize-1;
			n_items--;
			return temp;
		}
		else
		{
			System.out.println("The Queue is empty....!!!");
			return -1;
		}
	}
	public Boolean is_empty()
	{
		if(n_items == 0) return true;
		else return false;	
	}	
	
	public Boolean is_full()
	{
		if(n_items == maxSize) return true;
		else return false;
	}
	
	public void display()
	{
		System.out.println("Left: " + left + ", Right: " + right);
		int index = left;
		for(int i = 0; i < n_items; i++)
		{
			if(index >= maxSize) index = 0;
			System.out.print(arr[index] + " ");
			index++;
		}	
		System.out.println("");
	}
}

// exercise 4.3
class stackQ {
	
	private Deque stack_queue;
	
	public stackQ(int size)
	{
		stack_queue=new Deque(size);
	}
	public void push(long i)
	{
		stack_queue.insert_rt(i);
	}
	public long pop()
	{
		return stack_queue.removeRight();
	}
	public long peek()
	{
		return stack_queue.peek_right();
	}
	public Boolean is_empty()
	{
		return stack_queue.is_empty();
	}
	public Boolean is_full()
	{
		return stack_queue.is_full();
	}
}

// exercise 4.4

class priorityQ {
	
	private int maxSize;
	private long[] Qarr;
	private int n_items;
	
	public priorityQ(int s)
	{
		maxSize =s;
		Qarr = new long[maxSize];
		n_items=0;
	}
	public void insert(long value)
	{
		if(isFull())
		{
			System.out.println("Queue is full...!!!");
			return;
		}
		else
		{
			Qarr[n_items]=value;
			n_items++;
		}
	}
	public long remove()
	{
		if(isEmpty())
		{
			System.out.println("Queue is empty....!!!");
			return -1;
		}
		
		// find lowest value and store its index
		int min_index=0;
		for (int i = 0; i < n_items; i++) 
			if(Qarr[i]<Qarr[min_index])
				min_index=i;
		
		//store the minimum value return n_items
		
		long temp= Qarr[min_index];
		
		//shift all entries down and decrease n_items
		
		for (int j = 0; j < Qarr.length; j++) {
			Qarr[j]=Qarr[j+1];
		}
		n_items--;
		return temp;
	}
	public long peekMin()	
	//look through and find lowest number
	{
		int minIndex = 0;
		for(int i = 0; i < n_items; i++)
			if(Qarr[i] < Qarr[minIndex]) minIndex = i;
		return Qarr[minIndex];
	}
	
	public boolean isEmpty()
	{
		return (n_items==0);
	}
	
	public boolean isFull()
	{
		return (n_items==maxSize);
	}
	
	public void display()
	{
		for(int i = 0; i < n_items; i++)
		{
			System.out.print(Qarr[i] + " ");
		}
		System.out.println("");
	}
}
	
class Queue
{
	private int maxSize;
	private long[] queArray;
	private int front;
	private int rear;
	private int nItems;
	
	public long runningTally; 
	
	//in checkout program, use to track how far the checker is with the customer's order
	
	public boolean justAdded; 
	//so that when runningTally is 0, new item aren't deleted right away.
	
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
	
	public void display()	//exercise 4.1
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

//exercise 4.5
class Checkout
{
	
	private int numQueues;
	private int maxQueSize;
	private Queue[] queues;
	private Queue fastLane; 
	
	//An optional 10-items-or-less line?
	
	private long base; 
	//Time to tender cash/credit expressed as a multiple of time to ring up one item;
	private double percent;	
	//chance of generating a new customer at each step, keep low!
	
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
	
	//use logic to place a customer with random # of items in a queue
	public void addCustomer()
	{
		long customer = (long) (Math.ceil(Math.random() * 30));	
		//max of 30 items
		int shortest = 0;	
		//tracks the current best option
		long shortestLength = 9999;	
		//tracks the minimum length during loops
		long temp = 0;
		//If there's a fast lane, consider using it
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
		//Check all the regular lanes too
		for(int i = 0; i < queues.length; i++)
		{
			temp = base * queues[i].size();
			for(int j = 0; j < queues[i].size(); j++)
				temp += queues[i].itemAt(j);
			if(shortestLength > temp) 
			{
				shortest = i;
				shortestLength = temp;
			}
		}
		
		if(shortest == -1) 
			//if fast lane is best choice, add customer there and return
		{
			fastLane.insert(customer);
			System.out.println("Customer " + customer + " added to fast-lane.");
			
			//prevent process() from deleting new customer when queue is empty
			
			fastLane.justAdded = true;
		}
		else 
			//otherwise add the customer to the shortest regular line
		{
			queues[shortest].insert(customer);
			System.out.println("Customer " + customer + " added to line " + (shortest+1));
			
			//prevent process() from deleting new customer when queue is empty
			
			if(queues[shortest].runningTally <= 0)
				queues[shortest].justAdded = true;
		}
		
	}
	
	public void process(int time)	
	//pass a given amount of time and update queues
	{
		for(int i = 0; i < time; i++) 
			//do a bunch of operations for each time-tick
		{
			for(int j = 0; j < queues.length; j++) 
				//go through each queue and update
			{
				if(queues[j].runningTally <= 0) 
					//if cashier has finished customer
				{
					//remove front customer and get new one
					if(!queues[j].isEmpty() && !queues[j].justAdded) queues[j].remove();
					queues[j].runningTally = queues[j].peekFront();
				}
				else queues[j].runningTally--; 
				//decrement runningTally for each tick
				queues[j].justAdded = false;
				//after 1 tick, any new items can be processed
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
				//every tick, possibly generate new customer
				addCustomer();
		}
	}
	
	public void display()
	{
		for(int i = 0; i < queues.length; i++)
		{
			System.out.print("Line " + (i+1) + ": ");
			queues[i].display();
			System.out.println("   -Running Tally: " + queues[i].runningTally);
		}
		if(fastLane != null) 
		{
			System.out.print("Fast-Lane: ");
			fastLane.display();
			System.out.println("   -Running Tally: " + fastLane.runningTally);
		}
	}
	
	public void initialize()	
	//start with a bunch of random customers
	{
		for(int i = 0; i < queues.length; i++)
		{
			for(int j = 0; j < (Math.floor(Math.random() * 4)); j++)
			{
				queues[i].insert((long)(Math.ceil(Math.random() * 30)));
			}
			queues[i].runningTally = queues[i].peekFront(); 
			
			//get started on first customer
		}
		if(fastLane != null)
		{
			for(int j = 0; j < (Math.floor(Math.random() * 4)); j++)
			{
				fastLane.insert((long)(Math.ceil(Math.random() * 10)));
			}
			fastLane.runningTally = fastLane.peekFront(); 
			
			//get started on first customer
		}	
	}
}
		
class DequeTest
{
	public static void main(String[] args) throws IOException
	{
		String input;
		Checkout grocery = new Checkout(3, 20, true);
		
		//numQueues, queSize, fastlane
		
		grocery.initialize();
		grocery.display();
		
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
