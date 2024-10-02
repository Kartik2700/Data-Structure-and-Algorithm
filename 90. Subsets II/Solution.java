class Solution {

    private void generateSubset(int index , int[]nums,int n,List<List<Integer>>ans,List<Integer>ds){
            ans.add(new ArrayList<>(ds));
        for(int i = index ;i<n;i++){
            if(i > index && nums[i]==nums[i-1] ) continue;

            ds.add(nums[i]);

            generateSubset(i+1,nums,n,ans,ds);

            ds.remove(ds.size()-1);

        }

    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>>ans = new ArrayList<>();

        generateSubset(0,nums,nums.length,ans,new ArrayList<>());

        return ans;
    }
}