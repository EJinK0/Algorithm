import java.io.*;
import java.util.*;
public class Main {
    static String[] words;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        words = new String[3];

        for(int i=0 ; i<3 ; i++) {
            words[i] = br.readLine().trim();
        }

        int base = -1;
        for(int i=0 ; i<3 ; i++) {
            String s = words[i];
            char c = s.charAt(0);
            if(c != 'F' && c != 'B') {
                base = Integer.parseInt(s) + (3-i);
                break;
            }
        }

        String result;
        if(base % 15 == 0) {
            result = "FizzBuzz";
        } else if(base % 3 == 0) {
            result = "Fizz";
        } else if(base % 5 == 0) {
            result = "Buzz";
        } else {
            result = Integer.toString(base);
        }

        System.out.println(result);
    }
}