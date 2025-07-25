import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int n = Integer.parseInt(br.readLine());
        char[] chars = word.toCharArray();
        System.out.print(chars[n-1]);
    }
}