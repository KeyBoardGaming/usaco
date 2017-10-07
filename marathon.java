import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class marathon {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("marathon.in"));
		int linesOfInput = Integer.parseInt(f.readLine());
		//int[] totalDistances = new int[linesOfInput];
		Checkpoint[] checkpoints  = new Checkpoint[linesOfInput];
		for(int c = 0; c < linesOfInput; c++) {
			String newLine = f.readLine();
			StringTokenizer st = new StringTokenizer(newLine);
			checkpoints[c] = new Checkpoint();
			checkpoints[c].x = Integer.parseInt(st.nextToken());
			checkpoints[c].y = Integer.parseInt(st.nextToken());
		}
		/*
		for(int c=0;c< linesOfInput ;c++) {
			checkpoints[c].printPair();
		}
		*/
		int row = 0;
		Checkpoint[][] paths = new Checkpoint[linesOfInput-1][linesOfInput-2];
		for(int c = 0; c < linesOfInput-1; c++) {
			for(int i = 0; i < linesOfInput-2; i++) {
				paths[c][i] = new Checkpoint();
			}
		}
		int ignorePos = 1;
		for(int path  = 0; path < paths[0].length; path++) {
			for(int checkpoint = 0; checkpoint < checkpoints.length; checkpoint++) {
				if(checkpoint !=ignorePos) {
					paths[row][path] = checkpoints[checkpoint];
					row++;
				}
			}
			row = 0;
			ignorePos++;
		}
		/*
		for(int c = 0; c < linesOfInput-2; c++ ) {
			for(int i = 0; i < linesOfInput-1; i++) {
				paths[i][c].printPair();
			}
		}
		*/
		int[] distances = new int[linesOfInput-2];
		for(int c = 0; c < distances.length; c++) {
			int currDistance = 0;
			for(int i = 0; i < linesOfInput-2; i++) {
				currDistance+=distance(paths[i][c].x,paths[i][c].y,paths[i+1][c].x,paths[i+1][c].y);
			}
			distances[c] = currDistance;
		}
		//System.out.println();
		f.close();
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("marathon.out")));
		out.println(theLeast(distances));
		out.close();
		//printMatrix(paths);
		
		
		
	}
	public static void printMatrix(Checkpoint[][] matrix) {
		for(int c = 0; c < matrix.length; c++) {
			for(int f = 0; f < matrix[0].length; f++) {
				matrix[c][f].printPair();
			}
			System.out.println();
		}
	}
	/*
	public static void printMatrix(int[][] matrix) {
		for(int c = 0; c < matrix.length; c++) {
			for(int f = 0; f < matrix[0].length; f++) {
				System.out.print(matrix[c][f] + " ");
			}
			System.out.println();
		}
	}
	*/
	public static int theGreatest(int[] arr) {
		int greatest = arr[0];
		for(int c = 0; c < arr.length; c++) {
			if(arr[c] > greatest) {
				greatest = arr[c];
			}
		}
		return greatest;
	}
	public static int theLeast(int[] arr) {
		int least = theGreatest(arr);
		
		for(int c = 0; c < arr.length; c++) {
			if(arr[c] < least) {
				least = arr[c];
			}
		}
		
		return least;
	}
	public static void printArr(int[] arr) {
		for(int c = 0; c < arr.length; c++) {
			System.out.print(arr[c] + " ");
		}
		System.out.println();
	}
	public static int nextEmpty(int[] arr) {
		int returnval = 0;
		for(int c = 0; c < arr.length; c++) {
			if(arr[c] == 0) {
				returnval = c;
				break;
			}
		}
		return returnval;
	}
	public static int distance(int x1, int y1, int x2, int y2) {
		int distance = 0;
		
		distance = ((int)(Math.abs(x1-x2)) + (int)(Math.abs(y1-y2)));
		
		return distance;
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