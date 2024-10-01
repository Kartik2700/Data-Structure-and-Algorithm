class Solution {

    private void comSum(int index,int[] candidates,int target, List<List<Integer>>ans,List<Integer>temp){
        if(index==candidates.length){
            if(target==0) {
                ans.add(new ArrayList<>(temp));
            }
            return;
        }

        if(target>=candidates[index]){
            temp.add(candidates[index]);
            comSum(index,candidates,target-candidates[index],ans,temp);
            temp.remove(temp.size()-1);
        }
        comSum(index+1,candidates,target,ans,temp);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

     List<List<Integer>>ans = new ArrayList<>();

    comSum(0,candidates,target,ans,new ArrayList<>());   
     return ans;
    }
}