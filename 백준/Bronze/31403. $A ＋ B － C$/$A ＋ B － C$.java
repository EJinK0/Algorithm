import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String sA = br.readLine();
        String sB = br.readLine();
        String sC = br.readLine();
        String sAB = sA+sB;
        
        int first = Integer.parseInt(sA) + Integer.parseInt(sB) - Integer.parseInt(sC);
        int second = Integer.parseInt(sAB) - Integer.parseInt(sC);

        StringBuilder sb = new StringBuilder();
        System.out.print(sb.append(first).append("\n").append(second));
    }
}