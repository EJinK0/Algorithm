import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int max = 0;
        int maxIndex=0;
        for(int i=0;i<9;i++) {
            int number = Integer.parseInt(br.readLine());
            if(number > max) {
                max = number;
                maxIndex = i+1;
            }
        }

        System.out.println(max);
        System.out.println(maxIndex);
    }
}