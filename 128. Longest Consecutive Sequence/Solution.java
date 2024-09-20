class Solution {
    public int longestConsecutive(int[] nums) {
        int ans =0;
        Set<Integer>hashset= new HashSet<>();
        for(int i=0;i<nums.length;i++){
            hashset.add(nums[i]);
        }   

        for(int it: hashset){

            if(!hashset.contains(it-1)){
                int element = it;
                int cnt =1;

                while(hashset.contains(element+1)){
                    cnt++;
                    element++;
                }   

                ans = Math.max(ans,cnt);
            }
        }
        return ans;
    }
}