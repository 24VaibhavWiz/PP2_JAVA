package Chapter5;
class Josephus
{
	private CLinkedList theList;
	private int count;
	private int people;
	
	public Josephus(int nPeople, int nCount, int startPoint)
	{
		theList = new CLinkedList();
		count = nCount;
		people = nPeople;
		
		for(int i = 1; i <= nPeople; i++)
		{
			theList.insert(i);
			theList.step();
		}
		
		theList.step();		
		
		for(int i = 1; i < startPoint; i++)
		{
			theList.step();
		}
	}
	
	private void display()
	{
		theList.display();
	}
	
	private CLink kill()
	{
		for(int i =0 ; i < count-1; i++) 
		{
			theList.step();
		}
		CLink temp = theList.delete();
		System.out.println();
		System.out.println("Killed # " + temp.lData);
		System.out.println();
		theList.step();
		return temp;
	}
	
	public CLink execute()	
	{
		CLink temp = new CLink(0);
		for(int i = 0; i < people-1; i++)
		{
			display();
			temp = kill();
		}	
		System.out.println("Last person left is #" + temp.next.lData);
		return temp;
	}
}

public class Joshep_App
{
	public static void main(String[] args)
	{
		Josephus trial = new Josephus(10, 2, 1);
		trial.execute();
	}
}