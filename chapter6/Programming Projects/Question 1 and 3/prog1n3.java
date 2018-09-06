package chapter6;
//6.1 and 6.3	
import java.util.*;
public class prog1n3 {
	
	@SuppressWarnings("resource")
	public static void main()
	{
		double x,y;
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the values to be Powered");
		x=sc.nextDouble();
		y=sc.nextDouble();
		double ans1 = pow(x,y);
		System.out.println( x+ "^" +y+ "=" + ans1);
		System.out.println("Please enter the values to be Multiplied");
		double a,b;
		a=sc.nextDouble();
		b=sc.nextDouble();
		double ans2 = mult(a,b);
		System.out.println( a+ "*" +b+ "=" + ans2);
	}
	
	public static double pow(double x,double y)
	{
		if(y == 1) return x;	
		else if (y%2 == 0) return pow(x*x, y/2);	
		else return x * pow(x, y-1);
	}
	
	public static double mult(double a, double b)
	{
		if(b==1) return a;
		else return a + mult(a, b-1);
	}
}
