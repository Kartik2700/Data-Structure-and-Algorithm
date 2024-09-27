class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int cookie=0;
        int childGreed=0;

        while(cookie<s.length && childGreed<g.length){

            if(s[cookie]>=g[childGreed]){
                childGreed++;
            }
            cookie++;
        }

        return childGreed;

    }
}