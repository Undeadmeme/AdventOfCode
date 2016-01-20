import java.nio.*;
import java.nio.file.*;
import java.util.*;
import java.io.*;
import java.util.regex.*;
import java.lang.*;

public class adventDay8{

  public static void main(String []args) throws IOException{
    String line = null;
    String nline = null;
    int lg = 0;
    int newlg = 0;
    int size = 0;
    BufferedReader br = new BufferedReader(new FileReader("day8.txt"));
    /*Pattern es1 = Pattern.compile("(\\\\x[0-9a-fA-F]{2})");
    Pattern es2 = Pattern.compile("\\\\.");
    Pattern es3 = Pattern.compile("\\\\\\\\");
    Pattern es4 = Pattern.compile("[a-zA-Z]");*/
    while((line = br.readLine()) != null) {
      size += line.trim().length();
      nline = line;
      line = line.replaceAll("\\\\\\\\","p");
      line = line.replaceAll("\\\\x([0-9a-fA-F]{2})","1");
      line = line.replaceAll("\\\\\"","V");
      //System.out.println(size);
      lg += (line.length()-2);

      nline = nline.replaceAll("\\\\{2}","BSBS");
      nline = nline.replaceAll("\\\\\"","SGTT");
      nline = nline.replaceAll("\\\\x[0-9a-fA-F]{2}","PHxBB");
      newlg += (nline.length()+4);
      //System.out.println(line + "_" + line.replaceAll("[a-zA-Z]","").length());
    }

  System.out.println(size - lg);
  System.out.println(newlg - size);
  }
}
