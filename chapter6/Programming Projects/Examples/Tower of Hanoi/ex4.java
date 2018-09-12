package chapter6;
import java.util.*;
public class ex4 {

	@SuppressWarnings("resource")
	
	public static void main(String args[])
	{
		Scanner sc =  new Scanner(System.in);
		System.out.print("Please enter numbers of Disks present : ");
		int disks = sc.nextInt();
		System.out.println();
		System.out.println("Total numbers of Disks present : "+ disks);
		System.out.println();
		doHanoi(disks,'A','B','C');
		System.out.println("Follow above method for "+ disks +" numbers of Disks");
	}
	
	public static void doHanoi(int top,char first,char mid,char last)
	{
		if(top == 1) {
			System.out.println("Disk 1 from "+ first +" to "+ last);
			System.out.println();
		}
		else {
			doHanoi(top-1, first, last, mid);
			System.out.println("Disk "+ top +" from "+ first +" to "+ last);
			System.out.println();
			doHanoi(top-1, mid, first, last);
		}
	}
}
