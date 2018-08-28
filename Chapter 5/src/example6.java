class Link
{
	public long dData;
	public Link next;

	public Link(long dd)
		{ dData = dd; }
	public void displayLink()
		{ System.out.print(dData + " "); }

} 
class SortedList
{
	private Link first;
	public SortedList()
		{ first = null; }
	public boolean isEmpty()
		{ return (first==null); }
	public void insert(long key)
	{
		Link newLink = new Link(key);
		Link previous = null;
		Link current = first;
		while(current != null && key > current.dData)
		{
			previous = current;
			current = current.next;
		}
		if(previous==null)
			first = newLink;
		else
			previous.next = newLink;
		newLink.next = current;
	} 
	public Link remove()
	{
		Link temp = first;
		first = first.next;
		return temp;
	}

	public void displayList()
	{
		System.out.println();
		System.out.print("List ( first ---> last): ");
		Link current = first;	
		while(current != null)
		{
			current.displayLink();
			current = current.next;
		}
		System.out.println();
	}
} 
class example6
{
	public static void main(String[] args)
	{
		SortedList theSortedList = new SortedList();
		theSortedList.insert(20);
		theSortedList.insert(40);
		theSortedList.insert(60);
		theSortedList.insert(50);
		theSortedList.displayList(); 
		theSortedList.insert(10);
		theSortedList.insert(30);
		theSortedList.insert(70);
		theSortedList.insert(80);
		theSortedList.insert(90);
		theSortedList.displayList();
		theSortedList.remove();
		theSortedList.remove();
		theSortedList.displayList();
		System.out.println();
	}
}
