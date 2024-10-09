class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();

        int maxArea = 0;

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
            int nse = heights.length;
            int element = heights[st.peek()];
            st.pop();
            int pse = st.empty() ? -1 : st.peek();
            maxArea = Math.max(maxArea, element * (nse - pse - 1));
        }

        return maxArea;
    }
}