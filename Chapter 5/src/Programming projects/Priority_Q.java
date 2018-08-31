package Chapter5;
class Q_link
{
	public long d_data;
	public Q_link next;
	
	public Q_link (long dd)
	{ d_data = dd; }
	
	public void display()
	{
		System.out.print(d_data + " ");
	}
		
}

class sorted_list
{
	private Q_link first;
	
	public sorted_list()
	{
		first = null;
	}
	
	public boolean is_empty()
	{
		return first == null;
	}
	
	public void insert(long key)
	{
		Q_link new_ln = new Q_link(key);
		Q_link prev= null;
		Q_link curr = first;
		while(curr != null && key > curr.d_data)
		{
			prev = curr;
			curr = curr.next;
		}
		if(prev == null)
			first = new_ln;
		else
			prev.next = new_ln;
		new_ln.next = curr;
	}
	
	public Q_link remove()
	{
		Q_link temp = first;
		first = first.next;
		return temp;
	}
	
	public void display_list()
	{
		System.out.print("List (first ----> last): ");
		Q_link curr = first;
		while(curr != null)
		{
			curr.display();
			curr = curr.next;
		}
		System.out.println();
	}
	
	public long get_fisrt()
	{
		return first.d_data;
	}
}

class PR_Q
{
	sorted_list q_list;
	
	public PR_Q()
	{
		q_list = new sorted_list();
	}
	
	public void insert(long val)
	{
		q_list.insert(val);
	}
	
	public Q_link remove()
	{
		if(q_list.is_empty())
		{
			System.out.println("Queue is empty");
			return null;
		}
		return q_list.remove();
	}
	
	public long peek_min()
	{
		return q_list.get_fisrt(); 
	}
	
	public boolean is_empty()
	{
		return q_list.is_empty();
	}
	
	public void display_Q()
	{
		System.out.println();
		System.out.println("Sorted form is :- \n");
		q_list.display_list();
	}
}
public class Priority_Q {
	
	public static void main (String args[])
	{
		PR_Q mQ = new PR_Q();
		mQ.insert(99);
		mQ.insert(66);
		mQ.insert(77);
		mQ.insert(55);
		mQ.insert(44);
		mQ.insert(11);
		mQ.insert(88);
		mQ.display_Q();
		System.out.println();
		System.out.println("Mininum is : "+mQ.peek_min());
		mQ.remove();
		System.out.println();
		System.out.println("Mininum is : "+mQ.peek_min());
		mQ.remove();
		mQ.display_Q();
	}

}
