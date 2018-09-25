package chapter8;
import java.io.*;
import java.util.*;

class Node
{
	public int iData;
	public double dData;
	public Node leftChild;
	public Node rightChild;
	
	public void display()
	{
		System.out.println("{");
		System.out.println(iData);
		System.out.println(", ");
		System.out.println(dData);
		System.out.println("}");
	}
}

class Tree
{
	private Node root;
	
	public Tree(){
		root = null;
	}
	
	public Node find(int key)
	{
		Node current = root;
		while(current.iData != key)
		{
			if(key < current.iData)
				current = current.leftChild;
			else
				current = current.rightChild;
			if(current == null)
				return null;
		}
		return current;
	}
	
	public void insert(int id, double dd)
	{
		Node newNode = new Node();
		newNode.iData = id;
		newNode.dData = dd;
		if(root == null)
			root = newNode;
		else
		{
			Node current = root;
			Node parent;
			while(true)
			{
				parent = current;
				if(id > current.iData)
				{
					current = current.leftChild;
					if(current == null);
					{
						parent.leftChild = newNode;
						return;
					}
				}
				else
				{
					current = current.rightChild;
					if(current == null)
					{
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}
	
	public boolean delete(int key)
	{
		Node current = root;
		Node parent = root;
		boolean isLeftChild = true;
		while(current.iData != key)
		{
			parent = current;
			if(key < current.iData)
			{
				isLeftChild = true;
				current = current.leftChild;
			}
			else
			{
				isLeftChild = false;
				current = current.rightChild;
			}
			if(current == null)
				return false;

		}

		if(current.leftChild==null &&
				current.rightChild==null)
		{
			if(current == root)
				root = null;
		else if(isLeftChild)
			parent.leftChild = null;
		else
			parent.rightChild = null;
	}
	else if(current.rightChild==null)
		if(current == root)
			root = current.leftChild;
		else if(isLeftChild)
			parent.leftChild = current.leftChild;
		else
			parent.rightChild = current.leftChild;
	else if(current.leftChild==null)
		if(current == root)
			root = current.rightChild;
		else if(isLeftChild)
			parent.leftChild = current.rightChild;
		else
			parent.rightChild = current.rightChild;
	else {
		Node successor = getSuccessor(current);
		if(current == root)
			root = successor;
		else if(isLeftChild)
			parent.leftChild = successor;
		else
			parent.rightChild = successor;

		successor.leftChild = current.leftChild;
		} 		
		return true;
	}
	
	public Node getSuccessor(Node delNode)
	{
		Node successorParent = delNode;
		Node successor = delNode;
		Node current = delNode.rightChild;
		while(current != null)
		{
			successorParent = successor;
			successor = current;
			current = current.leftChild;
		}
		if(successor != delNode.rightChild)
		{
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = delNode.rightChild;
		}
		return successor;
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
	
	private void preOrder(Node localRoot)
	{
		if(localRoot != null)
		{
			System.out.print(localRoot.iData + " ");
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
		}
	}
	private void postOrder(Node localRoot)
	{
		if(localRoot != null)
		{
			postOrder(localRoot.leftChild);
			postOrder(localRoot.rightChild);
			System.out.print(localRoot.iData + " ");
		}
	}
	private void inOrder(Node localRoot)
	{
		if(localRoot != null)
		{
			inOrder(localRoot.leftChild);
			System.out.print(localRoot.iData + " ");
			inOrder(localRoot.rightChild);
		}
	}
	
	public void displayTree()
	{
	Stack globalStack = new Stack();
	globalStack.push(root);
	int nBlanks = 32;
	boolean isRowEmpty = false;
	System.out.println("......................................................");
	while(isRowEmpty==false)
	{
		Stack localStack = new Stack();
		isRowEmpty = true;
		for(int j=0; j<nBlanks; j++)
			System.out.print(' ');
		while(globalStack.isEmpty()==false)
		{
			Node temp = (Node)globalStack.pop();
			if(temp != null)
			{
				System.out.print(temp.iData);
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
			for(int j=0; j<nBlanks*2-2; j++)
				System.out.print(' ');
		} 
		System.out.println();
		nBlanks /= 2;
		while(localStack.isEmpty()==false)
			globalStack.push( localStack.pop() );
		} 
	System.out.println("......................................................");
	} 
}
public class ex1 {

	public static void main(String[] args) throws IOException
	{
		int value;
		Tree theTree = new Tree();
		theTree.insert(50,1.5);
		theTree.insert(25,1.2);
		theTree.insert(75,1.7);
		theTree.insert(12,1.5);
		theTree.insert(37,1.2);
		theTree.insert(43,1.7);
		theTree.insert(30,1.5);
		theTree.insert(33,1.2);
		theTree.insert(87,1.7);
		theTree.insert(93,1.5);
		theTree.insert(97,1.5);

		while(true)
		{
			System.out.print("Enter first letter of show, ");
			System.out.print("insert, find, delete, or traverse: ");
			int choice = getChar();
			switch(choice)
			{
			case 's':
				theTree.displayTree();
				break;
			case 'i':
				System.out.print("Enter value to insert: ");
				value = getInt();
				theTree.insert(value, value + 0.9);
				break;
			case 'f':
				System.out.print("Enter value to find: ");
				value = getInt();
				Node found = theTree.find(value);
				if(found != null)
				{
					System.out.print("Found: ");
					found.display();
					System.out.print("\n");
				}
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
