class ArrayBub
{
	private long[] a;
	private int nElems;
	public ArrayBub(int max)
	{
		a = new long[max];
		nElems = 0;
	}
	public void insert(long value)
	{
		a[nElems] = value;	
		nElems++;
	}
	public void display()
	{
		for(int j=0; j<nElems; j++)
		System.out.print(a[j] + " ");
		System.out.println("");
	}
	public void insertionSort()
	{
		int in, out;
		for(out=1; out<nElems; out++)
		{
			long temp = a[out];
			in = out;
			while(in>0 && a[in-1] >= temp)
			{
				a[in] = a[in-1];
				--in;
				a[in] = temp;

			}
		}
	}
	static int removeDuplicates(int arr[], int nElems)
	{
	     if (nElems==0 || nElems==1)
	            return nElems;
	        int[] temp = new int[nElems];
	        int j = 0;
	        for (int i=0; i<nElems-1; i++)
	            if (arr[i] != arr[i+1])
	                temp[j++] = arr[i];
	        temp[j++] = arr[nElems-1];   
	        for (int i=0; i<j; i++)
	            arr[i] = temp[i];
	        return j;
	 } 	
	
	private void swap(int one, int two)
	{
		long temp = a[one];
		a[one] = a[two];
		a[two] = temp;
	}
		
} 
public class ins
{
	public static void main(String[] args)
	{
		int maxSize = 100;
		ArrayBub arr;
		System.out.println("");
		System.out.println("*_______USING INSERTION SORT_______*");
		System.out.println("");
		arr = new ArrayBub(maxSize);
		arr.insert(9);
		arr.insert(39);
		arr.insert(19);
		arr.insert(49);
		arr.insert(89);
		arr.insert(79);
		arr.insert(29);
		arr.insert(99);
		arr.insert(59);
		arr.insert(69);
		arr.display();
		arr.insertionSort();
		arr.removeDuplicates(arr,maxSize);
		arr.display();
	}
}
