class Solution {

    private int largestHistogram(int[] heights) {
        int maxArea = 0;
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < heights.length; i++) {
            while (!st.empty() && heights[st.peek()] > heights[i]) {
                int element = heights[st.peek()];
                st.pop();

                int nse = i;
                int pse = st.empty() ? -1 : st.peek();

                maxArea = Math.max(maxArea, element * (nse - pse - 1));
            }
            st.push(i);
        }

        while (!st.empty()) {
            int element = heights[st.peek()];
            st.pop();

            int nse = heights.length;
            int pse = st.empty() ? -1 : st.peek();

            maxArea = Math.max(maxArea, element * (nse - pse - 1));
        }
        return maxArea;
    }

    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] prefixSum = new int[n][m];
        int maxArea = 0;

        for (int j = 0; j < m; j++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                int num = matrix[i][j]-'0';
                sum += num;
                
                if (matrix[i][j]-'0' == 0)
                    sum = 0;

                // System.out.println(sum);
                prefixSum[i][j] = sum;
            }
        }

        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         System.out.println(prefixSum[i][j]);
        //     }
        // }
        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, largestHistogram(prefixSum[i]));
        }

        return maxArea;
    }
}