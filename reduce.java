import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class reduce {
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("reduce.in"));
		int points = Integer.parseInt(f.readLine());
		int ymin = Integer.MAX_VALUE;
		int ymax = 0;
		int xmin = Integer.MAX_VALUE;
		int xmax = 0;
		
		int[] xs = new int[points];
		int[] ys = new int[points];
		//Fill Xs and Ys Array
		for(int c = 0; c < points; c++) {
			String newLine = f.readLine();
			StringTokenizer st = new StringTokenizer(newLine);
			xs[c] = Integer.parseInt(st.nextToken());
			ys[c] = Integer.parseInt(st.nextToken());
		}
		int indexOfMinX = 0;
		int indexOfMaxX = 0;
		int indexOfMinY = 0;
		int indexOfMaxY = 0;
		
		//Get biggest and smallest x and y values
		for(int c = 0; c < points; c++) {
			if(xs[c] > xmax) {
				xmax = xs[c];
				indexOfMaxX = c;
			}
			
			if(xs[c] < xmin) {
				xmin = xs[c];
				indexOfMinX = c;
			}
			if(ys[c] > ymax) {
				ymax = ys[c];
				indexOfMaxY = c;
			}
			if(ys[c] < ymin) {
				ymin = ys[c];
				indexOfMinY = c;
			}
		}
		//Make an int[] of xs without the minimum x
		int[] minminxs = new int[points-1];
		for(int c = 0; c < points; c++) {
			if(c != indexOfMinX) {
				minminxs[closestEmpty(minminxs)] = xs[c];
			}
		}
		//Make an int[] of ys without the minimum y
		int[] minminys = new int[points-1];
		for(int c = 0; c < points; c++) {
			if(c != indexOfMinY) {
				minminys[closestEmpty(minminys)] = ys[c];
			}
		}
		
		//Get area of that
		int minminArea = (Math.abs(minArr(minminys)-maxArr(minminys))) * (Math.abs(minArr(minminxs)-maxArr(minminxs)));
		//System.out.println(minminArea);
		
		//Make an int[] of xs without the maximum x
		int[] minmaxxs = new int[points-1];
		for(int c = 0; c < points; c++) {
			if(c != indexOfMaxX) {
				minmaxxs[closestEmpty(minmaxxs)] = xs[c];
			}
		}
		//Make an int[] of ys without the maximum y
		int[] minmaxys = new int[points-1];
		for(int c = 0; c < points; c++) {
			if(c != indexOfMaxY) {
				minmaxys[closestEmpty(minmaxys)] = ys[c];
			}
		}
		//Get area of that
		int minmaxArea = (Math.abs(minArr(minmaxys)-maxArr(minmaxys))) * (Math.abs(minArr(minmaxxs)-maxArr(minmaxxs)));
		
		//output smallest area
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("reduce.out")));
		out.println(Math.min(minminArea, minmaxArea));
		out.close();
	}
	public static int minArr(int[] arr) {
		int returnval = arr[0];
		
		for(int c = 0; c < arr.length; c++) {
			if(arr[c] < returnval) {
				returnval = arr[c];
			}
		}
		
		return returnval;
	}
	public static int maxArr(int[] arr) {
		int returnval = arr[0];
		
		for(int c = 0; c < arr.length; c++) {
			if(arr[c] > returnval) {
				returnval = arr[c];
			}
		}
		
		return returnval;
	}
	public static int closestEmpty(int[]arr) {
		int returnval = 0;
		
		for(int c = 0; c < arr.length; c++) {
			if(arr[c] == 0) {
				returnval = c;
				break;
			}
		}
		
		return returnval;
	}
}
