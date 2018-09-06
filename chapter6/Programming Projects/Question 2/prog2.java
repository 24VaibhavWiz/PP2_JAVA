package chapter6;
public class prog2 {

	public static String[] tree;
	
	public static void main(String[] args)
	{
		int rowSize = 64;
		int numRows = (int)(Math.log(rowSize)/Math.log(2)) + 1;
		tree = new String[numRows];
		for(int i = 0; i < tree.length; i++) tree[i] = "";
		makeBranches(0, rowSize-1, 0);
		display(tree);
	}
	
	public static void makeBranches(int left, int right, int row)
	{
		if(left - right == 0) return;
		int midpt = (left + right)/2;
		for(int i = left; i < right; i++)
		{
			if(i == midpt) tree[row] += "X";
			else tree[row] += "-";
		}
		
		makeBranches(left, midpt, row+1);
		
		makeBranches(midpt+1, right, row+1);
		
	}
	
	public static void display(String[] tree)
	{
		for(int i = 0; i < tree.length; i++)
		{
			System.out.println(tree[i]);
		}
	}
}

