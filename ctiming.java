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
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ctiming.out")));
		
		
		if((endDay < currDay) || (endHour < currHour && endDay == currDay) || (endMin < currMin && endHour == currHour && endDay == currDay)) {
			out.println("-1");
		} else {
			out.println(((endDay - currDay)*1440) + ((endHour - currHour)*60) +((endMin - currMin)));
		}
		out.close();
	}
}
