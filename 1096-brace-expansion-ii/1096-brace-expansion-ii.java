import java.util.*;

class Solution {
    public List<String> braceExpansionII(String expression) {
        Queue<String> queue = new LinkedList<>();
        Set<String> resultSet = new HashSet<>();
        queue.offer(expression);
        while (!queue.isEmpty()) {
            String curr = queue.poll();
            if (curr.indexOf('{') == -1) {
                resultSet.add(curr);
                continue;
            }
            int right = curr.indexOf('}');
            int left = curr.lastIndexOf('{', right);
            String before = curr.substring(0, left);
            String after = curr.substring(right + 1);
            String[] choices = curr.substring(left + 1, right).split(",");
            for (String choice : choices) {
                queue.offer(before + choice + after);
            }
        }
        List<String> resultList = new ArrayList<>(resultSet);
        Collections.sort(resultList);
        return resultList;
    }
}