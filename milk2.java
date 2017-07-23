/*
ID: alleneb1
LANG: JAVA
TASK: milk2
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class milk2 {
	public static void main(String[]args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("milk2.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
		
		
		int times = Integer.parseInt(f.readLine());
		//System.out.println(times);
		int[] millkStreaks = new int[1000000/2];/*1000000/2*/
		int biggestMilkStreak = 0;
		int biggestNoMilkStreak = 0;
		String newLine = f.readLine();
		//System.out.println(newLine);
		int[] timeline = new int[1000000];/*1000000*/
		
		
		//Populate Array
		
		for(int i = 0; i < times; i++){
			//System.out.println("In Loop");
			StringTokenizer st = new StringTokenizer(newLine);
			int start = Integer.parseInt(st.nextToken());
			//System.out.println(start);
			int end = Integer.parseInt(st.nextToken());
			//System.out.println(end);
			for(int c = start; c < end; c++){
				timeline[c] = 1;
			}
			newLine = f.readLine();
		}
		//printArr(timeline);
		
		//printArr(timeline);
		//System.out.println("0\t1\t2\t3\t4\t5\t6\t7\t8\t9\t10\t11\t12\t13\t14\t15\t16\t17\t18\t19\t20\t21");
		
		
		//System.out.println(timeline[300]);
		
		//Find the first time of which milking is happening.
		int firstMilking = firstMilk(timeline);
		//System.out.println(firstMilking);
		//Find the last time of which milking is happening.
		int lastMilking = lastMilk(timeline);
		//System.out.println(lastMilking);
		//System.out.println("LAST MILKING EXPECTED 2099: "  + lastMilking);
		
		//Find biggest milking streak
		int currStreak = 0;
		/*
		for(int c = firstMilking; c < timeline.length;c++) {
			if(timeline[c] == 1) {
				int currStreakPos = c;
				while(timeline[currStreakPos] == 1) {
					currStreak++;
					currStreakPos++;
				}
				
				
			}
			
			
			if(currStreak > biggestMilkStreak){
				biggestMilkStreak = currStreak;
			}
			c+=currStreak;
			
		}
		*/
		currStreak = 0;
		for(int c= firstMilking; c <= lastMilking; c++) {
			
			if(timeline[c] == 1) {
				currStreak ++;
				if(currStreak > biggestMilkStreak) {
					biggestMilkStreak = currStreak;
				}
			} else {
				
				currStreak = 0;
			}
		}
		
		//System.out.println(biggestMilkStreak);
		
		//System.out.println("CurrStreak: " + currStreak);
		//System.out.println("Biggest Milk Streak: " + biggestMilkStreak);
		
		
		
		/*
		//Find biggest non milking streak
		for(int c = lastMilking; c > firstMilking;c--) {
			currStreak = 0;
			if(timeline[c] == 0) {
				int currStreakPos = c;
				while(timeline[currStreakPos] == 0) {
					currStreak++;
					currStreakPos--;
				}
				
				
			}
			//Find biggest non milking streak
			if(currStreak > biggestNoMilkStreak){
				biggestNoMilkStreak = currStreak;
			}
			c-=currStreak+1;
			
		}*/
		
		
		
		
		currStreak = 0;
		for(int c= firstMilking; c <= lastMilking; c++) {
			
			if(timeline[c] == 0) {
				currStreak++;
				if(currStreak > biggestNoMilkStreak) {
					biggestNoMilkStreak = currStreak;
				}
			} else {
				
				currStreak = 0;
			}
		}
		
		
		//System.out.println(biggestNoMilkStreak);
		
		
		
		//Print biggiest milking streak and the biggest non milking streak
		//System.out.println("Milk: " + (biggestMilkStreak-1) + " No Milk: " + (biggestNoMilkStreak+2));
		out.println((biggestMilkStreak) +" " +  (biggestNoMilkStreak));
		
		
		f.close();
		out.close();
	}
	public static int lastMilk(int[] arr) {
		int returnval = arr.length-1;
		for(int c = arr.length-1;c > 0; c--) {
			if(arr[c] == 1) {
				returnval = c;
				break;
			}
			/*else {
				returnval--;
			}
			*/
		}
		return returnval;
	}
	public static int firstMilk(int[]arr){
		int returnval=0;
		
		for(int c=0;c<arr.length;c++){
			if(arr[c] == 1) {
				returnval = c;
				break;
			} /*else{
				returnval++;
			}
			*/
		}
		
		return returnval;
	}
	public static void printArr(int[] arr) {
		for(int  c =0; c < arr.length; c++) {
			System.out.print(arr[c]);
			System.out.print("\t");
		}
		System.out.println();
	}
	public static void say(String str) {
		System.out.println(str);
	}
}
