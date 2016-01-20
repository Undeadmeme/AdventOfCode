
import java.io.IOException;

public class adventDay10 {
	public static void main(String[] args) throws IOException {
		String input = "1321131112";
		int times = 50;
		StringBuilder newin;
		for(int i = 0; i < times; i++){
			newin = new StringBuilder();
			System.out.println(i);
			for(int x = 0; x < input.length(); x++) {
				int count = 1;
				char c = input.charAt(x);
				while(x+1 < input.length() && input.charAt(x+1) == c) {
					x++;
					count++;
				}
				newin.append(count);
				newin.append(c);
			}
			input = newin.toString();
			
			//System.out.println(input);
		}
		System.out.println(input.length());
	}
}
