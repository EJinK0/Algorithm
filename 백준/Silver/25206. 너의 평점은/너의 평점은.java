import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double sumScore = 0.0;  // Σ(학점 × 평점)
        double sumCredit = 0.0; // Σ(학점) - P 제외

        for (int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String subject = st.nextToken();      // 과목명 (안 씀)
            double credit = Double.parseDouble(st.nextToken()); // 학점
            String grade = st.nextToken();        // 등급

            if (grade.equals("P")) {
                continue; // P는 계산에서 제외
            }

            double gradePoint = 0.0;

            switch (grade) {
                case "A+":
                    gradePoint = 4.5;
                    break;
                case "A0":
                    gradePoint = 4.0;
                    break;
                case "B+":
                    gradePoint = 3.5;
                    break;
                case "B0":
                    gradePoint = 3.0;
                    break;
                case "C+":
                    gradePoint = 2.5;
                    break;
                case "C0":
                    gradePoint = 2.0;
                    break;
                case "D+":
                    gradePoint = 1.5;
                    break;
                case "D0":
                    gradePoint = 1.0;
                    break;
                case "F":
                    gradePoint = 0.0;
                    break;
            }

            sumScore += credit * gradePoint;
            sumCredit += credit;
        }

        double result = sumScore / sumCredit;
        System.out.println(result);
    }
}