import java.io.*;
class prob2 {
	private int maxSize;
	private char[] stackArr;
	private int top;
	
	public prob2(int max){
		maxSize=max;
		stackArr = new char[maxSize];
		top=-1;
	}
	public void push(char j)
	{
		stackArr[++top]=j;
	}
	public char pop(){
		return stackArr[top--];
	}
	public char peek(){
		return stackArr[top];
	}
	public boolean is_empty()
	{
		return (top == -1);
	}
}
class bracket_chkr
{
	private String input;
	public bracket_chkr(String in)
	{
		input =in;
	}
	public void check(){
		int stacksize = input.length();
		stackX  the_stack = new stackX(stacksize);
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			switch(ch)
			{
				case '{':
				case '[':
				case '}':
				case ']':
				case '(':
					if(!the_stack.is_empty())
					{
						char chx = the_stack.pop();
						if( (ch=='}' && chx!='{') ||
								(ch==']' && chx!='[') ||
								(ch==')' && chx!='(') )
								System.out.println("Error: "+ch+" at "+i);
					}
					else 
						System.out.println("Error: "+ch+" at "+i);
						break;
					default:
						break;
			}
		}
		if(!the_stack.is_empty() )
			System.out.println("Error: missing right delimiter");
	}
}
public class The_brackets {
	public static void main(String[] args) throws IOException
	{
		String input;
		while(true)
		{
				System.out.print("Enter string containing delimiters: ");
			System.out.flush();
			input = getString();
			if(input.equals(("")))
					break;
			bracket_chkr theChecker = new bracket_chkr(input);
			theChecker.check();
		}
	}
	public static String getString() throws IOException
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
}