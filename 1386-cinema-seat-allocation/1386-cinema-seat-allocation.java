class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        var map = new HashMap<Integer, List<Integer>>();
        var groupCount = 0;
        var resCount = 0;
        var groupA = false;
        var groupB = false;
        var groupC = false;

        for(int[] seat: reservedSeats) {
            if(!map.containsKey(seat[0]))
                map.put(seat[0], new ArrayList<>());

            map.get(seat[0]).add(seat[1]);
        }

        for(var key: map.keySet()) {
            groupA = true;
            groupB = true;
            groupC = true;
            resCount++;
            for(var value : map.get(key)) {
                if(value == 2 || value == 3 || value == 4 || value == 5) {
                    groupA = false;
                }

                if(value == 4 || value == 5 || value == 6 || value == 7) {
                    groupB = false;
                }

                if(value == 6 || value == 7 || value == 8 || value == 9) {
                    groupC = false;
                }
            }
            if(groupA && groupC) {
                groupCount += 2;
            } else if(groupA || groupB || groupC) {
                groupCount++;
            }
        }

        groupCount += (n - resCount) * 2;
        return groupCount;
    }
}