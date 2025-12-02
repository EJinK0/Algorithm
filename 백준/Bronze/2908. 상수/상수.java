import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String a = st.nextToken();
        String b = st.nextToken();

        int ra = reverseNumber(a);
        int rb = reverseNumber(b);

        System.out.println(Math.max(ra, rb));
    }

    private static int reverseNumber(String s) {
        return Integer.parseInt(new StringBuilder(s).reverse().toString());
    }
}