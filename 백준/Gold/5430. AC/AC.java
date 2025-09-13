import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char[] charArray;
    static List<Integer> array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String ops = br.readLine();
            charArray = ops.toCharArray();
            int n = Integer.parseInt(br.readLine());
            String arrayStr = br.readLine();
            int[] myarray = parseArray(arrayStr, n);

            int start = 0, end = n - 1;
            boolean reversed = false;
            boolean error = false;

            for (char word : charArray) {
                if (word == 'R') {
                    reversed = !reversed;
                } else if (word == 'D') {
                    if (start > end) {
                        error = true;
                        break;
                    }
                    if (!reversed)
                        start++;
                    else
                        end--;
                }
            }

            if (error) {
                sb.append("error\n");
            } else {
                sb.append('[');
                if (start <= end) {
                    if (!reversed) {
                        for (int j = start; j <= end; j++) {
                            sb.append(myarray[j]);
                            if (j < end)
                                sb.append(',');
                        }
                    } else {
                        for (int k = end; k >= start; k--) {
                            sb.append(myarray[k]);
                            if (k > start)
                                sb.append(',');
                        }
                    }
                }

                sb.append(']').append('\n');
            }
        }

        System.out.print(sb);
    }

    private static int[] parseArray(String s, int n) {
        if (n == 0)
            return new int[0]; // "[]"
        String body = s.substring(1, s.length() - 1);
        // 입력이 보장되므로 split 사용해도 OK. (정규식 비용 감수 가능)
        String[] parts = body.split(",");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(parts[i]);
        return arr;
    }
}