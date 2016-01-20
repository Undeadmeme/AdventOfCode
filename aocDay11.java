
public class adventDay11 {

	public static void main(String[] args) {
		String input = "cqjxxyzz";
		boolean acceptable = false;
		StringBuilder password = new StringBuilder(input);
		while(acceptable == false) {
			int i = password.length()-1;
			boolean increment = false;
			while(i >= 0 && increment == false) {
				char c = password.charAt(i);
				char x = (char) (c+ 1);
				if(x == '{') {
					x = 'a';
				} else {
					increment = true;
				}
				password.setCharAt(i, x);
				i--;
			}
			acceptable = accepted(password);
		}
				
		//char x = input.charAt(0);
		System.out.println(password.toString());
	}
	
	public static boolean accepted(StringBuilder password) {
		boolean straight = false;
		if(password.indexOf("i") >= 0 
				|| password.indexOf("o") >= 0 
				|| password.indexOf("l") >= 0) {
			return false;
		}
		int pairs = 0;
		for(int i = 0; i < password.length()- 1; i++) {
			if(password.charAt(i) == password.charAt(i + 1)) {
				i++;
				pairs++;
			}
		}
		for(int i = 0; i < password.length()- 2; i++) {
			//System.out.println("yes?");
			char s = password.charAt(i);
			char s2 = (char) (password.charAt(i+1) - 1);
			char s3 = (char) (password.charAt(i+2) - 2);
			if(s == s2 && s == s3) {
				straight = true;
			}
		}
		if(straight && (pairs >= 2)) {
			return true;
		} else {
			return false;
		}
	}
}
