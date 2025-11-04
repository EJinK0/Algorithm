import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        String line = br.readLine();
        int T = Integer.parseInt(line.trim());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            long K = Long.parseLong(st.nextToken());

            int[] a = new int[N];
            int filled = 0;
            while (filled < N) {
                st = new StringTokenizer(br.readLine());
                while (st.hasMoreTokens() && filled < N) {
                    a[filled++] = Integer.parseInt(st.nextToken());
                }
            }

            Arrays.sort(a);

            int l = 0, r = N - 1;
            long bestDiff = Long.MAX_VALUE;
            long count = 0;

            while (l < r) {
                long sum = (long) a[l] + a[r];
                long diff = Math.abs(sum - K);

                if (diff < bestDiff) {
                    bestDiff = diff;
                    count = 0; // 최솟값 갱신 시 카운트 리셋
                }

                if (diff == bestDiff) {
                    if (a[l] == a[r]) {
                        long n = r - l + 1;
                        count += n * (n - 1) / 2; // 조합 C(n,2)
                        break; // 모든 쌍 처리 완료
                    } else {
                        long cL = 1, cR = 1;
                        while (l + cL < r && a[l + (int)cL] == a[l]) cL++;
                        while (r - (int)cR > l && a[r - (int)cR] == a[r]) cR++;
                        count += cL * cR;

                        if (sum < K) {
                            l += (int)cL;
                        } else { // sum > K
                            r -= (int)cR;
                        }
                        continue;
                    }
                }

                // diff != bestDiff 인 경우에는 단순 이동
                if (sum < K) l++;
                else r--;
            }

            out.append(count).append('\n');
        }

        System.out.print(out.toString());
    }
}