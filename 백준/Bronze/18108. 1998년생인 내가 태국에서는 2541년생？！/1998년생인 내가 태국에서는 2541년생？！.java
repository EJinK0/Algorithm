import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int buddhist = Integer.parseInt(br.readLine().trim());
        int gregorian = buddhist - 543;
        System.out.println(gregorian);
    }
}