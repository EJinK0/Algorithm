import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static Queue<Integer> queue = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int last = -1;

        for(int i=0;i<N;i++) {
            String line = br.readLine();
            String[] commands = line.split(" ");

            switch(commands[0]) {
                case "push":
                    last = Integer.parseInt(commands[1]);
                    queue.offer(last);
                    break;
                case "pop":
                    sb.append(queue.isEmpty() ? -1 : queue.poll()).append("\n");
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    sb.append(queue.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    sb.append(queue.isEmpty() ? -1 : queue.peek()).append("\n");
                    break;
                case "back":
                    sb.append(queue.isEmpty() ? -1 : last).append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }
}