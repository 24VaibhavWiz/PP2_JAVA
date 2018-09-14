package chapter7;
class Median extends arrPartition
{
	protected int middleCell;
	
	public Median(int max)
	{
		super(max);
		middleCell = 0;
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
	
	public long findMedian(int left, int right)
	{
		if(right-left <= 0) return theArr[middleCell];
		else
		{
			int partition = partitionIt3(left, right);
			if(partition == middleCell) return theArr[middleCell];
			else if(partition < middleCell) return findMedian(partition+1, right);
			else return findMedian(left, partition-1);
		}
	}
	
	public static void main(String[] args)
	{
		Median arr = new Median(31);
		for(int i = 0; i < 31; i++) arr.insert((long)(Math.random()*100));
		arr.display();
		arr.middleCell = arr.size()/2;
		long median = arr.findMedian(0, arr.size()-1);
		arr.display();
		System.out.println("Me"+ "dian: " + median);
	}
}
