package chapter8;
import java.io.*;
import java.util.*;

class AlphaNode
{
	public String sData;		
	public AlphaNode leftChild;
	public AlphaNode rightChild;
	
	public void displayNode()
	{
		System.out.print("{" + sData + "}");
	}
}

class AlphaTree
{
	private AlphaNode root;			
	
	public AlphaTree(String initString)
		{ 
			root = null;
			AlphaNode[] nodeArray = new AlphaNode[initString.length()];
			for(int i = 0; i < initString.length(); i++)
			{
				nodeArray[i] = new AlphaNode();
				nodeArray[i].sData = String.valueOf(initString.charAt(i));
			}
			
			AlphaNode plusNode = new AlphaNode();
			plusNode.sData = "+";
			plusNode.leftChild = nodeArray[0];
			plusNode.rightChild = nodeArray[1];
			
			for(int j = 2; j < nodeArray.length; j++)
			{
				AlphaNode newNode = new AlphaNode();
				newNode.sData = "+";
				newNode.leftChild = plusNode;
				newNode.rightChild = nodeArray[j];
				plusNode = newNode;
			}
			root = plusNode;
		}
	
	public void traverse(int traverseType)
	{
		switch(traverseType)
		{
		case 1: System.out.print("\nPreorder traversal: ");
				preOrder(root);
				break;
		case 2: System.out.print("\nInorder traversal: ");
				inOrder(root);
				break;
		case 3: System.out.print("\nPostorder traversal: ");
				postOrder(root);
				break;
		}
		System.out.println();
	}
	
	private void preOrder(AlphaNode localRoot)
	{
		if(localRoot != null)
		{
			System.out.print(localRoot.sData + " ");
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
		}
	}
	
	private void inOrder(AlphaNode localRoot)
	{
		if(localRoot != null)
		{
			inOrder(localRoot.leftChild);
			System.out.print(localRoot.sData + " ");
			inOrder(localRoot.rightChild);
		}
	}
	
	private void postOrder(AlphaNode localRoot)
	{
		if(localRoot != null)
		{
			postOrder(localRoot.leftChild);
			postOrder(localRoot.rightChild);
			System.out.print(localRoot.sData + " ");
		}
	}
	
	public void displayTree()
	{
		Stack<AlphaNode> globalStack = new Stack<AlphaNode>();
		globalStack.push(root);
		int nBlanks = 32;
		boolean isRowEmpty = false;
		System.out.println(".......................................................");
		while(isRowEmpty==false)
		{
			Stack<AlphaNode> localStack = new Stack<AlphaNode>();
			isRowEmpty = true;
			
			for(int j = 0; j < nBlanks; j++)
				System.out.print(" ");
			
			while(globalStack.isEmpty() == false)
			{
				AlphaNode temp = globalStack.pop();
				if(temp != null)
				{
					System.out.print(temp.sData);
					localStack.push(temp.leftChild);
					localStack.push(temp.rightChild);
					
					if(temp.leftChild != null ||
							temp.rightChild != null)
						isRowEmpty = false;
				}
				else
				{
					System.out.print("--");
					localStack.push(null);
					localStack.push(null);
				}
				for(int j = 0; j < nBlanks*2 - 2; j++)
					System.out.print(" ");
			} 
			System.out.println();
			nBlanks /= 2;
			while(localStack.isEmpty() == false)
				globalStack.push( localStack.pop() );
		} 
		System.out.println(".......................................................");
	}
} 

class Tree
{
	public static void main(String[] args) throws IOException
	{
		int value;
		String initString = "ABCDEFG";
		AlphaTree theTree = new AlphaTree(initString);
		
		while(true)
		{
			System.out.println();
			System.out.print("Enter first letter of show" + " or traverse: ");
			int choice = getChar();
			switch(choice)
			{
			case 's':
				theTree.displayTree();
				break;
			case 't':
				System.out.println();
				System.out.print("Enter type 1, 2, or 3: ");
				value = getInt();
				theTree.traverse(value);
				break;
			default:
				System.out.print("Invalid entry!\n");
			}
		}
	}
	
	public static String getString() throws IOException
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
	
	public static char getChar() throws IOException
	{
		String s = getString();
		return s.charAt(0);
	}
	
	public static int getInt() throws IOException
	{
		String s = getString();
		return Integer.parseInt(s);
	}
}