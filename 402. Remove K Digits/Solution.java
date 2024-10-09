class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < num.length(); i++) {
            while (!st.empty() && k != 0 && st.peek() > num.charAt(i) - '0') {
                st.pop();
                k--;
            }
            st.push(num.charAt(i) - '0');
        }

        while (k > 0) {
            st.pop();
            k--;
        }

        if (st.empty())
            return "0";

        String ans = "";

        while (!st.empty()) {
            ans += st.peek();
            st.pop();
        }

        String res = "";
        int index;
        for (index = ans.length() - 1; index > 0; index--) {
            if (ans.charAt(index) != '0') {
                break;
            }
        }
        for (int i = index; i >= 0; i--) {
            res += ans.charAt(i);
        }
        return res;
    }
}