package chapter6;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex1 {

	static int num;
	
	public static void main(String args[]) throws IOException
	{
		System.out.println("Enter a number of your choice : ");
		num = getInt();
		int ans = triangle(num);
		System.out.println("Triangle : " + ans);
	}
	
	public static int triangle(int n)
	{
		System.out.println("Entering n = " + n);
		System.out.println();
		if(n==1)
		{
			System.out.println("Returning 1");
			System.out.println();
			return 1;
		}
		else 
		{
			int temp = (n+ triangle(n-1));
			System.out.println("Returning " + temp);
			System.out.println();
			return temp;
		}
	}
	
	public static String getStr() throws IOException
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br  = new BufferedReader(isr);
		String str = br.readLine();
		return str;
	}
	
	public static int getInt() throws IOException
	{
		String str = getStr();
		return Integer.parseInt(str);
	}
}
