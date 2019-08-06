package basic01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
//https://yhs1981.tistory.com/entry/StreamWriter%EC%99%80-StreamReader-%EC%B4%88%EB%B3%B4%EC%9E%90%EB%B6%84%EB%93%A4%EB%A7%8C-%EB%B3%B4%EC%84%B8%EC%9A%94
public class BasicIo {
	 
	private static void ScannerFunc(){
		Scanner scanner = new Scanner(System.in);
		String myString = scanner.next();
		int myInt = scanner.nextInt();
		scanner.close();
		
		System.out.println(myString);
		System.out.println(myInt);
	}
	private static void BufferedRWFunc() {
		
		//글자 한 개
		InputStreamReader isr = new InputStreamReader(System.in);
		//글자 여러 개
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			String line = br.readLine();
			
			bw.write(line);
			bw.flush();
			bw.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {
		BufferedRWFunc();
	}
}
