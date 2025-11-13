import java.io.*;
import java.util.*;
public class Main {
    static StringBuilder sb = new StringBuilder();
    static long moves = 0;

    static void hanoi3(int n, char from, char to, char aux) {
        if(n==0) return;
        if(n==1) {
            move(from, to);
            return;
        }
        hanoi3(n-1, from, aux, to);
        move(from, to);
        hanoi3(n-1, aux, to, from);
    }

    static void hanoi4(int n, char from, char to, char spare1, char spare2) {
        if(n==0) return;
        if(n==1) {
            move(from, to);
            return;
        }
        if(n==2) {
            move(from,spare2);
            move(from,to);
            move(spare2,to);
            return;
        }

        hanoi3(n-2,from,spare1,spare2);
        move(from,spare2);
        move(from,to);
        move(spare2,to);
        hanoi4(n-2,spare1,to,from,spare2);
    }

    static void move(char from, char to) {
        sb.append(from).append(' ').append(to).append('\n');
        moves++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        hanoi4(N, 'A', 'D', 'B', 'C');

        System.out.println(moves);
        System.out.println(sb.toString());
    }
}