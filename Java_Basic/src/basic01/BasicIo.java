package basic01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;
//https://yhs1981.tistory.com/entry/StreamWriter%EC%99%80-StreamReader-%EC%B4%88%EB%B3%B4%EC%9E%90%EB%B6%84%EB%93%A4%EB%A7%8C-%EB%B3%B4%EC%84%B8%EC%9A%94
/*
 *   Java Stream (�ܹ���)
 *   - ����
 *   - Ű����, �����
 *   - �޸�
 *   - ��Ʈ��ũ ����
 *   
 *   *-stream: ����Ʈ ������ ������ϴ� Ŭ����
 *   *-reader/writer: ĳ���� ������ ������ϴ� Ŭ����
 *   file-*: �ϵ��ũ�� ������ ����ϴ� Ŭ����
 *   data-*: �ڹ��� ���� �ڷ����� ����ϱ� ���� Ŭ����
 *   buffered-*: �ý����� ���۸� ����ϴ� Ŭ����
 *   
 */
public class BasicIo {
	private static Path path = Paths.get("C:\\Users\\saein\\git\\Java_basic\\Java_Basic\\src\\sources\\data1.txt");
	private static Path path2 = Paths.get("C:\\Users\\saein\\git\\Java_basic\\Java_Basic\\src\\sources\\data2.txt");
	
	private static void ScannerFunc(){
		Scanner scanner = new Scanner(System.in);
		String myString = scanner.next();
		int myInt = scanner.nextInt();
		scanner.close();
		
		System.out.println(myString);
		System.out.println(myInt);
	}
	private static void bufferedRWFunc() {
		
		//���� �� ��
		InputStreamReader isr = new InputStreamReader(System.in);
		//���� ���� ��
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
	
	private static void fileR() {
		/*
		 * StringBuilder  : ���ڿ��� ���� ��, ���� ��ü�� ����� �� �ƴ϶� append�� �ٿ��ֹǷ� �뷮�� �۴�.
		 * StringBuffered :��Ƽ������ ȯ�濡�� �ٸ� ���� �������� ���ϵ��� �ϹǷ� web�̳� socketȯ��� ���� �񵿱�� �����ϴ� ��찡 ���� ��, ���
		 * https://www.mkyong.com/java/how-to-read-file-from-java-bufferedreader-example/
		 * 
		 */
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = Files.newBufferedReader(path)){
			String line;
			while((line = br.readLine()) != null) {
				sb.append(line).append("\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(sb);
	}
	
	private static void fileR2() {
		/*
		 * https://www.mkyong.com/java/java-how-to-read-a-file/
		 */
		try {
			Stream<String> lines = Files.lines(path);
			List<String> content = lines.collect(Collectors.toList());
			content.forEach(x -> System.out.println(x));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private static void fileW() {
		
		try(Stream<String> stream = Files.lines(path)){
            Files.write(path2, (Iterable<String>)stream.filter(s->s.trim().startsWith("{")).filter(s->s.trim().endsWith("}"))::iterator);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		fileW();
	}
}
