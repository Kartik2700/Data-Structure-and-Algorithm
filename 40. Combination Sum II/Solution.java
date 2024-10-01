class Solution {

    private void comSum(int index, int[] candidates, int target, List<List<Integer>> ans, List<Integer> temp) {
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1])
                continue;
            if (target < candidates[i])
                break;

            temp.add(candidates[i]);
            comSum(i + 1, candidates, target - candidates[i], ans, temp);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();

        comSum(0, candidates, target, ans, new ArrayList<>());

        return ans;

    }
}