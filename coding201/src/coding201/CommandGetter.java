package coding201;
import java.util.Scanner;

public class CommandGetter {
	static PlayerClub myClub;
	
	
	
	public CommandGetter(PlayerClub myClub) {
		CommandGetter.myClub = myClub;
	}
	
	
	
	
	public static void main(String[] args) {
		Scanner commandgetter = new Scanner(System.in);
		String input = commandgetter.nextLine();
		
		if(input == "get balance") {
			System.out.println(myClub.balance);
		
		}
		
	}
}
