class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        Arrays.sort(nums);
        int longest=1;
        int cnt=1;
        int last_smaller=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]-1==last_smaller){
                last_smaller = nums[i];
                cnt++;
            }
            else if(nums[i]==last_smaller){
                continue;
            }
            else if(nums[i]-1!=last_smaller){
                last_smaller = nums[i];
                cnt=1;
            }
            longest=Math.max(longest,cnt);
        }
        //  longest=Math.max(longest,cnt);
        return longest;
    }
}