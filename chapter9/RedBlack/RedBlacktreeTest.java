package chapter9;
import java.util.*;

class RedBlackNode
{    
	RedBlackNode left, right;
	int element;
	int color;

	public RedBlackNode(int theElement)
	{
		this( theElement, null, null );
	} 

	public RedBlackNode(int theElement, RedBlackNode lt, RedBlackNode rt)
	{
		left = lt;
		right = rt;
		element = theElement;
		color = 1;
	}    
}

class RBTree
{
	private RedBlackNode current;
	private RedBlackNode parent;
	private RedBlackNode grand;
	private RedBlackNode great;
	private RedBlackNode header;    
	private static RedBlackNode nullNode;
	static 
	{
		nullNode = new RedBlackNode(0);
		nullNode.left = nullNode;
		nullNode.right = nullNode;
	}

	static final int BLACK = 1;    
	static final int RED   = 0;

	public RBTree(int negInf)
	{
		header = new RedBlackNode(negInf);
		header.left = nullNode;
		header.right = nullNode;
	}

	public boolean isEmpty()
	{
		return header.right == nullNode;
	}

	public void makeEmpty()
	{
		header.right = nullNode;
	}

	public void insert(int item )
	{
		current = parent = grand = header;
		nullNode.element = item;
		while (current.element != item)
		{            
			great = grand; 
			grand = parent; 
			parent = current;
			current = item < current.element ? current.left : current.right;

			if (current.left.color == RED && current.right.color == RED)
				handleReorient( item );
		}

		if (current != nullNode)
			return;
		current = new RedBlackNode(item, nullNode, nullNode);
		if (item < parent.element)
			parent.left = current;
		else
			parent.right = current;        
		handleReorient( item );
	}
	private void handleReorient(int item)
	{

		current.color = RED;
		current.left.color = BLACK;
		current.right.color = BLACK;

		if (parent.color == RED)   
		{

			grand.color = RED;
			if (item < grand.element != item < parent.element)
				parent = rotate( item, grand ); 
			current = rotate(item, great );
			current.color = BLACK;
		}

		header.right.color = BLACK; 
	}      
	private RedBlackNode rotate(int item, RedBlackNode parent)
	{
		if(item < parent.element)
			return parent.left = item < parent.left.element ? rotateWithLeftChild(parent.left) : rotateWithRightChild(parent.left) ;  
			else
				return parent.right = item < parent.right.element ? rotateWithLeftChild(parent.right) : rotateWithRightChild(parent.right);  
	}

	private RedBlackNode rotateWithLeftChild(RedBlackNode k2)
	{
		RedBlackNode k1 = k2.left;
		k2.left = k1.right;
		k1.right = k2;
		return k1;
	}
	private RedBlackNode rotateWithRightChild(RedBlackNode k1)
	{
		RedBlackNode k2 = k1.right;
		k1.right = k2.left;
		k2.left = k1;
		return k2;
	}

	public int countNodes()
	{
		return countNodes(header.right);
	}
	private int countNodes(RedBlackNode r)
	{
		if (r == nullNode)
			return 0;
		else
		{
			int l = 1;
			l += countNodes(r.left);
			l += countNodes(r.right);
			return l;
		}
	}

	public boolean search(int val)
	{
		return search(header.right, val);
	}
	private boolean search(RedBlackNode r, int val)
	{
		boolean found = false;
		while ((r != nullNode) && !found)
		{
			int rval = r.element;
			if (val < rval)
				r = r.left;
			else if (val > rval)
				r = r.right;
			else
			{
				found = true;
				break;
			}
			found = search(r, val);
		}
		return found;
	}

	public void inorder()
	{
		inorder(header.right);
	}
	private void inorder(RedBlackNode r)
	{
		if (r != nullNode)
		{
			inorder(r.left);
			char c = 'B';
			if (r.color == 0)
				c = 'R';
			System.out.print(r.element +""+c+" ");
			inorder(r.right);
		}
	}

	public void preorder()
	{
		preorder(header.right);
	}
	private void preorder(RedBlackNode r)
	{
		if (r != nullNode)
		{
			char c = 'B';
			if (r.color == 0)
				c = 'R';
			System.out.print(r.element +""+c+" ");
			preorder(r.left);             
			preorder(r.right);
		}
	}

	public void postorder()
	{
		postorder(header.right);
	}
	private void postorder(RedBlackNode r)
	{
		if (r != nullNode)
		{
			postorder(r.left);             
			postorder(r.right);
			char c = 'B';
			if (r.color == 0)
				c = 'R';
			System.out.print(r.element +""+c+" ");
		}
	}     
}


public class RedBlacktreeTest
{
	public static void main(String[] args)
	{            
		Scanner scan = new Scanner(System.in);
		RBTree rbt = new RBTree(Integer.MIN_VALUE); 
		System.out.println("Red Black Tree Test\n");          
		char ch;
		do    
		{
			System.out.println("\nRed Black Tree Operations\n");
			System.out.println("1. insert ");
			System.out.println("2. search");
			System.out.println("3. count nodes");
			System.out.println("4. check empty");
			System.out.println("5. clear tree");

			int choice = scan.nextInt();            
			switch (choice)
			{
			case 1 : 
				System.out.println("Enter integer element to insert");
				rbt.insert( scan.nextInt() );                     
				break;                          
			case 2 : 
				System.out.println("Enter integer element to search");
				System.out.println("Search result : "+ rbt.search( scan.nextInt() ));
				break;                                          
			case 3 : 
				System.out.println("Nodes = "+ rbt.countNodes());
				break;     
			case 4 : 
				System.out.println("Empty status = "+ rbt.isEmpty());
				break;     
			case 5 : 
				System.out.println("\nTree Cleared");
				rbt.makeEmpty();
				break;         
			default : 
				System.out.println("Wrong Entry \n ");
				break;    
			}
			System.out.print("\nPost order : ");
			rbt.postorder();
			System.out.print("\nPre order : ");
			rbt.preorder();
			System.out.print("\nIn order : ");
			rbt.inorder(); 

			System.out.println("\nDo you want to continue (Type y or n) \n");
			ch = scan.next().charAt(0);                        
		} while (ch == 'Y'|| ch == 'y');               
	}
}
