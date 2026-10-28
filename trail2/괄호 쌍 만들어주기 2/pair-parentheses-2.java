import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] arr = s.toCharArray();

        int answer=0;
        
        for(int i=0;i<arr.length-1;i++) {
            if(arr[i] == '(' && arr[i+1] == '(') {
                for(int j=i+2;j<arr.length-1;j++) {
                    if(arr[j] == ')' && arr[j+1] == ')') {
                        answer++;
                    }
                }
            }
        }

        System.out.println(answer);
        sc.close();
    }
}