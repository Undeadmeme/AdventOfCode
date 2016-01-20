import java.util.*;
import java.io.*;
import java.util.Arrays;

import com.google.common.collect.Collections2;

public class adventDay13 {
	static HashMap<String, Integer> happiness = new HashMap<>();
	static Set<String> people = new HashSet<>();
	public static void main(String[] args) throws FileNotFoundException, IOException {
		String line = null;
		BufferedReader br = new BufferedReader(new FileReader("src/day13.txt"));
		while((line = br.readLine()) != null) {
			String[] split = line.split(" ");
			people.add(split[0]);
			split[10] = split[10].substring(0, split[10].length()-1);
			people.add(split[10]);
			
			int x = Integer.parseInt(split[3]);
			//System.out.println(split[2]);
			if(split[2].trim().equals("lose")) {
				happiness.put(split[0] + split[10], (Math.abs(x) * -1));
			} else {
				happiness.put(split[0] + split[10], x);
			}
		}
		for(String s : people) {
			happiness.put(s + "Me", 0);
			happiness.put("Me" + s, 0);
		}
		people.add("Me");
		br.close();
		int max = 0;
		for(List<String> perm : Collections2.permutations(people)) {
			int hap = 0;
			for(int i = 0; i < perm.size()-1; i++) {
				hap += happiness.get(perm.get(i) + perm.get(i+1));
				hap += happiness.get(perm.get(i+1) + perm.get(i));
			}
			hap += happiness.get(perm.get(perm.size()-1) + perm.get(0));
			hap += happiness.get(perm.get(0) + perm.get(perm.size()-1));
			if(hap > max){
				max = hap;
			}
		}
		System.out.println(max);
	}

}
