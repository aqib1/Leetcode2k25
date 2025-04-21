class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        var response = new HashSet<Integer>();
        var map = new HashMap<Integer, Integer>();

        for(int i: nums1) map.put(i, i);

        for(int i: nums2) if(map.containsKey(i)) response.add(i);


        var res = new int[response.size()];
        int index = 0;
        for(int i : response) res[index++] = i;

        return res;
    }
}