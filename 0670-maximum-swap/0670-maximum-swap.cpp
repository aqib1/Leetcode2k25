class Solution {
public:
    int maximumSwap(int num) {
        string numStr = to_string(num);
        int maxValueIndex = numStr.size() - 1;
        int swap1 = -1, swap2 = maxValueIndex;

        for(int i = numStr.size() - 2; i >= 0; i--) {
          if(numStr[i] > numStr[maxValueIndex]) {
            maxValueIndex = i;
          } else if(numStr[i] < numStr[maxValueIndex]) {
            swap1 = i;
            swap2 = maxValueIndex;
          }
        }

        if(swap1 != -1) {
            char tmp = numStr[swap1];
            numStr[swap1] = numStr[swap2];
            numStr[swap2] = tmp;
        }

        return stoi(numStr);
    }
};