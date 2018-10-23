package chapter13;

class StackX
{
	private final int SIZE = 20;
	private int[] st;
	private int top;

	public StackX()

	{
		st = new int[SIZE];
		top = -1;
	}
	
	public void push(int j)
	{
		st[++top] = j;
	}
	
	public int pop()
	{
		return st[top--];
	}
	
	public int peek()
	{
		return st[top];
	}
	
	public boolean isEmpty()
	{
		return top == -1;
	}
}

class ver
{
	public char label;
	public boolean Visited;
	
	public ver(char lab)
	{
		label = lab;
		Visited = false;
	}
}

class graph
{
	private final int MAX_VERTS = 20;
	private Vertex vertexList[]; 
	private int adjMat[][];
	private int nVerts;
	private StackX theStack;

	public graph()
	{
		vertexList = new Vertex[MAX_VERTS];
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		for(int j=0; j<MAX_VERTS; j++)
			for(int k=0; k<MAX_VERTS; k++)
				adjMat[j][k] = 0;
		theStack = new StackX();
	}
	public void addVertex(char lab)
	{
		vertexList[nVerts++] = new Vertex(lab);
	}
	
	public void addEdge(int start, int end)
	{
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}
	
	public void displayVertex(int v)
	{
		System.out.print(vertexList[v].label);
	}


	public void dfs() 
	{
		vertexList[0].visited = true; 	displayVertex(0);
		theStack.push(0);
		while( !theStack.isEmpty() )
		{
			int v = getAdjUnvisitedVertex( theStack.peek() );
			if(v == -1)
				theStack.pop();
			else
			{
				vertexList[v].visited = true; 	displayVertex(v);
				theStack.push(v);
			}
		} 		for(int j=0; j<nVerts; j++)
			vertexList[j].visited = false;
	}
	
	public int getAdjUnvisitedVertex(int v)
	{
		for(int j=0; j<nVerts; j++)
			if(adjMat[v][j]==1 && vertexList[j].visited==false)
				return j;
		return -1;
	}
}
public class DFS {

	public static void main(String args[])
	{
		graph gr = new graph();
		gr.addVertex('A');
		gr.addVertex('B');
		gr.addVertex('C');
		gr.addVertex('D');
		gr.addVertex('E');
		gr.addEdge(0, 1);
		gr.addEdge(1, 2);
		gr.addEdge(0, 3);
		gr.addEdge(3, 4);
		System.out.print("Visits : ");
		gr.dfs();
		System.out.println();
	}
}
