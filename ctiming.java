import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ctiming {
	public static void main(String[] args) throws IOException{
		int currDay = 11;
		int currHour = 11;
		int currMin = 11;
		BufferedReader f = new BufferedReader(new FileReader("ctiming.in"));
		String newLine = f.readLine();
		f.close();
		StringTokenizer st = new StringTokenizer(newLine);
		int endDay = Integer.parseInt(st.nextToken());
		int endHour = Integer.parseInt(st.nextToken());
		int endMin = Integer.parseInt(st.nextToken());
		int output = 0;
		
		while(currDay != endDay) {
			output +=1440; //1440 = # of mins in a day
			currDay++;
		}
		while(currHour != endHour) {
			output+=60; //60 = # of mins in an hour
			currHour++;
		}
		while(currMin !=endMin) {
			output+=1; //incrementing the minute
			currMin++;
		}
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ctiming.out")));
		out.println(output);
		out.close();
	}
}
