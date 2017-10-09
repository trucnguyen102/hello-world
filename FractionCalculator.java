/*
 * Program Name:        Fraction Calculator
 * Objective:           A simple program to practice building object class and testing it with a client class
 * 
 * Course:              edX Course DEV277x Object Oriented Programming in Java
 * Course by:           Microsoft
 * 
 * Code by:             Truc Nguyen
 * Date:                2017-09-29
 * 
 */
import java.util.Scanner;;
public class FractionCalculator {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		intro();
		decor();
		String oper = "";
		Fraction a = new Fraction();
		Fraction b = new Fraction();
		do{
			oper = getOperation(input);
			if(oper.equals("q")){
				System.exit(0);
			}else{
				a = getFraction(input);
				b = getFraction(input);
				System.out.print(a.toString() + " "+ oper + " "+ b.toString() + " ");
				if(oper.equals("+")){
					System.out.println("= " + a.add(b).toString());
				}else if(oper.equals("-")){
					System.out.println("= " + a.subtract(b).toString());
				}else if(oper.equals("*")){
					System.out.println("= " + a.multiply(b).toString());
				}else if(oper.equals("/")){
					System.out.println("= " + a.divide(b).toString());
				}else if(oper.equals("=")){
					System.out.println("is " + a.equals(b));
				}
				decor();
			}
		}while(!oper.equals("q"));
	}
	
	public static String getOperation(Scanner input){
		System.out.print("Please enter an operation (+, -, *, /, = or Q to quit:");
		String oper = input.next();
		while(!(oper.equals("+")|| oper.equals("-")|| oper.equals("*")|| oper.equals("/")|| oper.equals("=")|| oper.equalsIgnoreCase("q") )){	
			System.out.print("Invalid input (+, -, *, /, = or Q to quit:");
			oper = input.next();
		}
		return oper.toLowerCase();
	}
	
	public static boolean validFraction(String input){
		if(input.matches("(-?)(\\d+)(/([1-9]+))?")){
			return true;
		}else
			return false;
	}
	
	public static Fraction getFraction(Scanner input){
		System.out.print("Please enter a fraction (a/b) or integer (a):");
		String fracStr = input.next();
		while(!validFraction(fracStr)){
			System.out.print("Invalid fraction. Please enter a fraction (a/b) or integer (a), where a and b are integers and b is not 0:");
			fracStr = input.next();
		}
		if(fracStr.indexOf('/') == -1){
			int num = Integer.parseInt(fracStr);
			Fraction frac = new Fraction(num);
			return frac;
		}else{
			int num = Integer.parseInt(fracStr.substring(0, fracStr.indexOf('/')));
			int den = Integer.parseInt(fracStr.substring(fracStr.indexOf('/')+1, fracStr.length()));
			Fraction frac = new Fraction(num, den);
			return frac;
		}
		
	}
	
	public static void intro(){
		System.out.println("This program is a fraction caculator");
		System.out.println("It will add, substract, multiply, divide and compare fractions until you type Q to quit.");
		System.out.println("Please enter a fraction (a/b) or integer (a), where a and b are integers.");
	}
	
	public static void decor(){
		System.out.println("-----------------------------------------------------------------------------------------------");
	}
	
}
