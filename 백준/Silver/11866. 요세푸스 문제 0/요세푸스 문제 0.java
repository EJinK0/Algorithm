import java.io.*;
import java.util.*;
public class Main {
    static int n, m;
    static int[] nArray;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nArray = new int[n];

        for(int i=1 ; i<=n ; i++) {
            queue.offer(i);
        }
        List<Integer> result = new ArrayList<>();

        while(!queue.isEmpty()) {
            for(int i=0;i<m-1;i++) {
                queue.offer(queue.poll());
            }
            result.add(queue.poll());
        }

        System.out.print("<");
        for(int i=0 ; i<result.size() ; i++) {
            System.out.print(result.get(i));
            if(i < result.size()-1) {
                System.out.print(", ");
            }
        }
        System.out.print(">");
    }
}