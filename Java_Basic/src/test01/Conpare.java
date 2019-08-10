package test01;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class  Human {
	private String name;
	private int age;
	
	public Human(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
} 

public class Conpare {
	
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
    	int aScore = 0;
    	int bScore = 0;
    	
    	int index = 0;
    	for (int aa : a) {
    		if (aa == b.get(index)) {
    			index ++;
    			continue;
    		}
    		
    		if (aa > b.get(index)) {
    			aScore ++;
    		} else {
    			bScore ++;
    		}
    		
    		index ++;
    	}
    	
    
    	List<Human> humans = Arrays.asList(
    		      new Human("Sarah", 10), 
    		      new Human("Jack", 12)
    		    );
    	
    	if (1 < 2) {
    		
    	}
    	
    	if (Integer.compare(1, 2) < -1) {
    		
    	}
    	
    	humans.sort(Comparator.comparing(Human::getName));   
    	
    	humans.stream().sorted(Comparator.comparing(Human::getName)).collect(Collectors.toList());
    	
        return Arrays.asList(aScore, bScore);
    }
    
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
		
		List<Integer> a = Stream
				.of(br.readLine()
						.replaceAll("\\s+$", "")
						.split(" "))
				.map(Integer::parseInt)
				.collect(toList());
		List<Integer> b = Stream
				.of(br.readLine()
						.replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt)
				.collect(toList());
		
		List<Integer> result = compareTriplets(a,b);
		
		bw.write(result.stream()
				.map(Object::toString)
				.collect(joining(" ")) + "\n");
	
	
	}
	
}
