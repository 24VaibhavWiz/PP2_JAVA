class Link{
	public int i_data;
	public double d_data;
	public Link next;
	
	public Link(int id,double dd)
	{
		i_data = id;
		d_data = dd;
	}
	public void display()
	{
		System.out.print("{" + i_data + ", " + d_data + "} ");
	}
}
class Linked_List {
	private Link first;
	public Linked_List()
	{
		first = null;
	}
	public boolean is_empty()
	{
		return (first == null);
	}
	public void ins_1(int id, double dd)
	{
		Link new_link = new Link(id, dd);
		new_link.next = first;
		first = new_link;
	}
	public Link search(int key)
	{
		Link current =  first;
		while(current.i_data != key)
		{
			if(current.next ==null)
				return null;
			else 
				current = current.next;
		}
		return current;
	}
	public Link delete(int key)
	{
		Link current = first;
		Link previous = first;
		while(current.i_data != key)
		{
			if(current.next == null)
				return null;
			else
			{
				previous= current;
				current = current.next;
			}
		}
		if(current == first)
			first= first.next;
		else
			previous.next = current.next;
		return current;
	}
	public void dispalyList()
	{
		System.out.println("List (first--->last): ");
		System.out.println();
		Link current = first;
		while(current != null)
		{
			current.display();
			current = current.next;
		}
		System.out.println();
	}
}
public class example2 {
	public static void main( String args[])
	{
		Linked_List lnk = new Linked_List();
		lnk.ins_1(22, 44.44);
		lnk.ins_1(23, 47.44);
		lnk.ins_1(292, 49.44);
		lnk.ins_1(222, 48.44);
		lnk.ins_1(122, 43.44);
		lnk.ins_1(212, 64.44);
		lnk.ins_1(224, 84.44);
		lnk.ins_1(232, 94.44);
		lnk.dispalyList();
		Link srch = lnk.search(22);
		if(srch != null)
			System.out.println("Found Link with key  : " + srch.i_data + "and a Decimal value of : " + srch.d_data);
		else
			System.out.println("Searched Link not found");
		Link del = lnk.delete(292);
		if(del !=  null)
			System.out.println("Deleted Link with key : " + del.i_data + "and a Decimal value of : " + srch.d_data);
		else
			System.out.println("Cannot be deleted, link not found ");
		lnk.dispalyList();
	}
}