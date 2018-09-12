package chapter6;
class Array{
	
	private long[] theArr;
	private int items;
	
	public Array(int max)
	{
		theArr = new long[max];
		items = 0;
	}
	
	public void insert(long val)
	{
		theArr[items] = val;
		items++;
	}
	
	public void display()
	{
		for (int i = 0; i < items ; i++) 
			System.out.print(theArr[i] + " ");
		System.out.println();
		System.out.println();
	}
	
	public void mergeSort()
	{
		long[] wrkSpace = new long[items];
		System.out.println("After Merge Sorting :-");
		System.out.println();
		recMergeSort(wrkSpace,0,items-1);
	}
	
	private void recMergeSort(long[] wrkSpace,int lowBound,int upperBound)
	{
		if(lowBound == upperBound)
			return;
		else
		{
			int mid = (lowBound + upperBound) /2;
			recMergeSort(wrkSpace, lowBound, mid);
			recMergeSort(wrkSpace, mid+1, upperBound);
			merge(wrkSpace, lowBound, mid+1, upperBound);
		}
	}
					
		private void merge(long[] wrkSpace, int lowPtr, int highPtr, int upperBound)
		{
			int i = 0;
			int lowerBound = lowPtr;
			int mid = highPtr -1;
			int n = upperBound - lowerBound+1;
			while(lowPtr <= mid && highPtr <= upperBound)
				if(theArr[lowPtr] < theArr[highPtr])
					wrkSpace[i++] = theArr[lowPtr++];
				else
					wrkSpace[i++] = theArr[highPtr++];
			while(lowPtr <= mid)
				wrkSpace[i++] = theArr[lowPtr++];
			while(highPtr <= upperBound)
				wrkSpace[i++] = theArr[highPtr++];
			
			for ( i = 0; i < n; i++) 
				theArr[lowerBound+i] = wrkSpace[i];
		}
	}
public class ex5 {

	public static void main(String args[])
	{
		Array arr = new Array(100);
		arr.insert(99);
		arr.insert(55);
		arr.insert(11);
		arr.insert(0);
		arr.insert(77);
		arr.insert(33);
		arr.insert(44);
		arr.insert(88);
		arr.insert(69);
		arr.insert(8);
		arr.insert(9);
		arr.insert(10);
		arr.insert(34);
		arr.insert(90);
		arr.insert(96);
		arr.insert(3);
		arr.insert(5);
		arr.insert(88);
		arr.insert(22);
		arr.display();
		arr.mergeSort();
		arr.display();
	}
}
