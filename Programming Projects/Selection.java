package chapter7;
class Selection extends arrPartition
{
	protected int middleCell;
	
	public Selection(int max)
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
	
	public long findIndex(int left, int right, int index)
	{
		if(right-left <= 0) return theArr[index];
		else
		{
			int partition = partitionIt3(left, right);
			if(partition == index) return theArr[index];
			else if(partition < index) return findIndex(partition+1, right, index);
			else return findIndex(left, partition-1, index);
		}
	}
	
	public static void main(String[] args)
	{
		Selection arr = new Selection(31);
		for(int i = 0; i < 20; i++) arr.insert((long)(Math.random()*100));
		
		arr.display();
		int k = 1;
		long selection = arr.findIndex(0, arr.size()-1, k);
		arr.display();
		System.out.println((k+1) + "th smallest number: " + selection);
	}
}