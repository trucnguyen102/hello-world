/*
 * Program Name:        Battle Ships
 * Objective:           A simple program to get more familiar with Arrays
 * 
 * Course:              edX Course DEV276x Learn to Program in Java
 * Course by:           Microsoft
 * 
 * Code by:             Truc Nguyen
 * Date:                2017-09-20
 * 
 */
import java.util.*;
public class BattleShips {
	static char[][] oceanMap = new char[12][14];
	static int[][] deployMap = new int[10][10];
	static int playerShips = 5;
	static int computerShips = 5;
	static Scanner input= new Scanner(System.in);
	public static void main(String[] args ){
		/*intro();
		placePlayerShip();
		placeComputerShip();
		startBattle();*/
		String a = "-1/";
		System.out.println(a.matches("(-?)(\\d+)(/([1-9]+))?"));
		 
	}
	
	public static void createOceanMap(){
		for(int i = 0; i< oceanMap.length; i++){
			for(int j = 0; j< oceanMap[0].length; j++){
				if(i==0||i==oceanMap.length-1){
					if(j>1&&j<oceanMap[0].length-2){
						oceanMap[i][j]=(char)(j-2 +'0');
					}
				}else if(!(j>1&&j<oceanMap[0].length-2)){
					if(j==0||j==oceanMap[0].length-1){
						oceanMap[i][j]=(char)(i-1 +'0');
					}else{
						oceanMap[i][j]= '|';
					}
				}
			}
		}
	}
	
	public static void printMap( char[][] map){
		for(int i = 0; i< oceanMap.length; i++){
			for(int j = 0; j< oceanMap[0].length; j++){
				System.out.print(oceanMap[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void intro(){
		System.out.println("**** Welcome to Battle Ships game ****");
		System.out.println("Right now the sea is empty.");
		createOceanMap();
		printMap(oceanMap);
	}
	
	public static boolean canPlaceShip(int x, int y){
		if(x < 0 || x > 9 || y < 0 || y > 9  ){
			System.out.println("You can’t place ships outside the map. Try again!");
			return false;
		}else if(deployMap[x][y] != 0){
				System.out.println("There is a ship here. Choose another place!");
			return false;
		}else{
			return true;
		}
	}
	
	public static int getPlayerCoordinate(String coord, int ordinal){
		System.out.print("Enter "+ coord +" coordinate for your "+ ordinal +". ship:");
		return input.nextInt();
	}
	
	public static int getPlayerCoordinate(String coord){
		System.out.print("Enter "+ coord +" coordinate:");
		return input.nextInt();
	}
	
	public static void placePlayerShip(){
		System.out.println("Deploy your "+playerShips+" ships:");
		for(int i = 1; i <= playerShips; i++){
			int x = getPlayerCoordinate("X",i);
			int y = getPlayerCoordinate("Y",i);
			if(canPlaceShip(x,y)){
				deployMap[x][y] = 1;
				oceanMap[x+1][y+2] = '@';
			}else{
				i--;
			}
		}
		System.out.println();
		printMap(oceanMap);
	}
	
	public static int getComputerCoordinate(){
		int coord = (int)(Math.random()*9 + 1);
		return coord;
	}
	
	public static void placeComputerShip(){
		System.out.println("Computer is deploying ships:");
		for(int i = 1; i <= computerShips; i++){
			int x = getComputerCoordinate();
			int y = getComputerCoordinate();
			if(canPlaceShip(x,y)){
				deployMap[x][y] = 2;
				System.out.println(i+". ship DEPLOYED");
			}else{
				i--;
			}
		}
	}
	
	public static boolean canShoot(int x, int y){
		if(x < 0 || x > 9 || y < 0 || y > 9  ){
			System.out.println("You can’t place ships outside the map. Try again!");
			return false;
		}else if(deployMap[x][y] == 3){
			System.out.println("This place was shot. Choose another place!");
			return false;
		}else{
			return true;
		}
	}
	
	public static void shootPlayerMessage(int x, int y){
		if(deployMap[x][y] == 0){
			System.out.println("You missed");
		}else if(deployMap[x][y] == 1){
			System.out.println("BOOM! You sunk your ship!");
			playerShips--;
		}else if(deployMap[x][y] == 2){
			System.out.println("BOOM! You sunk the ship!");
			computerShips--;
		}
	}
	
	public static void shootComputerMessage(int x, int y){
		if(deployMap[x][y] == 0){
			System.out.println("Computer missed");
		}else if(deployMap[x][y] == 1){
			System.out.println("BOOM! Coumputer sunk your ship!");
			playerShips--;
		}else if(deployMap[x][y] == 2){
			System.out.println("BOOM! Computer sunk its ship!");
			computerShips--;
		}
	}
	
	public static void winOrNot(){
		if(computerShips == 0){
			System.out.println("Hooray! You win the battle! :)");
		}else if(playerShips == 0){
			System.out.println("You loose the battle! :(");
		}else{
			startBattle();
		}
	}
	
	public static void guessPlayerShip(){
		System.out.println( "YOUR TURN");
		int x;
		int y;
		do{
			x = getPlayerCoordinate("X");
			y = getPlayerCoordinate("Y");
			
		}while(!canShoot(x,y));
		shootPlayerMessage(x,y);
		oceanMap[x+1][y+2] = 'x';
		printMap(oceanMap);
		System.out.println("Your ships: "+ playerShips +" | Computer ships: "+computerShips);
		
	}
	
	public static void guessComputerShip(){
		System.out.println("COMPUTER'S TURN");
		int x;
		int y;
		do{
			x = getComputerCoordinate();
			y = getComputerCoordinate();
			
		}while(!canShoot(x,y));
		shootComputerMessage(x,y);
		oceanMap[x+1][y+2] = 'x';
		printMap(oceanMap);
		System.out.println("Your ships: "+ playerShips +" | Computer ships: "+computerShips);
	}
	
	public static void startBattle(){
		guessPlayerShip();
		guessComputerShip();
		winOrNot();
	}
	




}
