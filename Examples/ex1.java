package chapter7;

class ArraySlSrt {
	private long[] theArr;
	private int items;

	public ArraySlSrt(int max)
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
		System.out.print("A = " );
		for (int i = 0; i < items; i++) 
			System.out.print(theArr[i] + " ");
		System.out.println();
	}
	
	public void ShellSort()
	{
		int inner,outer;
		long temp;
		int  h =1;
		while(h <= items/3)
			h = (h*3)+1;
		while(h > 0)
		{
			for (outer = 0; outer < items; outer++) {
				temp = theArr[outer];
				inner = outer;
				
				while(inner > h-1 && theArr[inner-h] >= temp)
				{
					theArr[inner] = theArr[inner-h];
					inner -= h;
				}
				theArr[inner] = temp;
			}
			h = (h-1)/3;
		}
		System.out.println();
		System.out.println("After Implementing Shell Sort");
	}
}

public class ex1
{
	public static void main(String args[])
	{
		int max = 20;
		ArraySlSrt arr = new ArraySlSrt(max);
		for (int i = 0; i < max; i++) {
			long n = (int)(java.lang.Math.random()*99);
			arr.insert(n);
		}
		arr.display();
		arr.ShellSort();
		System.out.println();
		arr.display();
	}
}