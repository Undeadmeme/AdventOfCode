import java.nio.*;
import java.nio.file.*;
import java.util.*;
import java.io.*;
import com.google.common.collect.Collections2;

public class adventDay9{
  static HashMap<String, Integer> dists = new HashMap<>();
  static Set<String> places = new HashSet<>();
  public static void main(String[] args) throws IOException, FileNotFoundException{
    String line = null;
    BufferedReader br = new BufferedReader(new FileReader("src/day9.txt"));
    while((line = br.readLine()) != null) {
      String[] split = line.split(" ");
      places.add(split[0]);
      places.add(split[2]);

      dists.put(split[0]+split[2], Integer.parseInt(split[4]));
      dists.put(split[2]+split[0], Integer.parseInt(split[4]));
    }
    br.close();
    
    int min = 0;
    System.out.println(Collections2.permutations(places));
    for(List<String> perm : Collections2.permutations(places)) {
    	System.out.println(perm);
    	int distance = 0;
    	for(int i = 0; i < perm.size()-1; i++) {
    		distance += dists.get(perm.get(i) + perm.get(i+1)); 
    	}
    	if(min < distance){
    		min = distance;
    	}
    }
    System.out.println(min);
  }
}
