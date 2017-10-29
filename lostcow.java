import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class lostcow {
	public static void main(String[] args) throws IOException{
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lostcow.out")));
		int xcoord = 3;
		int bcoord = 6;
		boolean keepLooping = true;
		int stepCount = 0;
		int stepsToTake = 1;
		
		while(keepLooping) {
			for(int c = 0; c < stepsToTake; c++) {
				xcoord++;
				stepCount++;
				System.out.println("X Coordinate: " + xcoord + ". Step Count: " + stepCount);
				if(xcoord == bcoord) {
					keepLooping = false;
					break;
				}
			}
			stepsToTake = stepsToTake * 2;
			for(int c = 0; c < stepsToTake; c++) {
				xcoord--;
				stepCount++;
				System.out.println("X Coordinate: " + xcoord + ". Step Count: " + stepCount);
				
				if(xcoord == bcoord) {
					keepLooping = false;
					break;
				}
			}
			stepsToTake = stepsToTake*2;
		}
		System.out.println(stepCount);
	}
}
