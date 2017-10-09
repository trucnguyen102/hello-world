import java.util.*;
public class OddsAndEvens {
	private static Scanner input;

	public static void main(String[] args){
		input = new Scanner(System.in);
		System.out.println("Let’s play a game called \"Odds and Evens\"");
		System.out.print("What is your name?");
		String name = input.nextLine();
		System.out.print("Hi "+name+", which do you choose? (O)dds or (E)vens?");
		String oddOrEven = input.nextLine();
		if(oddOrEven.equals("O")){
			System.out.print(name+" has picked odds! The computer will be evens.");
		}else if(oddOrEven.equals("E")){
			System.out.print(name+" has picked evens! The computer will be odds.");			
		}else{
			System.out.println("error!");
		}
		System.out.println("--------------------------");
		System.out.print("How many \"fingers\" do you put out?");
		int user = input.nextInt();
		Random rand = new Random();
		int computer = rand.nextInt(6);
		System.out.println("The computer plays "+computer+" \"fingers.\"");
		System.out.println("--------------------------");
		int sum = user + computer;
		boolean oddEven = sum%2==1;
		System.out.println(user+" + "+computer+" = "+sum);
		if(oddEven){
			System.out.println(sum+" is ...odd!");
			if(oddOrEven.equals("O")){
				System.out.println("That means "+name+" win! :)");
			}else {
				System.out.println("That means computer win! :)");			
			}
		}else{
			System.out.println(sum+" is ...even!");
			if(oddOrEven.equals("E")){
				System.out.println("That means "+name+" win! :)");
			}else {
				System.out.println("That means computer win! :)");			
			}
		}
		System.out.println("--------------------------");
	}
	/*public static String startGame(Scanner input){
		System.out.println("Let’s play a game called \“Odds and Evens\”");
		System.out.print("What is your name?");
		String name = input.nextLine();
		System.out.print("Hi "+name", which do you choose? (O)dds or (E)vens?");
		String oddOrEven = input.nextLine();
		if(oddOrEven.equals("O")){
			System.out.print(name+" has picked odds! The computer will be evens.");
		}else if(oddOrEven.equals("E")){
			System.out.print(name+" has picked evens! The computer will be odds.");			
		}else{
			System.out.println("error!");
		}
		System.out.println("--------------------------");
		return oddOrEven;
	}
	public static void playGame(Scanner input){
		System.out.print("How many \“fingers\” do you put out?");
		int user = input.nextInt();
		Random rand = new Random();
		int computer = rand.nextInt(6);
		System.out.println("The computer plays "+number" \“fingers\”.");
		System.out.println("--------------------------");
		int sum = user + computer;
		boolean oddOrEven = sum%2==1;
		System.out.println(user+" + "+computer+" = "+sum);
		if(oddOrEven){
			System.out.println(sum+" is ...odd!");
		}else{
			System.out.println(sum+" is ...even!");
		}
	}*/

}
