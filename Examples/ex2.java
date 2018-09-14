package chapter7;

class arrPartition
{
	private long[] theArr;
	private int items;

	public arrPartition(int max)
	{
		theArr = new long[max];
		items = 0;
	}
	
	public void insert(long n)
	{
		theArr[items] = n;
		items++;
	}
	
	public int size()
	{
		return items;
	}
	
	public void display()
	{
		for (int i = 0; i < items; i++) 
			System.out.println(theArr[i] + " ");
		System.out.println(); 
	}
	
	public void swap(int x, int y)
	{
		long temp = theArr[x];
		theArr[x] = theArr[y];
		theArr[y] = temp;
	}
	
	public int partition(int left, int right, long pivot)
	{
		int leftPtr = left - 1;
		int rightPtr = right + 1;
		System.out.println("After Implementing Partition Sort");
		System.out.println();
		while(true)
		{
			while(leftPtr < right&& theArr[++leftPtr] < pivot)
			{
				while(rightPtr < left && theArr[--rightPtr] > pivot)
					if(leftPtr >= rightPtr)
						break;
					else
						swap(leftPtr,rightPtr);
			}
		}
	}
}

public class ex2 {

	public void main(String args[])
	{
		int max = 20;
		long pivot = 99;
		arrPartition arr = new arrPartition(max);
		for (int i = 0; i < max; i++) {
			long n = (int)(java.lang.Math.random()*99);
			arr.insert(n);
		}
		arr.display();
		int partIndex = arr.partition(0, max-1, pivot);
		System.out.println("Given Pivot \n: " +pivot);
		System.out.println("Partion index \n: " +partIndex);
		arr.display();
	}
}
