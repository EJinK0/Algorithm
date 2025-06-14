import java.io.*;
import java.util.*;

public class Main {
    static long[] numbers;
    static int goodCount = 0;
    
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        numbers = new long[num];

        for (int i = 0; i < num; i++) {
            numbers[i] = sc.nextLong();
        }
        
        Arrays.sort(numbers);
        
        for (int k = 0; k < num; k++) {
            int i = 0;
            int j = num - 1;
 
            while (i < j) {
                if(i == k) {
                    i++;
                    continue;
                }
                if(j == k) {
                    j--;
                    continue;
                }

                long sum = numbers[i] + numbers[j];

                if (sum == numbers[k]) {
                    goodCount++;
                    break;
                } else if (sum < numbers[k]) {
                    i++;
                } else {
                    j--;
                }
            }
        }
        
        System.out.println(goodCount);
    }
}