package chapter6;
import java.util.*;

public class ex3 {

 public static void main(String[] args)
 {

	 Scanner sc = new Scanner(System.in);
	 System.out.print("Enter total number of elements : ");
	 int length = sc.nextInt();
	 int[] input = new int[length];
	 System.out.printf("Enter %d integers %n", length);
	 for (int i = 0; i < length; i++) 
		 input[i] = sc.nextInt();
	 System.out.println("Please enter number to be searched in array");
	 int key = sc.nextInt();
	 int index = recursiveBinarySearch(input, key);
	 if (index == -1) 
		 System.out.printf("Searched element not found in array %n", key);
	 else 
		 System.out.printf("%d is found in array at Index %d %n", key, index);
	 sc.close();
 }
 
 public static int recursiveBinarySearch(int[] input, int key) {
 
	 return binarySearch(input, 0, input.length - 1, key);
 }
 
 private static int binarySearch(int[] array, int start, int end, int target) {
 
	 int middle = (start + end) / 2;
	 if (end < start) 
		 return -1;
 if (target == array[middle]) 
	 return middle;
  else if (target < array[middle]) 
	  return binarySearch(array, start, middle - 1, target);
 else
	 return binarySearch(array, middle + 1, end, target);
 }
}