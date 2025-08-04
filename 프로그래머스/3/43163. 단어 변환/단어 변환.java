import java.io.*;
import java.util.*;
class Solution {
    public static int solution(String begin, String target, String[] words) {
        if(!Arrays.asList(words).contains(target)) {
            return 0;
        }

        Queue<Word> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        queue.add(new Word(begin, 0));

        while(!queue.isEmpty()) {
            Word current = queue.poll();
            String word = current.word;
            int steps = current.steps;

            if(word.equals(target)) {
                System.out.println(steps);
                return steps;
            }

            for(int i=0;i<words.length;i++) {
                if(!visited[i] && canConvert(word, words[i])) {
                    visited[i] = true;
                    queue.add(new Word(words[i], steps+1));
                }
            }
        }
        return 0;
    }
    
     private static class Word {
        String word;
        int steps;

        Word(String word, int steps) {
            this.word = word;
            this.steps = steps;
        }
    }
    
    private static boolean canConvert(String a, String b) {
        int diff = 0;
        for(int i=0;i<a.length();i++) {
            if(a.charAt(i) != b.charAt(i)) diff++;
            if(diff > 1) return false;
        }
        return diff == 1;
    }
}