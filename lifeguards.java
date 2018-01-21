import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class lifeguards {
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("lifeguards.in"));
		int lifeguardCount = Integer.parseInt(f.readLine());
		int[] starts = new int[lifeguardCount];
		int[] ends = new int[lifeguardCount];
		int[] newTimes = new int[lifeguardCount];
		int totalTimes = 0;
		for(int c = 0; c < lifeguardCount; c++) {
			String newLine = f.readLine();
			StringTokenizer st = new StringTokenizer(newLine);
			starts[c] = Integer.parseInt(st.nextToken());
			ends[c] = Integer.parseInt(st.nextToken());
		}
		boolean[] time = new boolean[1000]; //Each element contains the value of whether someone's there or not
		for(int c = 0; c < lifeguardCount; c++) {
			for(int i = starts[c]; i < ends[c]; i++) {
				totalTimes++;
				if(!time[i]) { //If no one's been here before
					time[i] = true;
					newTimes[c]++;
				}
			}
		}
		//printArr(newTimes);
		int beforeSubtractOutput = 0;
		for(int c = 0; c < lifeguardCount; c++) {
			beforeSubtractOutput+=newTimes[c];
		}
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));
		out.println(beforeSubtractOutput-theLeast(newTimes));
		out.close();
	}
	public static void printArr(int[] arr) {
		for(int c = 0; c < arr.length; c++) {
			System.out.println(arr[c]);
		}
	}
	public static int theLeast(int[] arr) {
		int least = arr[0];
		for(int c = 0; c < arr.length; c++) {
			if (arr[c] < least) {
				least = arr[c];
			}
		}
		return least;
	}
}
