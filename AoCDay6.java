import java.nio.*;
import java.nio.file.*;
import java.io.*;
import java.lang.*;
import java.lang.String;
import java.util.*;
public class adventday6{
  public static void main(String []args) throws IOException{
    int[][] lights = new int[1000][1000];
    BufferedReader br = new BufferedReader(new FileReader("aocDay6.txt"));
    String line = null;
    while((line = br.readLine()) != null) {
      int setTo = 0;
      if(line.matches("turn off(.*)")) {
        line = line.replaceAll("turn off ","");
        setTo = -1;
      } else if(line.matches("turn on(.*)")) {
        line = line.replaceAll("turn on ","");
        setTo = 1;
      } else if(line.matches("toggle(.*)")) {
        line = line.replaceAll("toggle ","");
        setTo = 2;
      } else {
        System.out.println("broken");
      }
      String[] coors = line.split(" through ");
      String[] sTemp = coors[0].split(",");
      int[] start = new int[sTemp.length];
      String[] eTemp = coors[1].split(",");
      int[] end = new int[eTemp.length];
      for(int i = 0; i < sTemp.length; i++){
        start[i] = Integer.parseInt(sTemp[i]);
        end[i] = Integer.parseInt(eTemp[i]);
      }
      for(int x = start[0]; x <= end[0]; x++){
        for(int y = start[1]; y <= end[1]; y++){
            lights[x][y] += setTo;
            if(lights[x][y] < 0) {
              lights[x][y] = 0;
            }
          /* else {
            if(lights[x][y] == 0) {
              lights[x][y] = 1;
            } else {
              lights[x][y] = 0;
            }
          }*/
        }
      }
    }
    int count = 0;
    for(int xx = 0; xx < 1000; xx++){
      for(int yy = 0; yy < 1000; yy++){
        count += lights[xx][yy];
      }
    }
    System.out.println(count);
  }
}
