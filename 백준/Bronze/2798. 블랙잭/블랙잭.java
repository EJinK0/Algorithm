import java.io.*;
import java.util.*;
public class Main {
    public static int cardNum;
    public static int sumNum;
    public static int[] cards;
    public static int resultNum;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        cardNum = Integer.parseInt(st.nextToken());
        sumNum = Integer.parseInt(st.nextToken());
        cards = new int[cardNum];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<cardNum ; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        // 3중 for문으로 3장의 카드 조합 모두 탐색
        for (int i = 0; i < cardNum - 2; i++) {
            for (int j = i + 1; j < cardNum - 1; j++) {
                for (int k = j + 1; k < cardNum; k++) {
                    int sum = cards[i] + cards[j] + cards[k];
                    if (sum <= sumNum && sum > resultNum) {
                        resultNum = sum;
                    }
                }
            }
        }

        // 결과 출력
        System.out.println(resultNum);
    }
}