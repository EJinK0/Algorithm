import java.io.*;
import java.util.*;
public class Main {
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][2];

            for(int i=0;i<N;i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int doc = Integer.parseInt(st.nextToken());
                int interview = Integer.parseInt(st.nextToken());
                arr[i][0] = doc;
                arr[i][1] = interview;
            }

            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });

            int count = 1;
            int bestInterview = arr[0][1];

            for(int i=0;i<N;i++) {
                int interviewRank = arr[i][1];
                if(interviewRank < bestInterview) {
                    count++;
                    bestInterview = interviewRank;
                }
            }

            sb.append(count).append('\n');
        }

        System.out.println(sb);
    }
}