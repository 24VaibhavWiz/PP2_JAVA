package chapter6;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex2 {
	
	static int size;
	static int count;
	static char [] arrChar = new char[100];

	public static void main(String args[]) throws IOException
	{
		System.out.print("Enter a word : ");
		String input = getStr();
		size = input.length();
		count = 0;
		for (int i = 0; i < size; i++) 
			arrChar[i]= input.charAt(i);
		doAnagram(size);
	}
	
	public static void doAnagram(int size2)
	{
		if(size2 == 1)
			return;
		for (int i = 0; i < size2; i++) {
			doAnagram(size2-1);
			if(size2 == 2)
				display();
			rotate(size2);
		}
	}
	
	public static void rotate(int size2)
	{
		int j;
		int pos = size - size2;
		char temp = arrChar[pos];
		for (j = pos+1; j < size; j++) 
			arrChar[j-1] = arrChar[j];
		arrChar[j-1] = temp;
	}
	
	public static void display()
	{
		if(count < 99) 
			System.out.print(" "); 
		if(count < 9) 
			System.out.print(" "); 
		System.out.print(++count + ". "); 
		for(int j=0; j<size; j++) 
			System.out.print( arrChar[j] ); 
		System.out.print(" "); 
		System.out.flush(); 
		if(count%5 == 0) 
			System.out.println("\n");
	}
	
	public static String getStr() throws IOException
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br  = new BufferedReader(isr);
		String str = br.readLine();
		return str;
	}
	
}
