import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int N = Integer.parseInt(br.readLine().trim());
        int[] stack = new int[N];  // 최대 연산 수만큼면 충분
        int top = -1;              // 빈 스택: top == -1

        for (int i = 0; i < N; i++) {
            String cmd = br.readLine();

            // 명령이 다양하지만 첫 글자로 대부분 분기 가능
            char c0 = cmd.charAt(0);
            if (c0 == 'p') {                 // push or pop
                if (cmd.charAt(1) == 'u') {  // "push X"
                    int x = Integer.parseInt(cmd.substring(5));
                    stack[++top] = x;
                } else {                     // "pop"
                    if (top == -1) out.append(-1).append('\n');
                    else out.append(stack[top--]).append('\n');
                }
            } else if (c0 == 's') {          // "size"
                out.append(top + 1).append('\n');
            } else if (c0 == 'e') {          // "empty"
                out.append(top == -1 ? 1 : 0).append('\n');
            } else {                         // "top"
                out.append(top == -1 ? -1 : stack[top]).append('\n');
            }
        }

        System.out.print(out.toString());
    }
}