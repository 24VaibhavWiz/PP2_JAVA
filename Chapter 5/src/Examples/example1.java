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
	public Link del_1()
	{
		Link temp = first;
		first = first.next;
		return temp;
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
public class example1 {
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
		while(!lnk.is_empty())
		{
			Link ln = lnk.del_1();
			System.out.println();
			System.out.print("Deleted : ");
			ln.display();
			System.out.println();
		}
		System.out.println();
		lnk.dispalyList();
	}
}
