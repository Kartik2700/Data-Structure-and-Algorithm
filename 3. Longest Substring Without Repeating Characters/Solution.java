class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int ans = 1;
        int cnt=0;
        while (right < s.length()) {
            if(map.containsKey(s.charAt(right))){
                if(map.get(s.charAt(right))+1 > left )
                    left = map.get(s.charAt(right))+1;
                map.put(s.charAt(right),right);
                cnt = right - left + 1;
                ans = Math.max(ans,cnt);
                right++;
            }else{
                map.put(s.charAt(right),right);
                cnt = right - left + 1;
                ans = Math.max(ans,cnt);
                right++;
                
            }
        }
        return ans;

    }
}