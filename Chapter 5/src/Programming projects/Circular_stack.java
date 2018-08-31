package Chapter5;
import java.util.EmptyStackException;

class CStack
{
	private CLinkedList theList;
	
	public CStack()
	{
		theList = new CLinkedList();
		theList.insert(-1);	
	}
	
	public void push(long value)
	{
		theList.insert(value);
	}
	
	public long pop()
	{
		if(theList.getItems() == 1)
		{
			System.out.println("Stack is empty.");
			throw new EmptyStackException();
		}
		else
		{
			return theList.delete().lData;
		}
	}
	
	public long peek()
	{
		return theList.peek().lData;
	}
	
	public void display()
	{
		
	}
}

public class Circular_stack
{
	public static void main(String[] args)
	{
		CStack theStack = new CStack();
		theStack.push(22);
		theStack.push(55);
		theStack.push(88);
		theStack.push(33);
		theStack.push(99);
		System.out.println("Poped  elemets are ");
		System.out.println(theStack.pop());
		System.out.println(theStack.pop());
		System.out.println(theStack.pop());
		System.out.println(theStack.pop());
		
	}
}