class Solution {
    private boolean isPalindrome(String s,int i,int j){
        while(i<=j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;j--;
        }
        return true;
    }
    private void func(int index,String s,List<List<String>>ans,List<String>part ){
        if(index == s.length()){
            ans.add(new ArrayList<>(part));
            return;
        }

        for(int i=index;i<s.length();i++){
            if(isPalindrome(s,index,i)){
                part.add(s.substring(index,i+1));
                func(i+1,s,ans,part);
                part.remove(part.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        
        List<List<String>>ans = new ArrayList<>();
        List<String>part = new ArrayList<>();   
        func(0,s,ans,part);

        return ans; 
    }
}