import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
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
		
		//Get all of the values from the input and assign them to an array
		for(int c = 0; c < grasses; c++) {
			String newLine = f.readLine();
			st = new StringTokenizer(newLine);
			grassValues[c] = Integer.parseInt(st.nextToken());
			distances[c] = Integer.parseInt(st.nextToken());
		}
		
		//Farthest distance for the length of the field
		int fieldLength = 0;
		for(int c = 0; c < grasses; c++) {
			if(distances[c] >fieldLength) fieldLength = distances[c];
		}
		
		int[] grass = new int[fieldLength];
		System.out.println(grassValues.length);
		System.out.println(fieldLength);
		System.out.println(distances.length);
		for(int c = 0; c < distances.length; c++) {
			System.out.println(c);
			grass[distances[c]-1] = grassValues[c];
		} //Got grasses array correct
		
		
		int startCheck = 0;
		int endCheck = cowLimit*2;
		int mostGrass = 0;
		while(endCheck <= fieldLength) {
			int currSum = 0;
			for(int c = startCheck; c < endCheck; c++) {
				currSum+=grass[c];
			}
			if(currSum > mostGrass) mostGrass = currSum;
			startCheck++;
			endCheck++;
		}
		
		System.out.println(mostGrass);
		
		
		
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
