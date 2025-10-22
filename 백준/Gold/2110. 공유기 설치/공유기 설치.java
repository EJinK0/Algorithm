import java.io.*;
import java.util.*;
public class Main {
    static int N, C;
    static int[] house;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        house = new int[N];

        for(int i=0;i<N;i++) {
            house[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(house);

        int lo = 0;
        long hi = house[N-1]-house[0];
        int ans=0;

        while(lo <= hi) {
            int mid = (int) ((lo + hi) / 2);

            if(canInstall(mid)) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid-1;
            }
        }

        System.out.println(ans);
    }

    private static boolean canInstall(int dist) {
        int count = 1;
        int last = house[0];
        for(int i=0;i<N;i++) {
            if(house[i] - last >= dist) {
                count++;
                last=house[i];
            }
        }
        return count >= C;
    }
}