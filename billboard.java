import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class billboard {
	static int feedX1;
	static int feedY1;
	static int feedX2;
	static int feedY2;
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("billboard.in"));
		StringTokenizer st = new StringTokenizer(f.readLine());
		
		int lawnX1 = Integer.parseInt(st.nextToken());
		int lawnY1 = Integer.parseInt(st.nextToken());
		int lawnX2 = Integer.parseInt(st.nextToken());
		int lawnY2 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(f.readLine());
		feedX1 = Integer.parseInt(st.nextToken());
		feedY1 = Integer.parseInt(st.nextToken());
		feedX2 = Integer.parseInt(st.nextToken());
		feedY2 = Integer.parseInt(st.nextToken());
		f.close();
		
		int tarpWidth = 0;
		int tarpHeight = 0;
		
		for(int y = lawnY1; y < lawnY2; y++) {
			boolean rowCoveredCompletely = true;
			for(int x = lawnX1; x < lawnX2; x++) {
				
				if(!isCovered(x,y)) { //if the current spot is not covered by the feed billboard
					rowCoveredCompletely = false;
					break;
				}
				
			}
			if(!rowCoveredCompletely) tarpHeight++;
		}
		
		
		for(int x = lawnX1; x < lawnX2; x++) {
			boolean columnCoveredCompletely = true;
			for(int y = lawnY1; y < lawnY2; y++) {
				
				if(!isCovered(x,y)) { //if the current spot is not covered by the feed billboard
					columnCoveredCompletely = false;
					break;
				}
				
			}
			if(!columnCoveredCompletely) tarpWidth++;
		}
		System.out.println("Width: "  +tarpWidth + " Height: " + tarpHeight);
		PrintWriter out = new PrintWriter(new FileWriter("billboard.out"));
		out.println(tarpWidth * tarpHeight);
		out.close();
		
	}
	public static boolean isCovered(int x3, int y3) {
		return (feedX1 < x3 && x3 < feedX2) && (feedY1 < y3 && y3 < feedY2);
	}
}
