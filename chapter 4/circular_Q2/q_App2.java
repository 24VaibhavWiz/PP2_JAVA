class q
{
	private int maxSize;
	private long[] queArray;
	private int front;
	private int rear;
	private int nItems;
	public q(int s)
	{
		maxSize = s;
		queArray = new long[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
	}
	public void insert(long j)
	{
		if(isFull())
			System.out.println("queue is full");
		if(rear == maxSize-1)
		rear = -1;
		queArray[++rear] = j;
		nItems++;
	}
	public long remove()
	{
		if(isEmpty())
				System.out.println("queue is empty");
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

	public boolean isEmpty()
	{
		return (nItems==0);
	}

	public boolean isFull()
	{
		return (nItems==maxSize);
	}

	public int size()
	{
		return nItems;
	}
    public void display()
    {
        System.out.print("Queue = ");
        if (nItems == 0)
        {
            System.out.println();
            return ;
        }
        for (int i = front; i <= rear; i++)
            System.out.print(queArray[i]+" ");
        System.out.println();
        /* 
         * Display in Reverse order
        for (int i = rear; i >= front; i--)
            System.out.print(queArray[i]+" ");
        System.out.println();
        */
    }
} 
public class q_App2
{
	public static void main(String[] args)
	{
		q theQueue = new q(10); 
		theQueue.insert(10);
		theQueue.insert(20);
		theQueue.insert(30);
		theQueue.insert(40);
		theQueue.display();
		theQueue.remove();
		theQueue.remove();
		theQueue.remove(); 
		theQueue.display();
		theQueue.insert(99);
		theQueue.insert(50);
		theQueue.insert(60);
		theQueue.insert(70);
		theQueue.insert(80);
		theQueue.display();
		theQueue.remove();
		theQueue.display();
	}
} 