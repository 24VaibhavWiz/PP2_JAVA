import java .io.*;
class stackX{
	private int maxSize;
	private char[] stackArr;
	private int top;
	
	public stackX(int max){
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
class reverser {
	private String input;
	private String output;
	
	public reverser(String in)
	{
		input =in;
	}
	public String do_reverse(){
		int stack_size=input.length();
		stackX thestack= new stackX(stack_size);
		for (int i = 0; i < input.length(); i++) {
			char ch=input.charAt(i);
			thestack.push(ch);
		}
		output= "";
		while (!thestack.is_empty()) {
			char ch = thestack.pop();
			output =output + ch;
		}
		return output;
	}
}
public class reverseApp{
	public static String getString() throws IOException{
		InputStreamReader ISR = new InputStreamReader(System.in); 
		BufferedReader BR= new BufferedReader(ISR);
		String s = BR.readLine();
		return s;
	}
	public static void main(String args[]) throws IOException{
		String output, input;
		while (true){
			System.out.println("Please enter the String : ");
			System.out.flush();
			input = getString();
			if(input.equals(""))
				break;
			reverser the_reverser = new reverser(input);
			output = the_reverser.do_reverse();
			System.out.println("Reversed : " + output);
		}
	}
}