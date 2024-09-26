class Solution {
    // public int trap(int[] height) {
    //     int ans=0;
    //     int n=height.length;
    //     int[] prefix = new int[n];
    //     int [] suffix = new int[n];
    //     prefix[0]=height[0];
    //     suffix[n-1]=height[n-1];
    //     int j=1;
    //      while(j<n){
    //             prefix[j] = Math.max(prefix[j-1],height[j]);
    //             j++;
    //         }

    //         j=n-2;
    //         while(j>=0){
    //             suffix[j]=Math.max(suffix[j+1],height[j]);
    //             j--;
    //         }
    //     for(int i=0;i<height.length;i++){
    //         int leftMax=0,rightMax=0;
    //         ans += Math.min(prefix[i],suffix[i])-height[i];
            
    //     }
    //     return ans;
    // }

    public int trap(int[] height) {

        int lMax=0,rMax=0,total=0;
        int l=0,r=height.length-1;
        while(l<r){
            if(height[l]<=height[r]){
                if(height[l]<lMax){
                    total += lMax -height[l];
                }else{
                    lMax=height[l];
                }
                l++;
            }else{
                if(height[r]<rMax){
                    total += rMax - height[r];
                }else{
                    rMax = height[r];
                }
                r--;
            }
        }
        return total;
    }
}