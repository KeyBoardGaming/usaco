import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class measurement {
	static int[] BEM = new int[3];
	public static void main(String[] args) throws IOException{
		int output = 0;
		BufferedReader f = new BufferedReader(new FileReader("measurement.in"));
		boolean[] isPictured = new boolean[3];
		boolean[] isPicturedBC = new boolean[3];
		int linesOfInput = Integer.parseInt(f.readLine());
		
		
		//INCLUDE DAYS!!!!!!!!!!
		
		
		
		for(int z = 0; z < linesOfInput; z++) {
			boolean update = false;
			String newLine = f.readLine();
			StringTokenizer st = new StringTokenizer(newLine);
			String currCow = st.nextToken();
			System.out.println(currCow);
			
			String value = st.nextToken();
			updateBEM(currCow, value); //Increses or decreases the total amount of each cow's milk.
			
			int maxMilkVal = Math.max(BEM[0], BEM[1]);
			maxMilkVal = Math.max(maxMilkVal, BEM[2]); //Finds the greatest amount of milk produced.
			
			
			for(int c = 0; c < BEM.length; c++) { //Update if each cow is pictured.
				if(BEM[c] >= maxMilkVal) {
					isPicturedBC[c] = true;
				}
			}
			
			for(int c = 0; c < BEM.length; c++) { //See if the pictured list has been updated.
				if(isPicturedBC[c] != isPictured[c]) {
					update = true;
				}
			}
			for(int c = 0; c < BEM.length; c++) { //Update the official pictured array
				isPictured[c] = isPicturedBC[c];
			}
			if(update) {
				output++;
			}
			
			System.out.println(output);
		}
	}
	public static void updateBEM(String currCow, String value) {
		//Decide which index to change
		int updateIndex = 0;
		if(currCow.equals("Elsie")) {
			updateIndex = 1;
		} else if(currCow.equals("Mildred")){
			updateIndex = 2;
		}
		String noOpVal = noOp(value);
		if(value.charAt(0) == '-') {
			BEM[updateIndex] -= Integer.parseInt(noOpVal);
		} else {
			//System.out.println(noOpVal);
			BEM[updateIndex] += Integer.parseInt(noOpVal);
		}
	}
	public static String noOp(String value) {
		String newString = "";
		for(int c = 1; c < value.length(); c++) {
			newString = newString + value.charAt(c);
		}
		
		
		return newString;
	}
}
