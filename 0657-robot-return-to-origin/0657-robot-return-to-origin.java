class Solution {
    public boolean judgeCircle(String moves) {
        var moveCount = new HashMap<Character, Integer>();
        var pairs = Map.of(
                'L', 'R',
                'U', 'D',
                'R', 'L',
                'D', 'U');

        for (char ch : moves.toCharArray()) {
            moveCount.put(ch, moveCount.getOrDefault(ch, 0) + 1);
        }

        for (char key : moveCount.keySet()) {
            if (!Objects.equals(moveCount.get(key), moveCount.get(pairs.get(key))))
                return false;
        }

        return true;
    }
}