import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[][] paper = new boolean[100][100];
        
        for(int k=0 ; k<N ; k++) {
            String[] parts = br.readLine().split(" ");
            int x = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[1]);
            
            for(int i=x ; i<x+10 ; i++) {
                for(int j=y ; j<y+10 ; j++) {
                    paper[i][j] = true;
                }
            }
        }
        
        int area = 0;
        for(int i=0;i<100;i++) {
            for(int j=0;j<100;j++) {
                if(paper[i][j]) {
                    area++;
                }
            }
        }
        
       System.out.println(area);
    }
}