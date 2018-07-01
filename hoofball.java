import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class hoofball {
	//Initialize the array of cows
	static int[] cowArr = new int[0];
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("hoofball.in"));
		int cowCount = Integer.parseInt(f.readLine());
		
		//Give the cow array the amount of cows
		cowArr = new int[cowCount];
		
		//variable that is outputted
		int output = 0;
		
		//Give the values to the cow array
		StringTokenizer st = new StringTokenizer(f.readLine());
		for(int c = 0; c < cowCount; c++) {
			int x = Integer.parseInt(st.nextToken());
			cowArr[c] = x;
		}
		f.close();
		//Sort the array
		sort(cowArr);
		//printArr(cowArr);
		
		//Check for the inner cows
		/*for(int i = 2; i < cowCount-3; i++) {
			//System.out.println("Is " + Math.abs(cowArr[i] - cowArr[i+1]) + " less than " + Math.abs(cowArr[i+1] - cowArr[i+2]) + "?");
			System.out.println(isPassedToFromRight(i));
			if(!((isPassedToFromRight(i)) || (isPassedToFromLeft(i)))) {
				output++;
			}
		}
		*/
		
		for(int i = 0; i < cowArr.length; i++) {
			if(timesPassedTo(i) == 0 || (isLoop(i))){//If the cow is not being passed to
				output++;
			}
		}
		
		
		
		
		/*
		//Check the endpoint cows
		if(!isPassedToFromRight(0)) output++;
		if(!isPassedToFromLeft(cowCount-1)) output++;
		*/
		
		PrintWriter out = new PrintWriter(new FileWriter("hoofball.out"));
		out.println(output);
		out.close();
		
	}
	public static boolean isLoop(int cow) { //Returns if it's the BEGINNING of a loop
		if(cow == cowArr.length -1) return false;
		if((passDestination(cow) == cow+1 && passDestination(cow+1) == cow) && (timesPassedTo(cow) == 1 && timesPassedTo(cow+1) == 1)) return true; //If the cow inputted is the beginning of a loop
		return false;
	}
	
	public static int timesPassedTo(int cow) { //Returns the number of times a cow passes to it
		//Cow is the cow that we check how many times it is passed to
		
		int returnval = 0;
		if(cow !=0 && passDestination(cow-1) == cow) returnval++;
		if(cow !=cowArr.length-1 && passDestination(cow+1) == cow) returnval++;
		
		return returnval;
	}
	
	public static int passDestination(int cow) { //Returns the index
		//Cow is the cow that we check where it throws to
		if(cow == 0) return cow+1;
		if(cow == cowArr.length-1) return cow-1;
		if(Math.abs(cowArr[cow-1] - cowArr[cow]) > Math.abs(cowArr[cow+1]-cowArr[cow])) {
			//The cow throws to the cow in front of it
			return cow+1;
		} else return cow-1;
		
		
	}
	
	
	public static boolean isPassedToFromLeft(int x) {
		int p = x;
		x = cowArr[p];
		int y = cowArr[p-1];
		int z = cowArr[p-2];
		if(Math.abs(x - y) < Math.abs(y-z)) return true;
		return false;
	}
	
	//If x is passed to from y
	public static boolean isPassedToFromRight(int x) {
		int p = x;
		x = cowArr[p];
		int y = cowArr[p+1];
		int z = cowArr[p+2];
		//if the distance from x to y is greater than the distance from y to z
		if((Math.abs(x - y) < Math.abs(y-z)) || (Math.abs(x-y) == Math.abs(y-z) )) return true;
		return false;
	}
	
	public static void printArr(int[] arr) { //WORKS
		for(int c = 0; c < arr.length; c++) {
			System.out.print(arr[c] + " ");
		}
		System.out.println();
	}
	public static void sort(int arr[]) {
    
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1])
                {
                    // swap temp and arr[i]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
    }
}
