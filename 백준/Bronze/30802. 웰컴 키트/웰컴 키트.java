import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int totalMember;
        int[] size = new int[6];
        int T;
        int P;

        totalMember = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i<size.length; i++) {
            size[i] = sc.nextInt();
        }
        
        sc.nextLine();
        T = sc.nextInt();
        P = sc.nextInt();

        int sizeCount = 0;
        int packageCount = 0;
        int remainCount = 0;
        for(int i=0; i<size.length; i++) {
            sizeCount += (int) Math.ceil((double) size[i]/T);
        }
        packageCount = totalMember/P;
        remainCount = totalMember%P;

        System.out.println(sizeCount);
        System.out.println(packageCount + " " + remainCount);
    }
}