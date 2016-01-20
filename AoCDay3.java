import java.nio.*;
import java.nio.file.*;
import java.io.*;
import java.util.*;
public class HelloWorld{

     public static void main(String []args) throws IOException{
        String everything = null;
        BufferedReader br = new BufferedReader(new FileReader("inputday3.txt"));
        try {
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
            }
            everything = sb.toString();
        } finally {
           br.close();
        }
        HashMap<String, Integer> hoos = new HashMap<String, Integer>();
        hoos.put("0,0",new Integer(1));
        int x = 0;
        int y = 0;
        for(int i = 0 ; i < everything.length(); i++) {
            char c = everything.charAt(i);
            if(c == '^') {
                y++;
            } else if(c == 'v') {
                y--;
            } else if(c == '>') {
                x++;
            } else if(c == '<') {
                x--;
            }
            String coors = Integer.toString(y).concat(",").concat(Integer.toString(x));
            System.out.println(coors);
            if(!hoos.containsKey(coors)) {
                hoos.put(coors, new Integer(1));
            } else {
                hoos.put(coors, hoos.get(coors) + 1);
            }
        }
        System.out.println(hoos.size());
       //System.out.println(everything);
     }
}
