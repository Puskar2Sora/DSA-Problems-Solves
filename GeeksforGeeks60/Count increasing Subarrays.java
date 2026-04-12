class Solution {
  public:
    int countIncreasing(vector<int>& arr) {
        int n = arr.size();
        if (n < 2) return 0;
        int totalCount = 0;
        int len = 1; 
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                len++;
                totalCount += (len - 1);
            }
            else
                len = 1;
        }
        return totalCount;
    }
};

