import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class auto {
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("auto.in"));
		String inputString = f.readLine();
		StringTokenizer st = new StringTokenizer(inputString);
		int dictionaryLength = Integer.parseInt(st.nextToken());
		int prefixCount = Integer.parseInt(st.nextToken());
		
		String[] dictionary = new String[dictionaryLength];
		
		for(int c=0; c < dictionaryLength; c++) {
			dictionary[c] = f.readLine();
		}
		
		String[] prefixes = new String[prefixCount];
		int[] Ks = new int[prefixCount];
		
		
		for(int c = 0; c < prefixCount; c++) {
			inputString = f.readLine();
			st = new StringTokenizer(inputString);
			Ks[c] = Integer.parseInt(st.nextToken());
			prefixes[c] = st.nextToken();
		}
		f.close();
		String[] alphabetizedDictionary = new String[dictionaryLength];
		
		for(int c = 0; c < dictionaryLength; c++) {
			alphabetizedDictionary[c] = dictionary[c];
		}
		Arrays.sort(alphabetizedDictionary);
		printArr(alphabetizedDictionary);
		PrintWriter out = new PrintWriter(new FileWriter("auto.out"));
		for(int c = 0; c < prefixCount; c++) {
			int countToK = 0;
			String prefix = prefixes[c];
			int K = Ks[c];
			for(int i = 0; i < dictionaryLength; i++) {
				if(alphabetizedDictionary[i].length() >=prefix.length() && alphabetizedDictionary[i].substring(0,prefix.length()).equals(prefix)) {
					
					countToK++;
					
					if(countToK == K) {
						out.println(indexOf(alphabetizedDictionary[i], dictionary)+1); //It's +1 because indexOf returns the index of the string in the array, which means that the first one is 0, but the first one is 1 for the solution
						break;
					
					}
					
					
					
					
				}
				
				
			}
			if(countToK < K) out.println(-1);
		}
		out.close();
		
		
		
	}
	public static int indexOf(String str, String[] arr) {
		for(int c = 0; c < arr.length; c++) {
			if(arr[c].equals(str)) return c;
		}
		return 55;
	}
	public static void printArr(String[] arr) {
		for(int c = 0; c < arr.length; c++) {
			System.out.print(arr[c] + " ");
		}
		System.out.println();
	}
}
