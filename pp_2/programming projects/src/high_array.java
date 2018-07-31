import java.util.*;
class higharray
{
	int[] a;
	int size=0,i,pos,max;
	public higharray(int maxSize)
	{
		a = new int[maxSize];	
	}
	public void insert(int ele)
	{
		a[size] = ele;
		size++;
	}
	public void display()
	{
		for(i=0;i<size;i++)
		{
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	public int find(int flag)
	{
		for(i=0;i<size;i++)
		{
			if(a[i]==flag)
			{
				pos = i;
				break;
			}
		}
		if(i==size)
		{
			return -1;
		}
		else
		{
			return pos;
		}
	}
	public void delete(int pos)
	{
		for(i=pos;i<size-1;i++)
		{
			a[i] = a[i+1];
		}
		size--;	
	}
	public int getMax()
	{
		if(size==0)
		{
			return -1;
		}
		else
		{
			max = a[0];
			for(i=1;i<size;i++)
			{
				if(a[i] > max)
				{
					max = a[i];
				}
			}
			return max;
		}
	}
	public int removeMax()
	{
		int x = getMax();
		int posmax = find(x);
		delete(posmax);
		return(x);
	}
/*  
   public int removeDuplicates(int arr[], int n)
    {
        if (n==0 || n==1)
            return n;
        int[] temp = new int[n];
        int j = 0;
        for (int i=0; i<n-1; i++)
            if (arr[i] != arr[i+1])
                temp[j++] = arr[i];
        temp[j++] = arr[n-1];   
        for (int i=0; i<j; i++)
            arr[i] = temp[i];
        return j;
    }
*/

}
class high_array
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int maxSize = 100;
		int flag,i,size,n;
		higharray ob = new higharray(maxSize);
		higharray ob1 = new higharray(maxSize);
		ob.insert(100);
		ob.insert(122);
		ob.insert(114);
		ob.insert(138);
		ob.insert(149);
		ob.insert(99);
		ob.insert(150);
		ob.insert(111);
		ob.insert(86);
		ob.insert(79);
		ob.insert(1);
		ob.insert(70);
		ob.insert(222);
		ob.insert(126);
		ob.display();
		System.out.println("");
		System.out.println("Enter the search element: ");
		flag = sc.nextInt();
		if(ob.find(flag)==-1)
		{
			System.out.println("");
			System.out.println(flag+" not found");
		}
		else
		{
			System.out.println("");
			System.out.println(flag+" found at position "+ob.find(flag));
		}
		if(ob.find(flag)!=-1)
		{
			ob.delete(ob.find(flag));
			System.out.println("");
			System.out.println("Elements after deletion: ");
			System.out.println("");
			ob.display();
		}
		int max = ob.getMax();
		if(max == -1)
		{
			System.out.println("");
			System.out.println("Array empty.");
		}
		else
		{
			System.out.println("");
			System.out.println("Maximum element is : "+max);
		}
		int x=ob.removeMax();
		ob1.insert(x);
		System.out.println("");
	    System.out.println("Elements after deleting max is:");
	    System.out.println("");
		ob.display();
		while((x=ob.removeMax())!=-1)
		{
			ob1.insert(x);
		}
		System.out.println("");
		System.out.println("Reversed sorted array is:");
		System.out.println("");
		ob1.display();
		System.out.println("");
		/*
        System.out.println("Before removing duplicates");
        System.out.println("");
        ob1.display(); 
        System.out.println("After removing duplicates");
        ob1.removeDuplicates(null,maxSize);
        ob1.display();
        */
	}
}
	
