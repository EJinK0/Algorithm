import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int wordCount = Integer.parseInt(sc.nextLine()); // 단어의 갯수
        Set<String> wordSet = new HashSet<>();

        for (int i = 0; i < wordCount; i++) {
            wordSet.add(sc.nextLine());
        }

        // 리스트로 변환 후 정렬
        List<String> wordList = new ArrayList<>(wordSet);
        wordList.sort((a, b) -> {
            if(a.length() != b.length()) {
                return a.length() - b.length();
            } else {
                return a.compareTo(b);
            }
        });

        for(String word: wordList) {
            System.out.println(word);
        }
    }
}