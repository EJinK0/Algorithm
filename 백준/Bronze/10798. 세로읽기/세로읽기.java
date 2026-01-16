import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] lines = new String[5];
        int maxLen = 0;
        
        for(int i=0;i<5;i++) {
            lines[i] = br.readLine();
            if(maxLen < lines[i].length()) {
                maxLen = lines[i].length();
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<maxLen;i++) {
            for(int j=0;j<5;j++) {
                if(i<lines[j].length()) {
                    sb.append(lines[j].charAt(i));
                }
            }
        }
        
       System.out.println(sb);
    }
}