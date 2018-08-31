package Chapter5;
import java.util.*;
public class josephus_cll {
  private people head; 

  private static class people {
  
    private int data;                 
    private people next;           
    private people previous;       
    

    public people(int number)
    {
      next = previous = null; 
      data = number;              
    }

    public String toString()
    {
      return String.valueOf(data);
    }
  }
  
  public josephus_cll(int n, int k)
  {
    start(n);
    remove(k, n);
  }

  public void start(int n) {
	  people temp_people = null;
	
	if (n < 2){
		System.out.println("Parameter must be at least 2");
		return;
	}
	
	for (int i = 1; i < n + 1; i++){
		people ppl = new people(n);
		ppl.data = i;
		if (i == 1){
		
			head = ppl;
			temp_people = ppl;
			continue;
		}
		temp_people.next = ppl;
		ppl.previous = temp_people;
		temp_people = ppl;
	
		if (i == n){
			ppl.next = head;
			head.previous = ppl;
			continue;
		}
	}
  }

  public void remove(int k, int n) {
	  if ((k > 1 && k < n)){
		  people x; 
		  int i = 0;
		  
		  
		  for (x = head; x.next != x && x.previous != x; x = x.next){
		
			  if (i == k - 1)
			  {
				  x.previous.next = x.next;
				  x.next.previous = x.previous;
				  System.out.println("People at "+x.data+" executed. RIP. \n");
				  i = 0;
				  continue;
			  }
			  i++;
		  }
		  System.out.println("Last remaining Person is at "+x.data+ ". CIP.");
	  } else {
	      System.out.println("Parameter must be between 1 and n ");
	  }
  }
	  
  @SuppressWarnings("resource")
  public static void main(String [] args) {
	  int parameter_n, parameter_k ;           
	  Scanner input = new Scanner(System.in);
	  
      System.out.println("Enter number of People, at least 2: ");
      parameter_n = input.nextInt();
      System.out.println();
      System.out.println("Enter spacing of victims, between 1 and n: ");
      parameter_k = input.nextInt();
      System.out.println();
      new josephus_cll(parameter_n, parameter_k);
  }
}