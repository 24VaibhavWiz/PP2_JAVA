package Chapter5;
class CLink
{
	public long lData;
	public CLink next;
	
	public CLink(long value)
	{ lData = value; }
	
	public void displayLink()
	{ System.out.print(lData + " "); }
}

class CLinkedList
{
	private CLink current;
	private int nItems; 
	
	public CLinkedList()
	{
		current = null;
		nItems = 0;
	}
	
	public boolean isEmpty() 
	{ return current==null; }
	
	public long getItems()
	{ return nItems; }
	
	public void step()
	{
		current = current.next;
	}
	
	public void insert(long value)	
	{
		if(isEmpty())
		{
			current = new CLink(value);
			current.next = current;
		}
		else
		{
			CLink newLink = new CLink(value);
			newLink.next = current.next;
			current.next = newLink;
		}
		nItems++;
	}
	
	public CLink find(long value)
	{
		for(int i = 0; i < nItems; i++)
		{
			if(current.lData == value) 
			{
				System.out.println("Found " + value);
				return current;
			}
			else step();
		}
		System.out.println("Couldn't find " + value + ".");
		return null;
	}
	
	public CLink delete()
	{
		if(isEmpty())
		{
			System.out.println("List is empty.");
			return null;
		}
		else if(nItems == 1)
		{
			current = null;
			nItems = 0;
			return null;
		}
		else
		{
			CLink temp = current.next.next;
			current.next.next = current.next.next.next;
			nItems--;
			return temp;
		}
	}
	
	public CLink peek()
	{
		return current;
	}
	
	public void display()
	{
		System.out.print("Circular List (from current): ");
		CLink index = current;
		for(int i = 0; i < nItems; i++)
		{
			System.out.print(index.lData + " ");
			index = index.next;
		}
		System.out.println();
	}
}

public class Circular_Q
{
	public static void main(String[] args)
	{
		CLinkedList theList = new CLinkedList();
		
		theList.insert(10);
		theList.insert(22);
		theList.insert(33);
		theList.insert(44);
		theList.insert(11);
		theList.insert(28);
		theList.insert(36);
		theList.insert(44);
		theList.display();
		theList.find(33);
		theList.delete();
		theList.display();
		theList.delete();
		theList.display();
		
	}
}
