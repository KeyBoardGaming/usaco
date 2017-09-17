import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class notlast {
	public static void main(String[] args) throws IOException {
		int[] milkValues= new int[7];
		String[] cowNames = {"Bessie", "Maggie", "Elsie", "Henrietta", "Gertie", "Daisy", "Annabelle"};
		BufferedReader f = new BufferedReader(new FileReader("notlast.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("notlast.out")));
		//Gather inputs
		int linesOfInput = Integer.parseInt(f.readLine());
		
		/*for(int c = 0; c < linesOfInput; c++) {
			StringTokenizer st = new StringTokenizer(f.readLine());
			String cowName = st.nextToken();
			int addMilk = Integer.parseInt(st.nextToken());
			milkValues[positionOf(cowName, cowNames)]+=addMilk;
		}
		*/
		/*
		for(int c = 0; c < linesOfInput; c++) {
			StringTokenizer st = new StringTokenizer(f.readLine());
			String currCowName = st.nextToken();
			int currCowMilkVal = Integer.parseInt(st.nextToken());
			System.out.println("I: " + currCowMilkVal);
			if(!(isStrInArr(currCowName, cowNames))) {
				cowNames[nextEmptyElement(cowNames)] = currCowName;
				milkValues[nextEmptyElement(cowNames)] +=currCowMilkVal;
			}
			else {
				milkValues[positionOf(currCowName,cowNames)]+=currCowMilkVal;
			}
			
		}*/
		
		// Reads lines of input
		for(int c = 0; c < linesOfInput; c++) {
			StringTokenizer st = new StringTokenizer(f.readLine());
			String cowName = st.nextToken();
			int milkAmount = Integer.parseInt(st.nextToken());
			
			milkValues[positionOf(cowName, cowNames)]+=milkAmount;
		}
		/*for(int c = 0; c < 7; c++) {
			System.out.println("Y" + milkValues[c]);
		}
		*/
		f.close();
		
		int[] originalMilkValues = new int[7];
		for(int c = 0; c < milkValues.length; c++) {
			originalMilkValues[c] = milkValues[c];
		}
		
		//Arrays.sort(milkValues);	
		
		
		//find the smallest value
		int smallest = 101;
		for(int c = 0; c < 7; c++) {
			//System.out.println(milkValues[c]);
			if(milkValues[c] < smallest) {
				
				smallest = milkValues[c];
			}
		}
		//System.out.println(smallest);
		//System.out.println(smallest);
		//Find the second smallest value
		int secondSmallest = 101;
		for(int c = 0; c < 7; c++) {
			if((milkValues[c] > smallest) && (milkValues[c] < secondSmallest)) {
				secondSmallest = milkValues[c];
			}
		}
		//System.out.println(secondSmallest);
		
		if(asInArr(secondSmallest, milkValues) > 1) {
			out.println("TIE");
		} else {
			out.println(cowNames[positionOf(secondSmallest, milkValues)]);
		}
		
		
		
		out.close();
	}
	
		
	public static int asInArr(int a, int[] arr) {
		int returnval = 0;
		for(int c = 0; c < arr.length; c++) {
			if(arr[c] == a) {
				returnval++;
			}
		}
		return returnval;
	}
	
	public static int positionOf(String str, String[] cowNames) {
		int returnval = 0;
		
		for(int c = 0; c < cowNames.length; c++) {
			if(cowNames[c].equals(str)) {
				returnval = c;
				break;
			}
		}
		
		return returnval;
	}
	public static int positionOf(int str, int[] cowNames) {
		int returnval = 0;
		
		for(int c = 0; c < cowNames.length; c++) {
			if(cowNames[c] == str) {
				returnval = c;
				break;
			}
		}
		
		return returnval;
	}
	public static int nextEmptyElement(String[] arr) {
		int currPos = 0;
		
		for(int c = 0; c < arr.length; c++) {
			if(arr[c] == null) {
				return c;
			}
		}
		
		return currPos;
	}
	public static Boolean isStrInArr(String str, String[] arr) {
		boolean returnval = false;
		for(int c = 0; c < arr.length; c++) {
			if((arr[c] != null) && (arr[c].equals(str))) {
				returnval = true;
				break;
			}
		}
		return returnval;
	}
}
