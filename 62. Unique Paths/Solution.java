class Solution {
    public int uniquePaths(int m, int n) {
        int totalSteps=m+n-2;
        double ans = 1;
        int r=m-1;
        for(int i=1;i<=r;i++){
            ans = ans*(totalSteps-r+i);
            ans = ans/(i);
        }
        return (int)ans;
    }
}