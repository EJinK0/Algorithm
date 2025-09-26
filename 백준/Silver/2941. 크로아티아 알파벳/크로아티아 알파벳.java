import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String arlpabet = br.readLine();
        String[] chroatia = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        
        for(String c: chroatia) {
            arlpabet = arlpabet.replace(c, "*");
        }
        
        System.out.println(arlpabet.length());
    }
}