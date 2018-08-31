class link
{
	public long d_data;
	public link next;
	
	public link(long dd)
	{
		d_data = dd;
	}
	public void display_list()
	{
		System.out.println(d_data + " ");
	}
}
class F_L_list
{
	private link first;
	private link last;
	
	public F_L_list()
	{
		first = null;
		last = null;
	}
	public boolean is_empty()
	{
		return first == null;
	}
	public void insert_last(long dd)
	{
		link new_ln = new link(dd);
		if(is_empty())
			first = new_ln;
		else
			last.next = new_ln;
		last = new_ln;
	}
	public long delete_frst()
	{
		long temp = first.d_data;
		if(first.next == null)
			last = null;
		first = first.next;
		return temp;
	}
	public void dispaly()
	{
		link current = first;
		while(current != null)
		{
			current.display_list();
			current = current.next;
		}
		System.out.println();
	}
}
class Link {
	private F_L_list list;
	
	public Link()
	{
		list = new F_L_list();
	}
	public boolean is_empty()
	{
		return list.is_empty();
	}
	public void insert(long j)
	{
		list.insert_last(j);
	}
	public long remove()
	{
		return list.delete_frst();
	}
	public void display_Q()
	{
		System.out.println();
		System.out.println("Queue (front ---> rear): ");
		list.dispaly();
	}
}
public class example5 {
	public static void main (String args[])
	{
		Link ln_Q = new Link();
		ln_Q.insert(10);
		ln_Q.insert(9);
		ln_Q.insert(8);
		ln_Q.insert(7);
		ln_Q.insert(6);
		ln_Q.insert(5);
		ln_Q.display_Q();
		ln_Q.remove();
		ln_Q.remove();
		ln_Q.remove();
		ln_Q.remove();
		ln_Q.remove();
		ln_Q.display_Q();
		ln_Q.insert(4);
		ln_Q.insert(3);
		ln_Q.insert(2);
		ln_Q.insert(1);
		ln_Q.display_Q();
	}
}

