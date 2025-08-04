import java.io.*;
import java.util.*;
public class Main {
    public static int memberNum;
    public static String[][] memberList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        memberNum = Integer.parseInt(br.readLine());
        memberList = new String[memberNum][2];
        for(int i=0;i<memberNum;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            memberList[i][0] = st.nextToken();
            memberList[i][1] = st.nextToken();
        }

        Arrays.sort(memberList, new Comparator<String[]>() {
           @Override
           public int compare(String[] a, String[] b) {
               return Integer.parseInt(a[0]) - Integer.parseInt(b[0]);
           }
        });

        StringBuilder sb = new StringBuilder();
        for(String[] m: memberList) {
            sb.append(m[0]).append(" ").append(m[1]).append("\n");
        }
        System.out.println(sb);
    }
}