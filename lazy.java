import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class lazy {
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("lazy.in"));
		String NK = f.readLine();
		StringTokenizer st = new StringTokenizer(NK);
		int grasses = Integer.parseInt(st.nextToken());
		int cowLimit = Integer.parseInt(st.nextToken());
		int[] distances = new int[grasses];
		int[] grassValues = new int[grasses];
		//Farthest distance for the length of the field
		int fieldLength = 0;
		
		//Get all of the values from the input and assign them to an array
		for(int c = 0; c < grasses; c++) {
			String newLine = f.readLine();
			st = new StringTokenizer(newLine);
			grassValues[c] = Integer.parseInt(st.nextToken());
			int nextPos = Integer.parseInt(st.nextToken());
			if(nextPos > fieldLength) fieldLength = nextPos;
			distances[c] = nextPos;
		}
		
		
		
		
		int[] grass = new int[fieldLength+1];
		//System.out.println(distances.length);
		//System.out.println(grassValues.length);
		//System.out.println(distances[251]);
		//System.out.println(fieldLength);
	
		//System.out.println(grass[(distances[251])-1]);
		
		for(int c = 0; c < distances.length; c++) {
			//System.out.println(distances[c]);
			grass[(distances[c])] = grassValues[c];
		} //Got grasses array correct
		
		//printArr(grass);
		//System.out.println("done assignning values");
		int startCheck = 0;
		int endCheck = cowLimit*2;
		if(endCheck > grass.length) endCheck = grass.length-1;
		int mostGrass = 0;
		int bodyVal = 0;
		bodyVal+=grass[startCheck];
		//System.out.println(endCheck);
		bodyVal+=grass[endCheck];
		for(int c = startCheck+1; c < endCheck-1; c++) {
			bodyVal+=grass[c];
		}
		while(endCheck <= fieldLength) {
			
			
			
			
			
				/*
			int currSum = 0;
			//System.out.println("From " + startCheck + " to " + endCheck + ": " + currSum);
			for(int c = startCheck; c <= endCheck; c++) {
				currSum+=grass[c];
				//System.out.println("Adding " + grass[c]);
				
			}
			
			if(currSum > mostGrass) {
				mostGrass = currSum;
				
			}
			*/
			//Check for if this is the most grass
			if(bodyVal >mostGrass) {
				mostGrass = bodyVal;
			}
			
			//Shifting the range
			bodyVal-=grass[startCheck];	
			if(endCheck < fieldLength) bodyVal+=grass[endCheck+1];
			
			
			startCheck++;
			endCheck++;
			
		}
		
		//System.out.println(mostGrass);
		
		PrintWriter out = new PrintWriter(new FileWriter("lazy.out"));
		out.println(mostGrass);
		out.close();
		
		//printArr(grass);
	}
	
	public static void printArr(int[] arr) {
		for(int c = 0; c < arr.length; c++) {
			System.out.print(arr[c] + " ");
		}
		System.out.println();
	}
	public static int findIndexOf(int x, int[] arr) {
		for(int c =0; c < arr.length; c++) {
			if(arr[c] == x) return c;
		}
		return 55;
	}
}