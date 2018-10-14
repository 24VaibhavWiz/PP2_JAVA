package chapter9;
import java.util.*;

@SuppressWarnings("unused")
class RBNode {
	
		RBNode left, right;
		int element, clr;
	
	public RBNode(int elem)
	{
		this(elem, null, null);
	}
	
	public RBNode(int elem, RBNode lft, RBNode r8)
	{
		left = lft;
		right = r8;
		element = elem;
		clr = 1;
	}
}
class opRBTREE {
	
	private RBNode current;
	private RBNode parent1;
	private RBNode parent2;
	private RBNode parent3;
	private RBNode head;
	private static RBNode nullNode;
	
	static 
	{
		nullNode = new RBNode(0);
		nullNode.left = nullNode;
		nullNode.right = nullNode;
	}
	
	static final int BLACK = 1;
	static final int RED = 0;
	
	public opRBTREE(int n)
	{
		head = new RBNode(n);
		head.left = nullNode;
		head.right = nullNode;
	}
	
	public boolean isEmpty()
	{
		return 
				head.right == null;
	}
	
	public void makeEmpty()
	{
		head.right = nullNode;
	}
	
	public void insert(int item)
	{
		current = parent1 = parent2 = head;
		nullNode.element = item;
		while(current.element != item)
		{
			parent3 = parent2;
			parent2 = parent1;
			parent1 = current;
			current = item <current.element ? current.left : current.right;
			if(current.left.clr == RED  && current.left.clr == RED)
				handleReorient(item);
		}
		if(current != nullNode)
			return;
		current = new RBNode(item, nullNode, nullNode);
		if(item < parent1.element)
			parent1.left = current;
		else
			parent1.right = current;
		handleReorient(item);
	}
	
	public void handleReorient(int item)
	{
		current.clr = RED;
		current.left.clr = BLACK;
		current.right.clr = BLACK;
		if(parent1.clr == RED)
		{
			parent2.clr = RED;
			if(item < parent3.element != item < parent1.element)
				parent1 = rotate(item,parent3);
			current = rotate(item,parent3);
			current.clr = BLACK;
		}
		head.right.clr = BLACK;
	}
	
	 private RBNode rotate(int item, RBNode parent)
     {
         if(item < parent.element)
             return parent.left = item < parent.left.element ? rotateWithLeftChild(parent.left) : rotateWithRightChild(parent.left) ;  
         else
             return parent.right = item < parent.right.element ? rotateWithLeftChild(parent.right) : rotateWithRightChild(parent.right);  
     }
	 
	 private RBNode rotateWithLeftChild(RBNode k2)
     {
		 RBNode k1 = k2.left;
         k2.left = k1.right;
         k1.right = k2;
         return k1;
     }
	 
	 private RBNode rotateWithRightChild(RBNode k1)
	 {
		 RBNode k2 = k1.right;
		 k1.right = k2.left;
		 k2.left = k1;
		 return k2;
	 }
	 
	 private int countNodes(RBNode r)
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
	 
	 public int countNodes()
	 {
		 return 
				 countNodes(head.right);
	 }
	 
	 private boolean search(RBNode r, int val)
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

	 public boolean search(int val)
	 {
	  return search(head.right, val);
	 }
	  
	  @SuppressWarnings("rawtypes")
	  public Comparable findMin()
	  {
	        if( isEmpty( ) )
	            return null;
	        RBNode itr = head.right;
	        while( itr.left != nullNode )
	            itr = itr.left;
	        return itr.element;
	  }
	  
	  @SuppressWarnings("rawtypes")
	  public Comparable findMax()
	  {
		    if( isEmpty( ) )
		    	return null;
		  RBNode itr = head.right;
		  while( itr.right != nullNode )
			  itr = itr.right;
		  return itr.element;
	  }
	  
	  public void inorder()
	  {
		  inorder(head.right);
	  }

	  private void inorder(RBNode r)
	  {
		  if (r != nullNode)
		  {
			  inorder(r.left);
			  char c = 'B';
			  if (r.clr == 0)
				  c = 'R';
			  System.out.print(r.element +""+c+" ");
			  inorder(r.right);
		  }
	  }

	  public void preorder()
	  {
		  preorder(head.right);
	  }

	  private void preorder(RBNode r)
	  {
		  if (r != nullNode)
		  {
			  char c = 'B';
			  if (r.clr == 0)
				  c = 'R';
			  System.out.print(r.element +""+c+" ");
			  preorder(r.left);             
			  preorder(r.right);
		  }
	  }

	  public void postorder()
	  {
		  postorder(head.right);
	  }

	  private void postorder(RBNode r)
	  {
		  if (r != nullNode)
		  {
			  postorder(r.left);             
			  postorder(r.right);
			  char c = 'B';
			  if (r.clr == 0)
				  c = 'R';
			  System.out.print(r.element +""+c+" ");
		  }
	  } 

	  public void printTree( )
	  {
		  printTree( head.right );
	  }

	  private void printTree(RBNode t )
	  {
		  if( t != nullNode )
		  {
			  printTree( t.left );
			  System.out.println( t.element );
			  printTree( t.right );
		  }
	  }
} 
public class RedBlackTree {

	@SuppressWarnings("resource")
	public static void main(String[] args)
	{            
		Scanner sc = new Scanner(System.in);
		opRBTREE rbt = new opRBTREE(Integer.MIN_VALUE); 
		System.out.println("Red Black Tree \n");          
		char ch;
		do    
		{
			System.out.println("Please enter your choice \n");
			System.out.println("1. Insert");
			System.out.println("2. Search");
			System.out.println("3. Count Nodes");
			System.out.println("4. Find Max");
			System.out.println("5. Find Min");
			System.out.println("6. Check Empty");
			System.out.println("7. Clear Tree");
			System.out.println("8. Display Tree");
			System.out.println("9. Exit \n");
			int choice = sc.nextInt();            
			switch (choice)
			{
			case 1 : 
				System.out.println("Enter integer element to Insert");
				rbt.insert( sc.nextInt() );                     
				break;                          
			case 2 : 
				System.out.println("Enter integer element to Search");
				System.out.println("Search result : "+ rbt.search( sc.nextInt() ));
				break;                                          
			case 3 : 
				System.out.println("Nodes = "+ rbt.countNodes());
				break;
			case 4 :
				System.out.print("Max : ");
				rbt.findMax();
			case 5 :
				System.out.print("Min : ");
				rbt.findMin();
			case 6 : 
				System.out.println("Empty status = "+ rbt.isEmpty());
				break;     
			case 7 : 
				System.out.println("\nTree Cleared");
				rbt.makeEmpty();
				break;         
			case 8 :
				System.out.println("Your Tree\n");
				rbt.printTree();
				break;
			case 9 :
				System.exit(0);
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
			ch = sc.next().charAt(0);                        
		} 
		while (ch == 'Y'|| ch == 'y');               
	}
}
