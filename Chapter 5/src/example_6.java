class link {
	
	public long d_data;
	public link next;
	public link prev;
	
	public link(long dd)
	{
		d_data= dd;
	}
	public void display_link()
	{
		System.out.println(d_data +" ");
	}
}
@SuppressWarnings("unused")
class double_linked_list {
	private link first;
	private link last;
	
	public double_linked_list()
	{
		first = null;
		last = null;
	}
	public boolean is_empty()
	{
		return first == null;
	}
	public void insert_1(long dd)
	{
		link new_ln = new link(dd);
		if(is_empty())
			last = new_ln;
		else 
			first.prev = new_ln;
		new_ln.next = first;
		first = new_ln;
	}
	public void insert_last(long dd)
	{
		link new_ln = new link(dd);
		if(is_empty())
			first = new_ln;
		else
		{
			last.next = new_ln;
			new_ln.prev = last;
		}
		last  = new_ln;
	}
	public link delete_1()
	{
		link temp = first;
		if(first.next == null)
			last = null;
		else
			first.next.prev = null;
		first = first.next;
		return temp;
	}
	public link delete_last()
	{
		link temp = last;
		if(first.next == null)
			first = null;
		else
			last.prev.next = null;
		last = last.prev;
		return temp;
	}
	public boolean insert_after(long key , long dd)
	{
		link current = first;
		while(current.d_data != key)
		{
			current = current.next;
			if(current == null)
				return false;
		}
		link new_ln = new link(dd);
		if(current == last)
		{
			new_ln.next = null;
			last = new_ln;
		}
		else 
		{
			new_ln.next = current.next;
			current.next.prev = new_ln;
		}
		new_ln.prev = current;
		current.next = new_ln;
		return true;
	}
	public link delete_key(long key)
	{
		link current = first;
		while(current.d_data != key)
		{
			current = current.next;
			if(current == null)
				return null;
		}
		if(current == first)
			first = current.next;
		else
			current.prev.next = current.next;
		if(current == last)
			last = current.prev;
		else
			current.next.prev = current.prev;
		return current;
	}
	public void dispaly_forward()
	{
		System.out.print("List (first-->last): ");
		link current = first;
	
		while(current != null)
		{
		current.display_link();
		
		current = current.next;
		
		}
		System.out.println();
	}
	public void display_backward()
	{
		{
			System.out.print("List (last-->first): ");
			link current = last;
	
			while(current != null)
			{
			current.display_link();
	
			current = current.prev;
			}
			System.out.println();
	}
}

public class example_6 
{
	public static void main(String args[])
	{
		example_6 list= new example_6();
		
	}
}
