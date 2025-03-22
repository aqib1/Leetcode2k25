class Solution {
    public int maximumSwap(int num) {
        var numStr = String.valueOf(num).toCharArray();
        var maxFromRight = new int[numStr.length];
        maxFromRight[maxFromRight.length - 1] = numStr.length - 1;
        for(var right = maxFromRight.length - 2; right >= 0; right--) {
            if(numStr[right] - 'a' <= numStr[maxFromRight[right + 1]] - 'a') {
                maxFromRight[right] = maxFromRight[right + 1];
            } else {
                maxFromRight[right] = right;
            }
        }

        for(var i = 0; i < numStr.length; i++) {
            if(numStr[i] < numStr[maxFromRight[i]]) {
                var tmp = numStr[i];
                numStr[i] = numStr[maxFromRight[i]];
                numStr[maxFromRight[i]] = tmp;
                break;
            }
        }

        return Integer.parseInt(new String(numStr));
    }
}