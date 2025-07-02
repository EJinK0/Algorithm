import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

          for(int i=0 ; i<T ; i++) {
              String line = sc.nextLine();
              String[] tokens = line.split(" ");
              int R = Integer.parseInt(tokens[0]);
              String s = tokens[1];

              StringBuilder result = new StringBuilder();
              for(char c: s.toCharArray()) {
                  for(int j=0;j<R;j++) {
                      result.append(c);
                  }
              }
            System.out.println(result);
        }
    }
}