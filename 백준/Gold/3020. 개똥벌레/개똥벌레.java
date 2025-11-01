import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        // 높이 1..H 사용, 편의를 위해 H+2로 잡음(경계 안전)
        int[] bot = new int[H + 2]; // 석순(바닥에서 위로)
        int[] top = new int[H + 2]; // 종유석(천장에서 아래로)

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if ((i & 1) == 0) bot[x]++; // 0,2,4,... 번째: 석순
            else top[x]++;              // 1,3,5,... 번째: 종유석
        }

        // ≥ h 개수를 구하기 위한 접미 합
        for (int h = H - 1; h >= 1; h--) {
            bot[h] += bot[h + 1];
            top[h] += top[h + 1];
        }

        int minCrash = Integer.MAX_VALUE;
        int cntHeights = 0;

        for (int h = 1; h <= H; h++) {
            // 석순은 높이 h 이상이 부딪힘
            int crashBot = bot[h];
            // 종유석은 높이 (H - h + 1) 이상이 부딪힘
            int crashTop = top[H - h + 1];

            int crash = crashBot + crashTop;

            if (crash < minCrash) {
                minCrash = crash;
                cntHeights = 1;
            } else if (crash == minCrash) {
                cntHeights++;
            }
        }

        System.out.println(minCrash + " " + cntHeights);
    }
}