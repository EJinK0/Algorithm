import java.io.*;
import java.util.*;
public class Main {
    public static int N;
    public static int[] grade;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        grade = new int[N];
        int max = 0;
        double sum = 0;
        for(int i=0 ; i<N ; i++) {
            grade[i] = Integer.parseInt(st.nextToken());

            if(grade[i] > max) {
                max = grade[i];
            }

            sum += grade[i];
        }

        double average = sum/max*100.0/N;
        System.out.printf("%.6f\n", average);
    }
}