import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class billboard {
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("billboard.in"));
		
		///Make and assign variables
		//The X1s have their own arrays
		int[] x1 = new int[3];
		//The X2s have their own arrays
		int[] x2 = new int[3];
		//The Y1s have their own arrays
		int[] y1 = new int[3];
		//The Y2s have their own arrays
		int[] y2 = new int[3];
		
		//Repeat for each line of input
		for(int c = 0; c < 3; c++) {
			//Assign the variables
			String newLine = f.readLine();
			StringTokenizer st = new StringTokenizer(newLine);
			x1[c] = Integer.parseInt(st.nextToken());
			x2[c] = Integer.parseInt(st.nextToken());
			y1[c] = Integer.parseInt(st.nextToken());
			y2[c] = Integer.parseInt(st.nextToken());
		}
		///////NOTE: ARRAY[0] = BOARD 1, [1] = BOARD 2, [2] = TRUCK
		
		int B1MinY = Math.min(y1[0],y2[0]);
		int B1MaxY = Math.max(y1[0],y2[0]);
		
		int B1MinX = Math.min(x1[0],x2[0]);
		int B1MaxX = Math.max(x1[0],x2[0]);
		
		
		
		int B2MinY = Math.min(y1[1],y2[1]);
		int B2MaxY = Math.max(y1[1],y2[1]);
		
		int B2MinX = Math.min(x1[1],x2[1]);
		int B2MaxX = Math.max(x1[1],x2[1]);

		
		
		int TMinY = Math.min(y1[2],y2[2]);
		int TMaxY = Math.max(y1[2],y2[2]);
		
		int TMinX = Math.min(x1[2],x2[2]);
		int TMaxX = Math.max(x1[2],x2[2]);
		
		//int output = ((Math.abs(x1[0]-x2[0]))*(Math.abs(y1[0]-y2[0]))) + ((Math.abs(x1[1]-x2[1]))*(Math.abs(y1[1]-y2[1])));//The Areas Combined
		
		int output = 0;//FIX THE AREA IT IS WRONG. ALSO THE OUTPUT ISN'T BEING SUBTRACTED.
		
		System.out.println(output);
		for(int c = B1MinY; c < B1MaxY; c++) {
			for(int i = B1MinX; i < B1MaxX; i++) {
				if(inBetweenC(c,TMinY,TMaxY)) { //If it is in between the top and bottom
					if(inBetweenC(c,TMinX,TMaxX)) { //If it is in between the left and right
						output--;
					}
				}
			}
		}
		for(int c = B2MinY; c < B2MaxY; c++) {
			for(int i = B2MinX; i < B2MaxX; i++) {
				if(inBetweenC(c,TMinY,TMaxY)) { //If it is in between the top and bottom
					if(inBetweenC(c,TMinX,TMaxX)) { //If it is in between the left and right
						output--;
					}
				}
			}
		}
		System.out.println(output);
	}
	public static boolean inBetweenC(int a, int min, int max) {
		return(a >= min && a<=max);
	}
}
