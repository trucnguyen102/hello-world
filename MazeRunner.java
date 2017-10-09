/*
 * Program Name:        MazeRunner
 * Objective:           A simple program to explain Arithmetic and the Scanner Object
 * 
 * Course:              edX Course DEV276x Learn to Program in Java
 * Course by:           Microsoft
 * 
 * Code by:             Truc Nguyen
 * Date:                2017-09-10
 * 
 */
import java.util.Scanner;
public class MazeRunner {
	static Maze myMap = new Maze();
	static Scanner input= new Scanner(System.in);
	public static void main(String[] args ){
		intro();
		int count=0;
		String user ="";
		while(!myMap.didIWin()||count==100){
			user = userMove();
			if(!canMove(user)){
				if(myMap.isThereAPit(user.toUpperCase())){
					navigatePit(user);
				}else{
					System.out.println("Sorry, you’ve hit a wall.");
					myMap.printMap();
				}
				//continue;
			}else{
				move(user);
				myMap.printMap();
			}
			count++;
			movesMessage(count);
			//myMap.printMap();
		}
		
		if(myMap.didIWin()){
			System.out.println("Congratulations, you made it out alive!");
			System.out.println("and you did it in"+ count +"moves");
		}else{
			System.out.println("Sorry, but you didn't escape in time- you lose!");
		}
		
	}
	
	public static  void intro(){
		System.out.println("Welcome to Maze Runner!\nHere is your current position:");
		myMap.printMap();
	}
	
	public static String userMove(){
		System.out.print("Where would you like to move? (R, L, U, D)");
		String move = input.next();
		if(move.equalsIgnoreCase("r")||move.equalsIgnoreCase("l")||move.equalsIgnoreCase("u")||move.equalsIgnoreCase("d")){
			return move;
		}else{
			System.out.println("Please choose one of the given options!");
			return userMove();
		}
	}
	
	public static boolean canMove(String move){
		if(move.equalsIgnoreCase("r")){
			return myMap.canIMoveRight();
		}else if(move.equalsIgnoreCase("l")){
			return myMap.canIMoveLeft();
		}else if(move.equalsIgnoreCase("u")){
			return myMap.canIMoveUp();
		}else {
			return myMap.canIMoveDown();
		}
	}
	
	public static void move(String move){
		if(move.equalsIgnoreCase("r")){
			 myMap.moveRight();
		}else if(move.equalsIgnoreCase("l")){
			myMap.moveLeft();
		}else if(move.equalsIgnoreCase("u")){
			myMap.moveUp();
		}else {
			myMap.moveDown();
		}
	}
	
	public static void movesMessage(int moves){
		switch(moves){
		case 50: System.out.println("Warning: You have made 50 moves, you have 50 remaining before the maze exit closes");
			break;
		case 75: System.out.println("Alert! You have made 75 moves, you only have 25 moves left to escape.");
			break;
		case 90: System.out.println("DANGER! You have made 90 moves, you only have 10 moves left to escape!!");
			break;
		case 100: System.out.println("Oh no! You took too long to escape, and now the maze exit is closed FOREVER >:[");
			break;
		}
	}
	
	public static void navigatePit(String move){
			System.out.println("Watch out! There's a pit ahead, jump it?");
			String jump = input.next();
			if(jump.toLowerCase().startsWith("y")){
				//if(canMove()){
					myMap.jumpOverPit(move.toUpperCase());
					myMap.printMap();
				//}
			}
		
	}

}
