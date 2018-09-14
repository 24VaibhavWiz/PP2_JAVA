package chapter7;
class Radix
{
	private DQLL[] theList;
	private int base;
	
	public Radix()
	{
		base = 10;
		theList = new DQLL[base];
		for(int i = 0; i < base; i++)
			theList[i] = new DQLL();
	}
	
	public void sortIt(long[] arr, int numDigits)
	{
		for(int i = 0; i < numDigits; i++)
		{
			for(int j = 0; j < arr.length; j++)
			{
				long temp = arr[j];
				for(int k = 0; k < i; k++) temp /= base;
				temp %= base;
				theList[(int)temp].insertLeft(arr[j]);
			}
			
			int arrayCounter = 0;
			for(int m = 0; m < base; m++)
			{
				
				while(!theList[m].isEmpty()) 
				{
					arr[arrayCounter] = theList[m].removeRight();
					arrayCounter++;
				}
			}
		}
	}
	
	public static void main(String[] args)
	{
		int size = 15;
		long[] arr = new long[size];
		for(int i = 0; i < size; i++)
			arr[i] = (long)(Math.random()*199)+100;
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
		Radix sorter = new Radix();
		sorter.sortIt(arr, 3);
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}	
}