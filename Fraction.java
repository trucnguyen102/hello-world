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

public class Fraction {
	private int num; //numerator
	private int den; //denominator
	
	/**
     * Instantiate a new Fraction object.
     */
	public Fraction(int num, int den){
		if(den != 0){
			
			if(den < 0){
				this.num = -num;
				this.den = -den;
			}else{
				this.num = num;
				this.den = den;
			}
			
		}else{
			throw new IllegalArgumentException("Denominator can't be 0");
		}
		
	}
	
	public Fraction(int num){
		this(num,1);
	}
	
	public Fraction(){
		this(0);
	}
	
	/**
     * Exposes the value of the numerator field to the user.
     */
	public int getNumerator(){
		return this.num;
	}
	
	/**
     * Exposes the value of the denominator field to the user.
     */
	public int getDenominator(){
		return this.den;
	}
	
	/**
     * @return "numerator/denominator", a String representation of the Fraction.
     */
	public String toString(){
		if(den == 1){
			return num  + "";
		}else
			return num + "/" + den;
	}
	
	/**
	 * @return the result of numerator / denominator
	 */
	public double toDouble(){
		return num / den;
	}
	
	/**this + other
	 * @return  a new Fraction that is the sum of other and this fractions
	 */
	public Fraction add(Fraction other){
		Fraction sum = new Fraction();
		sum.num = this.num*other.den + this.den*other.num;
		sum.den = this.den*other.den;
		sum.toLowestTerms();
		return sum;
	}
	
	/**this - other
	 * @return  a new Fraction that is the difference of other and this fractions
	 */
	public Fraction subtract(Fraction other){
		Fraction difference = new Fraction();
		difference.num = this.num*other.den - this.den*other.num;
		difference.den = this.den*other.den;
		difference.toLowestTerms();
		return difference;
	}
	
	/**this * other
	 * @return  a new Fraction that is the product of other and this fractions
	 */
	public Fraction multiply(Fraction other){
		Fraction product = new Fraction();
		product.num = other.num*this.num ;
		product.den = this.den*other.den;
		product.toLowestTerms();
		return product;
	}
	
	/**this/other
	 * @return  a new Fraction that is the product of other and this fractions.
	 */
	public Fraction divide(Fraction other){
		if(other.num != 0){
			Fraction division = new Fraction();
			division.num = this.num*other.den;
			division.den = other.num*this.den;
			division.toLowestTerms();
			return division;
		}else{
			throw new IllegalArgumentException("Can't divide by 0");
		}
	}
	
	/**
	 * Check if two fraction are equal.
	 */
	public boolean equals(Object obj){
		if(obj instanceof Fraction){
			return false;
		}else{
			Fraction other = new Fraction();
			other = (Fraction)obj;
			if(this.subtract(other).num == 0){
				return true;
			}else
				return false;
		}
		
	}
	
	private int gcd(int num, int den){
		int remainder;
		while( num != 0 && den != 0){
			remainder = num%den;
			num = den;
			den = remainder;
		}
		return num;
	}
	
	private void toLowestTerms(){
		this.num = this.num/gcd(this.num, this.den);
		this.den = this.den/gcd(this.num, this.den);
	}
	
}
