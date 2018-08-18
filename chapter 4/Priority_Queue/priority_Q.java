class prty_Q {
private int maxSize;
private long[] q_arr;
private int n_items;


	public prty_Q(int s)
	{
		maxSize=s;
		q_arr = new long[maxSize];
		n_items=0;
	}
	public void insert(long item)
	{
		if(n_items==0)
			q_arr[n_items++]=item;
		else
		{
			for (int i = n_items-1; i >=0 ; i--) {
				{
					if(item > q_arr[i])
						q_arr[i+1]=q_arr[i];
					else
						break;
				}
				q_arr[i+1]=item;
				n_items++;
			}
		}
	}
		public long remove()
		{
			return q_arr[--n_items];
		}
		public long peek_mn()
		{
			return q_arr[n_items-1];
		}
		public boolean is_empty()
		{
			return n_items==0;
		}
		public boolean is_full()
		{
			return n_items==maxSize;
		}
}
public class priority_Q
{
	public static void main(String[]args)
	{
		 prty_Q prq=new prty_Q(10);
		 prq.insert(99);
		 prq.insert(88);
		 prq.insert(77);
		 prq.insert(66);
		 prq.insert(55);
		 prq.insert(44);

			while(!prq.is_empty())
			{
				long item = prq.remove();
				System.out.print(item + " ");
			}
			System.out.println();
	}
}

