import java.util.*;
public class Main {
    static final int MAX = 100001;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] time = new int[MAX];
        Arrays.fill(time, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        time[n] = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if(now == k) {
                System.out.println(time[now]);
                return;
            }

            for(int next : new int[]{now - 1, now + 1, now * 2}) {
                if(next >= 0 && next < MAX && time[next] == -1) {
                    time[next] = time[now] + 1;
                    queue.offer(next);
                }
            }
        }
    }
}