import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class shuffle {
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("shuffle.in"));
		int cowNum = Integer.parseInt(f.readLine());
		int[] shuffle = new int[cowNum];
		String newLine = f.readLine();
		StringTokenizer st1 = new StringTokenizer(newLine);
		newLine = f.readLine();
		String[] after = new String[cowNum];
		StringTokenizer st2 = new StringTokenizer(newLine);
		String[] before = new String[cowNum];
		
		// Load the Cow IDs
		for(int c = 0; c < cowNum; c++) {
			after[c] = st2.nextToken();
		}
		
		// Load the ID Positions
		for(int c = 0; c < cowNum; c++) {
			shuffle[c] = Integer.parseInt(st1.nextToken());
		}
		
		int afterPos = 0;
		for(int  i = 0; i < cowNum; i++) {
			afterPos = wheredidxgo(i+1, shuffle);
			before[i] = after[afterPos-1];
		}
		

		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("shuffle.out")));
		
		for (int x=0; x< shuffle.length; x++) {
			out.println(before[x]);
		}
		out.close();
		
	}
	public static int wheredidxgo(int start, int[] shuffle) {

		for(int i = 0; i < shuffle.length; i++) {
			if(shuffle[i] == start) {
				return i+1;
			}
		}
		return 55;

	}
}
