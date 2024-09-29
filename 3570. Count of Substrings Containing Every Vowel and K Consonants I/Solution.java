class Solution {
    public int countOfSubstrings(String word, int k) {
        if(word.length()==5 && k>=1) return 0;
       
        int ans=0;
        for(int i=0;i<word.length();i++){
            int [] arr = new int[26];
            int vowelCount=0;
            int consonant =0;
            int start =0;
            for(int j=i;j<word.length();j++){
                char currentChar = word.charAt(j);
                if (currentChar == 'a' || currentChar == 'e' || currentChar == 'i' || currentChar == 'o' || currentChar == 'u') {
                        if(arr[currentChar - 'a']==0){
                            vowelCount++;
                        }
                         arr[currentChar - 'a']++;
                } else {
                    consonant++;
                }
                if (vowelCount==5 && consonant == k){
                        ans++;
                    }
                }
            }

        return ans;
    }
}