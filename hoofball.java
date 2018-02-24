import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class hoofball {
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("hoofball.in"));
		int cowCount = Integer.parseInt(f.readLine());
		String newLine = f.readLine();
		f.close();
		int[] cows = new int[cowCount];
		StringTokenizer st = new StringTokenizer(newLine);
		for(int c = 0; c < cowCount; c++) {
			cows[c] = Integer.parseInt(st.nextToken());
		}
		int forwardLoops = 0;
		//printArr(cows);
		sort(cows);
		//printArr(cows);
		
		for(int c = 1; c < cowCount-1; c++) {
			//System.out.println("Passing in " + cows[c-1] + ", " + cows[c] + ", and " + cows[c+1]);
			if(isForwardLoop(cows[c-1],cows[c],cows[c+1])) {
				//System.out.println("LOOP");
				forwardLoops++;
			} else {
				//System.out.println("NOPE");
			}
		}
		
		
		
		int backwardLoops = 0;
		
		
		//System.out.println("OKAY BACKWARD THIS TIME");
		
		for(int c = cowCount-2; c > 1; c--) {
			//System.out.println("Passing in " + cows[c+1] + ", " + cows[c] + ", and " + cows[c-1]);
			if(isBackwardLoop(cows[c-1],cows[c],cows[c+1])) {
				//System.out.println("LOOP");
				backwardLoops++;
			} else {
				//System.out.println("NOPE");
			}
		}
		//System.out.println("THERE ARE " + backwardLoops + " BACKWARD LOOPS");
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hoofball.out")));
		
		int numToPrint;
		if(forwardLoops > backwardLoops && forwardLoops !=0) {
			numToPrint = forwardLoops;
		} else {
			numToPrint = backwardLoops;
		}
		
		out.println(numToPrint);
		//out.println(forwardLoops + " Forward Loops.");
		out.close();
	}
	public static void printArr(int[] arr) { //WORKS
		for(int c = 0; c < arr.length; c++) {
			System.out.print(arr[c] + " ");
		}
		System.out.println();
	}
	public static void swap(int idx1, int idx2, int[] arr) { //WORKS
		int temp = arr[idx2];
		arr[idx2] = arr[idx1];
		arr[idx1] = temp;
	}
	public static void sort(int[] arr) { //WORKS
		for(int c = arr.length-1; c >=0; c--) {
			for(int i = 0; i < c; i++) {
				if(arr[i] > arr[i+1]) {
					swap(i, i+1, arr);
				}
			}
		}
	}
	public static boolean isForwardLoop(int x, int y, int z) {
		boolean returnval = false;
		
		int distXY = Math.abs(x-y);
		//System.out.println("\t the distance between " + x + " and " + y + " is " + distXY + ".");
		int distYZ = Math.abs(y-z);
		//System.out.println("\t the distance between " + y + " and " + z + " is " + distYZ + ".");
		returnval = (distXY <= distYZ);
		return returnval;
	}
	public static boolean isBackwardLoop(int z, int y, int x) {
		boolean returnval = false;
		
		int distXY = Math.abs(x-y);
		//System.out.println("\t the distance between " + x + " and " + y + " is " + distXY + ".");
		int distYZ = Math.abs(y-z);
		//System.out.println("\t the distance between " + y + " and " + z + " is " + distYZ + ".");
		returnval = (distYZ >= distXY);
		return returnval;
	}
}
