package chapter6;
public class prog4 {
public static double[] sack;
	
	public static void main(String[] args)
	{
		sack = new double[]{11, 8, 7, 6, 5};
		if(!knapsack(37, 0)) System.out.println("No valid combinations");
		
	}
	
	public static Boolean knapsack(double targetWeight, int index)
	{
		Boolean complete = false;
		
		if(index == sack.length) return false;
		if(sack[index] == targetWeight)
		{
			System.out.print("Answer: " + sack[index] + " ");
			complete = true;
		};
		if(sack[index] < targetWeight) 
		{
			complete = knapsack(targetWeight-sack[index], index+1); 			if(complete) System.out.print(sack[index] + " ");
			for(int i = index+1; i < sack.length; i++) 
			{
				if(!complete) complete = knapsack(targetWeight, i);
			}
		}
		if(sack[index] > targetWeight) complete = knapsack(targetWeight, index+1);
		
		
		return complete;
	}
}

