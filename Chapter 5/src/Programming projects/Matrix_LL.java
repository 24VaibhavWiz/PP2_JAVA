package Chapter5;
class MLink
{
	public double dData;
	public MLink nextRow;
	public MLink nextCol;
	
	public MLink(double value)
	{ dData = value; }
	
	public void displayLink()
	{ System.out.print(dData + "   "); }
}

class Matrix
{
	private int nRows;
	private int nCols;
	
	private MLink first;
	private MLink current;
	
	public Matrix(int rows, int cols)
	{
		nRows = rows;
		nCols = cols;
		
		first = new MLink(0);
		current = first;
		MLink temp;
		for(int i = 0; i < nRows; i++)
		{
			temp = current;
			for(int j = 1; j < nCols; j++)
			{
				temp.nextCol = new MLink(0);
				temp = temp.nextCol;
			}
			if(i < nRows-1)
			{
				current.nextRow = new MLink(0);
				current = current.nextRow;
			}
		}
	}
	
	public boolean insert(double value, int row, int col)
	{
		if(row > nRows || col > nCols || row <= 0 || col <= 0)
		{
			System.out.println();
			System.out.println("Must be in range (0,0) to (" + nRows + "," + nCols + ")");
			System.out.println();
			return false;
		}
		else
		{
			current = first;
			for(int i = 1; i < row; i++)
			{ current = current.nextRow; }
			for(int j = 1; j < col; j++)
			{ current = current.nextCol; }
			current.dData = value;
			System.out.println();
			System.out.println("Inserted " + value + " at (" + row + "," + col + ")");
			System.out.println();
			return true;
		}
	}
	
	public void display()
	{
		System.out.println();
		current = first;
		MLink temp;
		while(current != null)
		{
			temp = current;
			while(temp != null)
			{
				temp.displayLink();
				temp = temp.nextCol;
			}
			System.out.println();
			System.out.println();
			current = current.nextRow;
		}
	}
}

public class Matrix_LL
{
	public static void main(String[] args)
	{
		Matrix theMatrix = new Matrix(4,6);
		theMatrix.display();
		theMatrix.insert(14.99, 0, 1);
		theMatrix.insert(1, 0, 2);
		theMatrix.insert(2050, 1, 3);
		theMatrix.insert(99, 0, 4);
		theMatrix.insert(100, 0, 5);
		theMatrix.insert(200, 1, 1);
		theMatrix.insert(2, 0, 0);
		theMatrix.insert(7, 1, 2);
		theMatrix.insert(39, -1, -1);
		theMatrix.display();
	}
}