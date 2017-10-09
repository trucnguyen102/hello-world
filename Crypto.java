/*
 * Program Name:        DataFlow(recursive)
 * Objective:           A simple program to encripting and decrypting text
 * 
 * Course:              edX Course DEV276x Learn to Program in Java
 * Course by:           Microsoft
 * 
 * Code by:             Truc Nguyen
 * Date:                2017-08-26
 * 
 */
public class Crypto {
	public static void main(String[] args){
		
		String cyphertext = encryptString("Barak Obama",  5, 3);
		String plaintext = decryptString(cyphertext,5);
		System.out.println(cyphertext);
		System.out.println(plaintext);
	}
	
	public static String normalizeText(String s){
		return s.toUpperCase().replaceAll("\\W" , "");
	}
	
	public static String obify(String s){
		return s.replaceAll("([AEIOUY])", "OB$1");//$1 represents 2nd group=([AEIOU])
	}
	
	public static String unobify(String s){
		//replaces OB+vowel and just leaves the vowel 
		return s.replaceAll("(OB)([AEIOUY])","$2");//$2 represents 2nd group=([AEIOU])
	}
	
	public static String shiftAlphabet(int shift) {
		int start = 0;
	    if (shift < 0) {
	        start = (int) 'Z' + shift + 1;
	    } else {
	        start = 'A' + shift;
	    }
	    String result = "";
	    char currChar = (char) start;
	    for(; currChar <= 'Z'; ++currChar) {
	        result = result + currChar;
	    }
	    if(result.length() < 26) {
	        for(currChar = 'A'; result.length() < 26; ++currChar) {
	            result = result + currChar;
	        }
	    }
	    return result;
	}
	
	public static String caesarify(String s, int shift){
		String shiftAlphabet =	shiftAlphabet(shift);
		String caesar ="";
		for(int i =0; i < s.length(); i++){
			char c = s.charAt(i);
			caesar += s.substring(i, i+1).replace(c, shiftAlphabet.charAt((int)c -(int) 'A'));
		}
		return caesar;
	}
	
	public static String groupify(String s, int groupSize){
		String group = "";
		for(int i=0; i*groupSize < s.length(); i++ ){
			if((i+1)*groupSize < s.length()){
				group += s.substring(i*groupSize, (i+1)*groupSize)+ " ";
			}else{
				group += s.substring(i*groupSize, s.length());
			}
		}
		if(s.length()%groupSize==0){
			return group;
		}else{
			for(int i=0;i<groupSize-s.length()%groupSize;i++){
				group += "x";
			}
			return group;
		}
	}
	
	public static String ungroupify(String s){
		String normal = "";
		normal = s.replaceAll("\\s", "");
		s = normal.replaceAll("x", "");
		return s;
	}
	
	public static String encryptString(String s, int shift, int groupSize){
		
		return groupify(caesarify(obify(normalizeText(s)),shift),groupSize);
	}
	
	public static String decryptString(String s, int shift){
		return unobify(caesarify(ungroupify(s),-shift));
	}

}
