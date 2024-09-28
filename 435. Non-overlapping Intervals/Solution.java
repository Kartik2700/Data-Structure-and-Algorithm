class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> a[1]-b[1]) ;

        int count =1; int lastEndTime = intervals[0][1];
        for(int i=0;i<intervals.length;i++){
            System.out.println(intervals[i][0]+ " " + intervals[i][1]);
        }
        for(int i=1;i<intervals.length;i++){
            if(lastEndTime <= intervals[i][0]){
                lastEndTime = intervals[i][1];
                count++;
            }
        } 
        
        return intervals.length-count;
    }
}