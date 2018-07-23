import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class mirror {
	static final int UP = 0;
	static final int RIGHT = 1;
	static final int DOWN = 2;
	static final int LEFT = 3;
	
	
	static char[][] field;
	
	
	static int[] fMirrorDirections = {RIGHT,UP,LEFT,DOWN};
	static int[] bMirrorDirections = {LEFT,DOWN,RIGHT,UP};
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("mirror.in"));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		field = new char[height][width];
		
		for(int y = 0; y < height; y++) { //Fill field array
			String inputLine = f.readLine();
			for(int x = 0; x < width; x++) {
				field[y][x] = inputLine.charAt(x);
			}
		}
		f.close();
		int maxMirrors = 0;
		
		//Top to Bottom on the Left
		for(int i = 0; i < field.length; i++) {
			int reflectionCount = shoot(0,i, RIGHT);
			if(reflectionCount > maxMirrors) maxMirrors = reflectionCount;
		}
		//Top to Bottom on the Right
		for(int i = 0; i < field.length; i++) {
			int reflectionCount = shoot(field[0].length-1,i, LEFT);
			if(reflectionCount > maxMirrors) maxMirrors = reflectionCount;
		}
		//System.out.println("LEFT TO RIGHT START HERE");
		//Left to Right on the Top
		for(int i = 0; i < field[0].length; i++) {
			//System.out.println("DEBUG " + i);
			//System.out.println("i: " + i);
			int reflectionCount = shoot(i,0, DOWN);
			if(reflectionCount > maxMirrors) maxMirrors = reflectionCount;
		}
		//Left to Right on the Bottom
		for(int i = 0; i < field[0].length; i++) {
			int reflectionCount = shoot(i,field.length-1, UP);
			if(reflectionCount > maxMirrors) maxMirrors = reflectionCount;
		}
		PrintWriter out = new PrintWriter(new FileWriter("mirror.out"));
		out.println(maxMirrors);
		out.close();
		
	
	}
	public static int shoot(int x, int y, int direction) {
		int mirrors = 1; //Add the mirror
		//System.out.println(x + " " + y + " " + direction);
		//Change the direction from hitting the mirror
		if(field[y][x]=='/') {
			direction = fMirrorDirections[direction];
		}
		else {
			direction = bMirrorDirections[direction];
		}
		
		if(direction == UP) {
			y--;
		} else if(direction == RIGHT) {
			x++;
		} else if(direction == DOWN) {
			y++;
		} else if(direction == LEFT) {
			x--;
		}
		
		if(y <=-1 || x <=-1 || y >= field.length || x >=field[0].length) { //Laser out of field
			return 1;
		}
		
		mirrors+=shoot(x,y,direction);
		
		return mirrors;
	}
	public static void printMatrix(char[][] arr) {
		for(int y = 0; y < arr.length; y++) {
			for(int x = 0; x < arr[0].length; x++) {
				System.out.print(arr[y][x]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
