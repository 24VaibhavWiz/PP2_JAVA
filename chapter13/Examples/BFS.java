package chapter13;

class Queue
{
	private final int Size = 20;
	private int[] QArray;
	private int front;
	private int rear;
	
	public Queue()
	{
		QArray = new int[Size];
		front = 0;
		rear = -1;
	}
	
	public void insert(int i)
	{
		if(rear == Size - 1)
			rear = -1;
		QArray[++rear] = i;
	}
	
	public int remove()
	{
		int temp = QArray[front++];
		if(front == Size)
			front = 0;
		return temp;
	}
	
	public boolean isEmpty()
	{
		return (rear + 1 == front || (front + Size -1 == rear));
	}
}

class Vertex {
	
	public char label;
	public boolean visited;
	
	public Vertex(char lab)
	{
		label = lab;
		visited = false;
	}
}

class Graph {
	private final int MAX_VERTS = 20;
	private Vertex vertexList[];
	private int adjMat[][];
	private int nVerts;
	private Queue theQueue;
	
	public Graph()
	{
		vertexList = new Vertex[MAX_VERTS];
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		for(int j=0; j<MAX_VERTS; j++)
		for(int k=0; k<MAX_VERTS; k++)
		adjMat[j][k] = 0;
		theQueue = new Queue();
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
	
	public void bfs()
	{
		vertexList[0].visited = true; 
		displayVertex(0);
		theQueue.insert(0);

		int v2;
		while( !theQueue.isEmpty() )

		{
			int v1 = theQueue.remove();

			while( (v2=getAdjUnvisitedVertex(v1)) != -1 )
			{

				vertexList[v2].visited = true;
				displayVertex(v2);

				theQueue.insert(v2);

			}
		}
		for(int j=0; j<nVerts; j++)
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
public class BFS {

	public static void main(String args[])
	{
		Graph gr = new Graph();
		gr.addVertex('A');
		gr.addVertex('B');
		gr.addVertex('C');
		gr.addVertex('D');
		gr.addVertex('E');
		gr.addEdge(0, 1);
		gr.addEdge(1, 2);
		gr.addEdge(2, 3);
		gr.addEdge(3, 4);
		System.out.print("Visits : ");
		gr.bfs();
		System.out.println();
	}
}
