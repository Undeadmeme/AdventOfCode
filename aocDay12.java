import java.io.*;
import java.util.*;

public class adventDay12 {

	public static void main(String[] args) throws FileNotFoundException {
		int total = 0;
		
		Scanner sc = new Scanner("hel10");
		while (sc.hasNext()) {
			if(sc.hasNextInt()) {
				total += sc.nextInt();
			}	
		}
		sc.close();
		System.out.println(total);
	}
}
