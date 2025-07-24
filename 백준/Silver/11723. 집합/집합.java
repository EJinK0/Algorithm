import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        int S = 0;

        for(int i=0 ; i<M ; i++) {
            String[] cmd = br.readLine().split(" ");
            String op = cmd[0];
            int x = (cmd.length > 1) ? Integer.parseInt(cmd[1]) : 0;

            switch(op) {
                case "add":
                    S |= (1 << (x - 1));
                    break;
                case "remove":
                    S &= ~(1 << (x - 1));
                    break;
                case "check":
                    sb.append((S & (1 << (x - 1))) != 0 ? "1\n" : "0\n");
                    break;
                case "toggle":
                    S ^= (1 << (x - 1));
                    break;
                case "all":
                    S = (1 << 20) - 1;
                    break;
                case "empty":
                    S = 0;
                    break;
            }
        }

        System.out.println(sb);
    }
}