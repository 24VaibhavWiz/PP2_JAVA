package chapter7;

class Partition extends arrPartition
{
	public Partition(int max)
	{
		super(max);
	}
	
	public int size() {return items;}
	
	public int partitionIt3(int left, int right)
	{
		int leftPtr = left - 1;
		int rightPtr = right;
		if(rightPtr - leftPtr <= 0)
		{
			System.out.println("Sub-array too small to sort");
			return -1;
		}
		long pivot = theArr[right];
		System.out.println("Pivot = " + pivot);
		
		
		while(true)
		{
			while(leftPtr < right && theArr[++leftPtr] < pivot);
			while(rightPtr > left && theArr[--rightPtr] > pivot);
			if(leftPtr >= rightPtr) break;
			else swap(leftPtr, rightPtr);
		}
		swap(leftPtr, right);
		return leftPtr;
	}
	
	public static void main(String[] args)
	{
		int maxSize = 20;
		Partition arr = new Partition(maxSize);
		for(int i = 0; i < maxSize; i++) arr.insert((long)(Math.random()*99));
		arr.display();
		arr.partitionIt3(0, maxSize-1);
		arr.display();
	}
}
