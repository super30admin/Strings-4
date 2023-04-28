import java.util.*;

public class WordBreak {
    // TC : O(n ^ 3)
    // SC : O(n)
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[s.length()];

        queue.add(0);

        while(!queue.isEmpty()) {
            int start = queue.poll();

            if(visited[start]) continue;

            visited[start] = true;

            for(int end=start + 1; end <= s.length(); end++){
                if(set.contains(s.substring(start, end))){
                    queue.add(end);

                    if(end == s.length()) return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        WordBreak obj = new WordBreak();
        var answer = obj.wordBreak("catsanddog", Arrays.asList("cat", "cats", "sand", "and", "dog"));
        System.out.println("answer = " + answer);
    }
}
