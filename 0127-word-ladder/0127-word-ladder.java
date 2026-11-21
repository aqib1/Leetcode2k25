class Solution {
    public List<String> getLadder(List<String> wordList, String word) {
        return wordList.stream().filter(
                x -> isValid(x, word)
        ).toList();
    }

    public boolean isValid(String w1, String w2) {
        if (w1.length() != w2.length())
            return false;
        int diff = 0;

        for (int i = 0; i < w1.length(); i++) {
            if (w1.charAt(i) != w2.charAt(i))
                diff++;
        }

        return diff == 1;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList.isEmpty()) {
            return 0;
        }


        var childByParent = new HashMap<String, String>();
        var queue = new ArrayDeque<String>();
        var visited = new HashSet<String>();
        childByParent.put(beginWord, null);
        queue.add(beginWord);
        visited.add(beginWord);

        while(!queue.isEmpty()) {
            var current = queue.remove();
            if(current.equals(endWord))
                break;
            var edges = getLadder(wordList, current);
            for(var edge: edges) {
                if(!visited.contains(edge)) {
                    queue.add(edge);
                    visited.add(edge);
                    childByParent.put(edge, current);
                }
            }
        }

        System.out.println(childByParent);
        if(!visited.contains(endWord)) return 0;

        var path = new ArrayList<String>();

        for(var end = endWord; end != null; end = childByParent.get(end)) {
            path.add(end);
        }

        System.out.println(path);

        return path.size();
    }
}