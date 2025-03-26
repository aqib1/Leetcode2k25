class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        var response = new ArrayList<Integer>(k);
        int left = 0;
        int right = arr.length - k;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        for(int i = left; i < left + k; i++) {
            response.add(arr[i]);
        }

        return response;
    }
}