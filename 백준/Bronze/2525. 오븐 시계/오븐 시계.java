import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(br.readLine().trim());

        int minutes = H * 60 + M + T;
        int newH = (minutes / 60) % 24;
        int newM = minutes % 60;

        System.out.println(newH + " " + newM);
    }
}