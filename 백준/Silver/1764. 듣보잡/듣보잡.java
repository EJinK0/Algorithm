import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Set<String> unHeard = new HashSet<>(N);
        List<String> resultArr = new ArrayList<>();

        for(int i=0;i<N;i++) {
            unHeard.add(br.readLine().trim());
        }

        for(int i=0;i<M;i++) {
            String name = br.readLine().trim();
            if(unHeard.contains(name)) {
                resultArr.add(name);
            }
        }

        Collections.sort(resultArr);

        StringBuilder sb = new StringBuilder();
        sb.append(resultArr.size()).append("\n");
        for(String name: resultArr) {
            sb.append(name).append("\n");
        }

        System.out.print(sb);
    }
}