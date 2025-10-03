import java.io.*;
import java.util.*;

public class Main {
    static class DequeInt {
        private final int[] a;
        private int head = 0;   // 현재 front의 인덱스
        private int size = 0;   // 요소 개수

        DequeInt(int capacity) {
            a = new int[capacity]; // 충분한 용량(=명령 수)로 생성
        }

        private int cap() { return a.length; }

        void pushFront(int x) {
            head = (head - 1 + cap()) % cap();
            a[head] = x;
            size++;
        }

        void pushBack(int x) {
            int tail = (head + size) % cap();
            a[tail] = x;
            size++;
        }

        int popFront() {
            if (size == 0) return -1;
            int val = a[head];
            head = (head + 1) % cap();
            size--;
            return val;
        }

        int popBack() {
            if (size == 0) return -1;
            int tailIdx = (head + size - 1) % cap();
            int val = a[tailIdx];
            size--;
            return val;
        }

        int size() { return size; }
        int empty() { return size == 0 ? 1 : 0; }
        int front() { return size == 0 ? -1 : a[head]; }
        int back() { return size == 0 ? -1 : a[(head + size - 1) % cap()]; }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int N = Integer.parseInt(br.readLine().trim());
        DequeInt dq = new DequeInt(N); // 최대 push 횟수 ≤ N

        for (int i = 0; i < N; i++) {
            String cmd = br.readLine();

            char c0 = cmd.charAt(0);
            if (c0 == 'p') {
                if (cmd.charAt(1) == 'u') { // push_*
                    String[] parts = cmd.split(" ");
                    int x = Integer.parseInt(parts[1]);
                    if (parts[0].charAt(5) == 'f') dq.pushFront(x); // "push_front"
                    else dq.pushBack(x);                            // "push_back"
                } else { // pop_*
                    if (cmd.charAt(4) == 'f') out.append(dq.popFront()).append('\n'); // "pop_front"
                    else out.append(dq.popBack()).append('\n');                        // "pop_back"
                }
            } else if (c0 == 's') {                 // size
                out.append(dq.size()).append('\n');
            } else if (c0 == 'e') {                 // empty
                out.append(dq.empty()).append('\n');
            } else if (c0 == 'f') {                 // front
                out.append(dq.front()).append('\n');
            } else {                                // back
                out.append(dq.back()).append('\n');
            }
        }
        System.out.print(out.toString());
    }
}