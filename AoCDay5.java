import java.nio.*;
import java.nio.file.*;
import java.io.*;
import java.lang.*;
import java.lang.String;
import java.util.*;
public class adventday5{
  public static void main(String []args) throws IOException{
    //CharSequence[] notContain = {'ab','cd','pq','xy'};
    CharSequence[] notContain = {"ab","cd","pq","xy"};
    String naughtString = ".?([a-z])\1+.?";
    String niceString = = ".?(aa|bb|cc|dd).?";
    CharSequence[] contain = {"aa","bb","cc","dd"};
    char[] vowels = {'a','e','i','o','u'};
    String vowelString = "[^aeiou]";
    BufferedReader br = new BufferedReader(new FileReader("aocDay5.txt"));
    int count = 0;
    try {
        String line = null;
        while ((line = br.readLine()) != null) {
          boolean nice = false;
          int vCount = 0;
          for(int x = 0; x < line.length(); x++) {
            for(int y = 0; y < vowels.length; y++) {
              if(line.charAt(x) == vowels[y]){
                vCount++;
              }
            }
          }
          for(int i = 0; i < contain.length; i++) {
            if(line.contains(contain[i])) {
              nice = true;
              break;
            }
          }
          for(int i = 0; i < notContain.length; i++) {
            if(line.contains(notContain[i])) {
              nice = false;
              break;
            }
          }
          if((vCount >= 3) && nice) {
            count++;
          }
        }
    } finally {
       br.close();
    }
    System.out.println(count);
  }
}
