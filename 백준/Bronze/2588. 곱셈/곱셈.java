import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine().trim());
        int B = Integer.parseInt(br.readLine().trim());

        int b1 = B % 10;         // 1의 자리
        int b2 = (B / 10) % 10;  // 10의 자리
        int b3 = B / 100;        // 100의 자리

        StringBuilder sb = new StringBuilder();
        sb.append(A * b1).append('\n');
        sb.append(A * b2).append('\n');
        sb.append(A * b3).append('\n');
        sb.append(A * B).append('\n');

        System.out.print(sb.toString());
    }
}