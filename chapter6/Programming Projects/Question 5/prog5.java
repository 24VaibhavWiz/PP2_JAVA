package chapter6;
import java.util.*;
public class prog5 {
	@SuppressWarnings("resource")
	public static void main(String[] args)
	{
		Scanner sc =  new Scanner (System.in);
		String sequence = "";
		System.out.println("Please enter the Team Size");
		int teamSize = sc.nextInt();
		System.out.println("Please enter the Group Size");
		int groupSize = sc.nextInt();
		showTeams(teamSize, groupSize, sequence, 'A', groupSize-1);
	}
		
	public static void showTeams(int teamSize, int groupSize, String sequence, char letter, int evalSize)
	{
		if(groupSize > teamSize || teamSize < 0 || groupSize < 0) return;
		
		sequence += Character.toString(letter);
		letter++;
		showTeams(teamSize-1, groupSize-1, sequence, letter, evalSize); 
		sequence = sequence.substring(0, sequence.length()-1);
		
		if(sequence.length() == evalSize) System.out.println(sequence + (char)(letter-1));
		showTeams(teamSize-1, groupSize, sequence, letter, evalSize); 
		letter--;		
	}
	

}