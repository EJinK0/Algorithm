import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        char[] arr = a.toCharArray();

        int answer = 0;

        for(int i=0;i<arr.length;i++) {
            if(arr[i] == '0') {
                arr[i] = '1';
            } else {
                arr[i] = '0';
            }

            int value = Integer.parseInt(new String(arr), 2);

            answer = Math.max(answer, value);

            if(arr[i] == '0') {
                arr[i] = '1';
            } else {
                arr[i] = '0';
            }
        }

        System.out.println(answer);
        sc.close();
    }
}