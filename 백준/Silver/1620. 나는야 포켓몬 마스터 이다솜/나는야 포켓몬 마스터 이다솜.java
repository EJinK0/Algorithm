import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        String[] idxToName = new String[N+1];
        Map<String, Integer> nameToIdx = new HashMap<>(N*2); 
        for(int i=1 ; i<=N ; i++) {
            String pokemonName = br.readLine();
            idxToName[i] = pokemonName;
            nameToIdx.put(pokemonName, i);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<M ; i++) {
            String question = br.readLine();
            if(isNumber(question)) {
                int idx = Integer.parseInt(question);
                sb.append(idxToName[idx]).append("\n");
            } else {
                sb.append(nameToIdx.get(question)).append("\n");
            }
        }
        
        System.out.print(sb);
    }
    
    private static boolean isNumber(String s) {
        char c = s.charAt(0);
        return c >= '0' && c <= '9';
    }
}