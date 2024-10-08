public class Solution {

    private List<Long> findNSE(int[] arr, int n) {
        Stack<Integer> st = new Stack<>();
        List<Long> nse = new ArrayList<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.empty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            nse.add(st.empty() ? (long) n : (long) st.peek());
            st.push(i);
        }
        Collections.reverse(nse);
        return nse;
    }

    private List<Long> findPSEE(int[] arr, int n) {
        Stack<Integer> st = new Stack<>();
        List<Long> psee = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            while (!st.empty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            psee.add(st.empty() ? -1L : (long) st.peek());
            st.push(i);
        }
        return psee;
    }

    public long sumSubarrayMins(int[] arr) {
        int n = arr.length;
        List<Long> nse = findNSE(arr, n);
        List<Long> psee = findPSEE(arr, n);

        long total = 0;

        for (int i = 0; i < n; i++) {
            long left = i - psee.get(i);
            long right = nse.get(i) - i;

            total = total + left * right * arr[i];
        }
        return total;
    }

    private List<Long> findNGE(int[] arr, int n) {
        Stack<Integer> st = new Stack<>();
        List<Long> nge = new ArrayList<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.empty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }

            nge.add(st.empty() ? (long) n : (long) st.peek());
            st.push(i);
        }
        Collections.reverse(nge);
        return nge;
    }

    private List<Long> findPGEE(int[] arr, int n) {
        Stack<Integer> st = new Stack<>();
        List<Long> pgee = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            while (!st.empty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }

            pgee.add(st.empty() ? -1L : (long) st.peek());
            st.push(i);
        }
        return pgee;
    }

    public long sumSubarrayMaxs(int[] arr) {
        int n = arr.length;
        List<Long> nge = findNGE(arr, n);
        List<Long> pgee = findPGEE(arr, n);

        long total = 0;

        for (int i = 0; i < n; i++) {
            long left = i - pgee.get(i);
            long right = nge.get(i) - i;

            total = total + left * right * arr[i];
        }
        return total;
    }

    public long subArrayRanges(int[] nums) {
        long mins = sumSubarrayMins(nums);
        long maxs = sumSubarrayMaxs(nums);

        return maxs - mins;
    }
}
