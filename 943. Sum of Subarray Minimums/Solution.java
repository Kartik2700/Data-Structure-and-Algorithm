import java.util.*;

public class Solution {
    static final long MOD = (long) 1e9 + 7;

    private List<Integer> findNSE(int[] arr, int n) {
        Stack<Integer> st = new Stack<>();
        List<Integer> nse = new ArrayList<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.empty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            nse.add(st.empty() ? n : st.peek());
            st.push(i);
        }
        Collections.reverse(nse);
        return new ArrayList<>(nse);
    }

    private List<Integer> findPSEE(int[] arr, int n) {
        Stack<Integer> st = new Stack<>();
        List<Integer> psee = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            while (!st.empty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            psee.add(st.empty() ? -1 : st.peek());
            st.push(i);
        }
        return new ArrayList<>(psee);
    }

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        List<Integer> nse = findNSE(arr, n);
        List<Integer> psee = findPSEE(arr, n);

        long total = 0;

        for (int i = 0; i < n; i++) {
            int left = i - psee.get(i);
            int right = nse.get(i) - i;

            total = (total + (long) left * right * arr[i] % MOD) % MOD;
        }
        return (int) total;
    }
}
