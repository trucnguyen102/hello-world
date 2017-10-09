/*
 * Program Name:        Travel Planner
 * Objective:           A simple program to explain Arithmetic and the Scanner Object
 * 
 * Course:              edX Course DEV276x Learn to Program in Java
 * Course by:           Microsoft
 * 
 * Code by:             Truc Nguyen
 * Date:                2017-08-14
 * 
 */
import java.util.Scanner;
import java.lang.Math;
public class TripPlanner {
	private static Scanner input= new Scanner(System.in);
	public static void main(String[] args ){
		/*greeting();
		decor();
		timeAndBudget();
		decor();
		timeDiffer();
		decor();
		area();
		decor();
		haversineFormula();*/
		System.out.println(Math.pow(5.0/2, 6));
	}
	public static void greeting(){
		//input = new Scanner(System.in);
		System.out.println("Welcome to Vacation Planner!");
		System.out.print("What is your name?");
		String name = input.nextLine();
		System.out.print("Nice to meet you " + name +", where are you travelling to?");
		String place = input.nextLine();
		System.out.print("Great! " + place +" sounds like a great trip!");
	}
	
	public static void decor(){
		System.out.println();
		System.out.println("************");
		System.out.println();
		System.out.println();
	}
	
	public static void timeAndBudget(){
		System.out.print("How many days are you going to spend travelling?");
		int days = input.nextInt();
		System.out.print("How much money, in USD, you are going to spend on your trip?");
		int money = input.nextInt();
		System.out.print("What is the three letter currency symbol for your travel destination?");
		String currency = input.next();
		System.out.print("How many "+currency+" are there in 1 USD?");
		double exchange = input.nextDouble();
		int hours = days*24;
		int minutes = hours * 60;
		int seconds = minutes *60;
		double budgetPerDay = (int)(money*100/days)/100.0;
		double exchangeBudget= money*exchange;
		double  exchangeBudgetPerDay=(int)(money*exchange*100/days)/100.0;
		System.out.print("If you're travelling for "+days+" that is the same as "+hours+" hours "+minutes+" minutes "+seconds+" seconds");
		System.out.println();
		System.out.print("If you're going to spend $"+money+" USD that means per day you can spend up to $"+budgetPerDay+" USD" );
		System.out.println();
		System.out.print("Your total budget in "+currency+" is "+exchangeBudget+" "+currency+", which per day is "+exchangeBudgetPerDay+" "+currency);
	}
	public static void timeDiffer(){
		System.out.print("What is the time difference, in hours, between your home and your destination?");
		int differ = input.nextInt();
		int differMidnight = (differ + 24)%24;
		int differNoon = (differ + 12)%24;
		System.out.print("That means that when it is midnight at home it will be "+differMidnight+":00 in your travel destination");
		System.out.print("and when it is noon at home it will be " +differNoon+":00");
	}


	public static void area(){
		System.out.print("What is the square area of your destination country in km2?");
		int area = input.nextInt();
		System.out.print("In miles that is "+area*0.3861);
	}
	
	public static void haversineFormula(){
		int r = 6371;
		System.out.print("What is the latitude of point1?");
		double la1 = input.nextDouble()*Math.PI;
		System.out.print("What is the longtitude of point1?");
		double long1 =input.nextDouble()*Math.PI;
		System.out.print("What is the latitude of point 2?");
		double la2 = input.nextDouble()*Math.PI;
		System.out.print("What is the longtitude of point 2?");
		double long2=input.nextDouble()*Math.PI;
		double hsla = Math.pow(Math.sin((la2-la1)/2), 2);
		double hslong = Math.pow(Math.sin((long2-long1)/2), 2);
		double distance = 2*r*Math.asin(Math.sqrt(hsla + hslong*Math.cos(la1)*Math.cos(la2)));
		System.out.println("The distance between 2 point is "+distance);

	}
	
	
}
