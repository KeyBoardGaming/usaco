import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class cowart {
	
	;
	
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("cowart.in"));
		int dimension = Integer.parseInt(f.readLine());
		boolean[][] isChecked;
		boolean[][] isCowChecked;
		char[][] painting;
		char[][] cowPainting;
		
		painting = new char[dimension][dimension];
		cowPainting = new char[dimension][dimension];
		isChecked = new boolean[dimension][dimension];
		isCowChecked = new boolean[dimension][dimension];
		for(int y = 0; y < painting.length; y++) {
			String newLine = f.readLine();
			for(int x = 0; x < painting[0].length; x++) {
				char newChar = newLine.charAt(x);
				painting[y][x] = newChar;
				
				cowPainting[y][x] = newLine.charAt(x);
				if(newChar == 'R') cowPainting[y][x] = 'G';
				
			}
		}//input painting correctly
		//printMatrix(painting);
		
		//Detect for Human Eyes
		
		int humanGroups = 0;
		for(int y = 0; y < dimension; y++) {
			for(int x = 0; x < dimension; x++) {
				if(!isChecked[y][x]) {
					isChecked[y][x] = true;
					fillGroup(x,y,painting[y][x],isChecked,painting);
					humanGroups++;
				}
			}
		}
		//System.out.println(humanGroups);
		
		//Detect for Cow Eyes
		//printMatrix(cowPainting);
		int cowGroups = 0;
		for(int y = 0; y < dimension; y++) {
			for(int x = 0; x < dimension; x++) {
				if(!isCowChecked[y][x]) {
					isCowChecked[y][x] = true;
					fillGroup(x,y,cowPainting[y][x],isCowChecked,cowPainting);
					cowGroups++;
				}
			}
		}
		//System.out.println(cowGroups);
		PrintWriter out = new PrintWriter(new FileWriter("cowart.out"));
		out.println(humanGroups + " " + cowGroups);
		out.close();
		
	}
	public static void fillGroup(int x, int y, char color, boolean[][] isChecked, char[][] painting) {
		isChecked[y][x] = true;
		
		if(x > 0) {//Check left?
			if((!isChecked[y][x-1]) && (painting[y][x-1]==color)) {
				fillGroup(x-1,y, color,isChecked, painting);
			}
		}
		if(x < painting[0].length-1) { //Check right?
			if(!isChecked[y][x+1] && painting[y][x+1]==color) {
				fillGroup(x+1,y,color,isChecked, painting);
			}
		}
		if(y > 0) {//Check up?
			if(!isChecked[y-1][x] && painting[y-1][x]==color) {
				fillGroup(x,y-1,color,isChecked, painting);
			}
		}
		if(y < painting.length-1) {//Check down?
			if(!isChecked[y+1][x] && painting[y+1][x]==color) {
				fillGroup(x,y+1,color,isChecked, painting);
			}
		}
	}
	public static void printMatrix(char[][] matrix) {
		for(int y = 0;y < matrix.length; y++) {
			for(int x = 0; x < matrix[0].length; x++) {
				System.out.print(matrix[y][x]);
			}
			System.out.println();
		}
	}
}
