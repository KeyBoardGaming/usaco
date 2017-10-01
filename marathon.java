import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class marathon {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("marathon.in"));
		int linesOfInput = Integer.parseInt(f.readLine());
		int[] totalDistances = new int[linesOfInput];
		int[] xs = new int[linesOfInput];
		int[] ys = new int[linesOfInput];
		for(int c = 0; c < linesOfInput; c++) {
			StringTokenizer st = new StringTokenizer(f.readLine());
			xs[c] = Integer.parseInt(st.nextToken());
			ys[c] = Integer.parseInt(st.nextToken());
		}
		int newDistance = 0;
		int[][] removedXs = new int[linesOfInput-1][linesOfInput]; 
		int[][] removedYs = new int[linesOfInput-1][linesOfInput];
		/*
		for(int removedElement = 0; removedElement < linesOfInput; removedElement++) {
			int[] newxs = new int[linesOfInput];
			int[] newys = new int[linesOfInput];
			for(int c = 0; c < linesOfInput; c++) {
				newxs[c] = xs[c];
				newys[c] = ys[c];
			}
			newxs[removedElement] = 0;
			newys[removedElement] = 0;
			
			for(int c = 0; c < linesOfInput-1; c++) {
				newDistance+= distance(newxs[c], newys[c], newxs[c+1], newys[c+1]);
			}
			totalDistances[nextEmpty(totalDistances)] = newDistance;
		}
		System.out.println(theGreatest(totalDistances));
		*/
		int row = 0;
		for(int fe = 0; fe < linesOfInput; fe++) {
			for(int c = 0; c < linesOfInput; c++) {
				if(c != fe) {
					removedXs[row][fe] = xs[c];
					row++;
				}
			}
			row = 0;
		}
		printMatrix(removedXs);
		row = 0;
		for(int fe = 0; fe < linesOfInput; fe++) {
			for(int c = 0; c < linesOfInput; c++) {
				if(c != fe) {
					removedYs[row][fe] = ys[c];
					row++;
				}
			}
			row = 0;
		}
		System.out.println();
		printMatrix(removedYs);
		/*
		for(int y = 0; y< linesOfInput-1; y++) { //Start Paste on THIS LINE
			for(int x = 0; x < linesOfInput-1; x++) {
				int currDistance = 0;
				for(int c = 0; c < linesOfInput; c++) {
					currDistance += distance(removedXs[y][x],removedYs[y][x],removedXs[y+1][x], removedYs[y+1][x]);
				}
				totalDistances[nextEmpty(totalDistances)] = currDistance;
			}
		} //End Paste on THIS LINE
		*/
		//System.out.println(theGreatest(totalDistances));
		for(int c = 0; c < linesOfInput; c++) {
			int currDistance = 0;
			for(int i = 0; i < linesOfInput-2; i++) {
				currDistance+=distance(removedXs[i][c], removedYs[i][c], removedXs[i+1][c], removedYs[i+1][c]);
			}
			totalDistances[nextEmpty(totalDistances)] = currDistance;
		}
		System.out.println();
		System.out.println(theLeast(totalDistances));
		
	}
	public static void printMatrix(int[][] matrix) {
		for(int c = 0; c < matrix.length; c++) {
			for(int f = 0; f < matrix[0].length; f++) {
				System.out.print(matrix[c][f] + " ");
			}
			System.out.println();
		}
	}
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