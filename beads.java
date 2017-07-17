/*
ID: alleneb1
LANG: JAVA
TASK: beads
 */

import java.io.*;
public class beads{
	
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("beads.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
		int length = Integer.parseInt(f.readLine());
		
		String necklace = f.readLine();
		
		int[] greatestSums = new int[length];
		int pos = 0;
		
		int leftColorStreak = 0;
		int rightColorStreak = 0;
		
		int totalColorStreak;
			
		char[] necklaceArray = new char[necklace.length()];
		for(int c = 0; c < length; c++) {
			necklaceArray[c] = necklace.charAt(c);
		}
		int biggest = 0;
		
		if(isAllSameChar(necklaceArray)){
			biggest = length;
		} else {
			while(pos != length) {
			
				pos++;
				leftColorStreak = leftStreak(necklaceArray);

				rightColorStreak = rightStreak(necklaceArray);	

				totalColorStreak = rightColorStreak + leftColorStreak;

				necklaceArray = shiftArray(necklaceArray);

				int closestEmptyIndex = 0;
				for(int c = 0; c < greatestSums.length; c++) {
					if(greatestSums[c] == 0) {
						closestEmptyIndex = c;
					}
				}
				greatestSums[closestEmptyIndex] = totalColorStreak;
		}

		
		for(int c= 0; c < greatestSums.length;c++) {
			if(greatestSums[c] > biggest) {
				biggest = greatestSums[c];
			}
		}
		
		}
		out.println(biggest);

		f.close();
		out.close();
	}
	public static boolean isAllSameChar(char[]arr) {
		boolean allSameChar = true;
		char sameCharTest = arr[0];
		for(int c=0;c<arr.length;c++){
			if(arr[c]!=sameCharTest){
				allSameChar=false;
			}
		}
		return allSameChar;
	}
	public static int rightStreak(char[]arr) {
		int returnval=0;
		int pos = arr.length-1;
		
		char currChar = arr[firstNotWRightCounter(arr)];
		
		while((pos>=0) && ((arr[pos] == 'w') || (arr[pos] == currChar))) {
			returnval++;
			pos--;
		}
		
		return returnval;
			
	}
	public static int leftStreak(char[]arr) {
		int returnval=0;
		
		char currChar = arr[firstNotWLeftCounter(arr)];
		
		while(( returnval < arr.length) &&((arr[returnval] == currChar) || (arr[returnval]=='w'))) {
			returnval++;
		}
		
		return returnval;
	}
	public static int firstNotWLeftCounter(char[]arr){
		int returnval=0;
		
		while(arr[returnval]=='w'){
			returnval++;
		}
		return returnval;
	}	
	public static int firstNotWRightCounter(char[]arr){
		int returnval=arr.length-1;
		
		while(arr[returnval]=='w'){
			returnval--;
		}
		return returnval;
	}
	public static char[] shiftArray(char[] arr) {
		
		char[] charSub = new char[arr.length];
		charSub[0] = arr[arr.length-1];
		for(int c = 1; c < arr.length;c++){
			charSub[c] = arr[c-1];
		}
		
		
		return charSub;
	}
	public static void printArr(char[] arr) {
		for(int  c =0; c < arr.length - 1; c++) {
			System.out.print(arr[c]);
		}
		System.out.println(arr[arr.length-1]);
	}
	public static void printArr(String[] arr) {
		for(int  c =0; c < arr.length; c++) {
			System.out.print(arr[c]);
		}
	}
	public static void printArr(int[] arr) {
		for(int  c =0; c < arr.length; c++) {
			System.out.print(arr[c]);
		}
	}
	public static void printArr(Boolean[] arr) {
		for(int  c =0; c < arr.length; c++) {
			System.out.print(arr[c]);
		}
	}
}
