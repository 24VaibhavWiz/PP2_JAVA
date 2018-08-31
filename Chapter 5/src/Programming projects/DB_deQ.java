package Chapter5;
class DLink
{
	public long lData;
	public DLink next;
	public DLink previous;
	
	public DLink(long value)
	{ lData = value; }
	
	public void displayLink()
	{ System.out.print(lData + " "); }
}

class DoublyLinkedList
{
	private DLink front;
	private DLink back;
	
	public DoublyLinkedList()
	{
		front = null;
		back = null;
	}
	
	public boolean isEmpty()
	{ return (front==null); }
	
	public DLink peekFirst()
	{ return front; }
	
	public DLink peekLast()
	{ return back; }
	
	public void insertFirst(long value)
	{
		DLink newLink = new DLink(value);
		
		if(isEmpty()) 
			back = newLink;
		else
			front.previous = newLink;
		newLink.next = front;
		front = newLink;
	}
	
	public void insertLast(long value)
	{
		DLink newLink = new DLink(value);
		
		if(isEmpty())
			front = newLink;
		else
		{
			back.next = newLink;
			newLink.previous = back;
		}
		back = newLink;
	}
	
	public DLink deleteFirst()
	{
		DLink temp = front;
		if(front.next == null)
			back = null;
		else
			front.next.previous = null;
		front = front.next;
		return temp;
	}
	
	public DLink deleteLast()
	{
		DLink temp = back;
		if(back.previous == null)
			front = null;
		else
			back.previous.next = null;
		back = back.previous;
		return temp;
	}
	
	public boolean insertAfter(long key, long value)
	{
		DLink current = front;
		while(current.lData != key)
		{
			current = current.next;
			if(current == null)
				return false;
		}
		DLink newLink = new DLink(value);
		
		if(current==back)
		{
			newLink.next = null;
			back = newLink;
		}
		else
		{
			newLink.next = current.next;
			current.next.previous = newLink;
		}
		current.next = newLink;
		newLink.previous = current;
		return true;
	}
	
	public DLink deleteKey(long value)
	{
		DLink current = front;
		while(current.lData != value)
		{
			current = current.next;
			if(current == null)
			{
				System.out.println("Couldn't find " + value + ".");
				return null;
			}
			
		}
		if(current==front)
			front = current.next;
		else
			current.previous.next = current.next;
		if(current==back)
			back = current.previous;
		else
			current.next.previous = current.previous;
		return current;
	}
	
	public void displayForward()
	{
		DLink current = front;
		System.out.print("List (first-->last): ");
		while(current != null)
		{
			System.out.print(current.lData + " ");
			current = current.next;
		}
		System.out.println();
	}
	
	public void displayBackward()
	{
		DLink current = back;
		System.out.print("List (last--->first): ");
		while(current != null)
		{
			System.out.print(current.lData + " ");
			current = current.previous;
		}
		System.out.println();
	}
}

class DequeLL	
{
	private DoublyLinkedList theList;
	
	public DequeLL()
	{ theList = new DoublyLinkedList(); }
	
	public long peekLeft()
	{
		System.out.println();
		return theList.peekFirst().lData; }
	
	public long peekRight()
	{ 
		System.out.println();
		return theList.peekLast().lData; }
	
	public void insertLeft(long value)
	{ theList.insertFirst(value);}
	
	
	public long removeLeft()
	{ return theList.deleteFirst().lData;}
	
	public void insertRight(long value)
	{ theList.insertLast(value); }
	
	public long removeRight()
	{ return theList.deleteLast().lData; }
	
	public boolean isEmpty()
	{ return theList.isEmpty(); }
	
	public void display_forward()
	{
		System.out.println();
		theList.displayForward(); 
		System.out.println();
	}
	
	public void display_backward()
	{ 
		System.out.println();
		System.out.println();
		theList.displayBackward();
	}
}

public class DB_deQ
{
	public static void main(String[] args)
	{
		DequeLL deque = new DequeLL();
		deque.insertLeft(99);
		deque.insertLeft(55);
		deque.insertLeft(77);
		deque.insertRight(33);
		deque.insertRight(88);
		deque.insertRight(11);
		deque.display_forward();
	
		System.out.println("Peek right: "+ deque.peekRight());
		
		System.out.println("Peek left: " + deque.peekLeft());
		
		deque.removeLeft();
		System.out.println("Peek left: " + deque.peekLeft());
		deque.removeRight();
		deque.removeRight();
		deque.insertRight(125);
		System.out.println("Peek right: "+deque.peekRight());
		
		deque.display_forward();
		System.out.println("Reverse order");
		deque.display_backward();
	}
}
