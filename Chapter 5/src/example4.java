class link
{
	public long d_data;
	public link next;
	
	public link(long d_d)
	{
		d_data=d_d;
	}
	public void display()
	{
		System.out.println(d_data + " ");
	}
}
class link_list
{
	private link first;
	
	public link_list()
	{
		first = null;
	}
	public boolean is_empty()
	{
		return first == null;
	}
	public void insert_frst(long d_d)
	{
		link new_ln = new link(d_d);
		new_ln.next = first;
		first = new_ln;
	}
	public long delete_frst()
	{
		link temp = first;
		first = first.next;
		return temp.d_data;
	}
	public void dispaly_list()
	{
		link current = first;
		while(current != null)
		{
			current.display();
			current = current.next;
		}
		//System.out.println();
	}
}
class link_stack {
	
	private link_list thelist;
	
	public link_stack()
	{
		thelist = new link_list();
	}
	public void push(long j)
	{
		thelist.insert_frst(j);
	}
	public long pop()
	{
		return thelist.delete_frst();
	}
	public boolean is_empty()
	{
		return thelist.is_empty();
	}
	public void dispaly_stack()
	{
		System.out.println();
		System.out.println("Stack (top ---> bottom): ");
		System.out.println();
		thelist.dispaly_list();
	}
}
public class example4
{
	
	public static void main(String args[])
	{
		link_stack stack = new link_stack();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.dispaly_stack();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.dispaly_stack();
		stack.push(50);
		stack.push(60);
		stack.push(70);
		stack.push(80);
		stack.dispaly_stack();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.dispaly_stack();
	}
}

