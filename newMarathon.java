package forClasses;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class newMarathon {
	public static void main(String[] args) throws IOException{
		
		
		BufferedReader f = new BufferedReader(new FileReader("marathon.in"));
		int linesOfInput = Integer.parseInt(f.readLine());
		//Make a checkpoint array and fill it with empty checkpoints
		Checkpoint[] checkpoints = new Checkpoint[linesOfInput];
		for(int c = 0; c < linesOfInput; c++) {
			checkpoints[c] = new Checkpoint();
		}
		
		//Give values to every checkpoint in the checkpoints array
		for(int c = 0; c < linesOfInput; c++) {
			String newLine = f.readLine();
			StringTokenizer st = new StringTokenizer(newLine);
			checkpoints[c].x = Integer.parseInt(st.nextToken());
			checkpoints[c].y = Integer.parseInt(st.nextToken());
		}
		
		
		// BEGIN DAD
		int myDistance = 0;
		for (int i=0; i<checkpoints.length - 1; i++) {
			printPoints(checkpoints[i], checkpoints[i+1]);
			myDistance = distanceCalc(checkpoints[i], checkpoints[i+1]);
			System.out.println("\t" + myDistance);
		}
		
		// END DAD
		
		
		//This is the index of the checkpoint that is farthest away from the checkpoints around it.
		int greatestDistanceCheckPointIndex = 1;
		int greatestDistanceCheckPointValue = 0;
		for(int c = 1/*1 because we can't take out the first one. */; c < linesOfInput-1/*-1 because we stop right before the last one, because we can't remove it.*/; c++) {
			int currDistances = distanceCalc(checkpoints[c].x,checkpoints[c].y, checkpoints[c-1].x,checkpoints[c-1].y) + distanceCalc(checkpoints[c].x,checkpoints[c].y, checkpoints[c+1].x,checkpoints[c+1].y);
			//System.out.println("("+ checkpoints[c].x + ", " + checkpoints[c].y + ")" + "\t" + "("+ checkpoints[c-1].x + ", " + checkpoints[c-1].y + ")" + "\t" +" " + currDistances);
			if(currDistances > greatestDistanceCheckPointValue) {
				greatestDistanceCheckPointValue = currDistances;
				greatestDistanceCheckPointIndex = c;
			}
		}
		//Go through each thing again and count how many checkpoints are as far away as the max
		int numOfGreatDistances = 0;
		for(int c = 1/*1 because we can't take out the first one. */; c < linesOfInput-1/*-1 because we stop right before the last one, because we can't remove it.*/; c++) {
			int currDistances = distanceCalc(checkpoints[c].x,checkpoints[c].y, checkpoints[c-1].x,checkpoints[c-1].y) + distanceCalc(checkpoints[c].x,checkpoints[c].y, checkpoints[c+1].x,checkpoints[c+1].y);
			//System.out.println("("+ checkpoints[c].x + ", " + checkpoints[c].y + ")" + "\t" + "("+ checkpoints[c-1].x + ", " + checkpoints[c-1].y + ")" + "\t" +" " + currDistances);
			if(currDistances == greatestDistanceCheckPointValue) {
				numOfGreatDistances++;
			}
		}
		System.out.println("numOfGreatDistances" + numOfGreatDistances);
		System.out.println(greatestDistanceCheckPointIndex);
		System.out.println(checkpoints[greatestDistanceCheckPointIndex].x + " " + checkpoints[greatestDistanceCheckPointIndex].y);
		int distance = 0;
		int pathIdx = 0;
		Checkpoint[] includedCheckpoints = new Checkpoint[checkpoints.length-1];
		for(int c = 0; c < checkpoints.length; c++) {
			if(c!=greatestDistanceCheckPointIndex) {
				includedCheckpoints[pathIdx] = checkpoints[c];
				pathIdx++;
			}
		}
		//printArr(includedCheckpoints);
		
		distance = arrLength(includedCheckpoints);
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("marathon.out")));
		out.println(distance);
		out.close();
	}
	public static int arrLength(Checkpoint[] arr) {
		int distance = 0;
		for(int c = 0; c < arr.length-1; c++) { //includedCheckpoints.length-1 because we exclude one of the checkpoints and we find the distance of the current checkpoint and the next one.
			distance+=distanceCalc(arr[c], arr[c+1]);
		}
		return distance;
	}
	public static int distanceCalc(Checkpoint a, Checkpoint b) {
		return distanceCalc(a.x, a.y, b.x, b.y);
	}
	
	public static int distanceCalc(int x1, int y1, int x2, int y2) {
		return (int) (Math.abs(x1-x2) + (int) Math.abs(y1-y2));
	}
	public static void printArr(Checkpoint[] arr) {
		for(int c = 0; c < arr.length; c++) {
			System.out.print("(" +arr[c].x + "," + arr[c].y+")");
		}
	}
	
	public static void printPoint(Checkpoint checkpoint) {
		System.out.print(checkpoint.x + ", " + checkpoint.y);
	}
	
	public static void printPoints(Checkpoint a, Checkpoint b) {
		printPoint(a);
		System.out.print("\t");
		printPoint(b);
	}
}
class Checkpoint {
	int x;
	int y;

	public void printX() {
		System.out.println(x);
	}
	public void printY() {
		System.out.println(y);
	}
	public void printPair() {
		System.out.println(x + " " + y);
	}
} //Checkpoint
