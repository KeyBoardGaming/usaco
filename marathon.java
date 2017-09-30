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
		for(int removedElement = 0; removedElement < linesOfInput; removedElement++) {
			int[] newxs = new int[linesOfInput];
			int[] newys = new int[linesOfInput];
			for(int c = 0; c < linesOfInput; c++) {
				newxs[c] = xs[c];
				newys[c] = ys[c];
			}
			newxs[removedElement] = 0;
			newys[removedElement] = 0;
			int newDistance = 0;
			for(int c = 0; c < linesOfInput-1; c++) {
				newDistance+= distance(newxs[c], newys[c], newxs[c+1], newys[c+1]);
			}
			totalDistances[nextEmpty(totalDistances)] = newDistance;
		}
		System.out.println(theGreatest(totalDistances));
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
