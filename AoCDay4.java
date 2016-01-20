import java.nio.*;
import java.nio.file.*;
import java.io.*;
import java.util.*;
import java.security.*;
import java.math.BigInteger;
public class HelloWorld{

    public static void main(String []args) throws GeneralSecurityException, UnsupportedEncodingException {
        String code = "bgvyzdsv";
        boolean found = false;
        int i = 0;
        while(found == false) {
            String text = code.concat(Integer.toString(i));
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.reset();
            m.update(text.getBytes());
            byte[] digest = m.digest();
            BigInteger bigInt = new BigInteger(1,digest);
            String hashText = bigInt.toString(16);
            if(hashText.length() == 27) {
                found = true;
            } else {
                i++;
            }
        }
        System.out.println(i);
    }
}
