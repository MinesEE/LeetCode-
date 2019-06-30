// 56. Merge Intervals
// Given a collection of intervals, merge all overlapping intervals.
// 
// Example 1:
// 
// Input: [[1,3],[2,6],[8,10],[15,18]]
// Output: [[1,6],[8,10],[15,18]]
// Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
// Example 2:
// 
// Input: [[1,4],[4,5]]
// Output: [[1,5]]
// Explanation: Intervals [1,4] and [4,5] are considered overlapping.
// NOTE: input types have been changed on April 15, 2019. 
// Please reset to default code definition to get new method signature.
class Interval56 {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) return intervals;
        
        Arrays.sort(intervals, (a, b)->Integer.compare(a[0], b[0]));
        
        // int pt = 0;
        int[] curArray = intervals[0];
        List<int[]> list = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] > curArray[1]) {
                list.add(curArray);
                curArray = intervals[i];
                
            } else {
                while (i < intervals.length && intervals[i][0] <= curArray[1]) {
                    if (curArray[1] < intervals[i][1]) {
                        curArray[1] = intervals[i][1];
                    }
                    i++;
                }
                list.add(curArray);
                if (i == intervals.length) return list.toArray(new int[list.size()][]);
                else curArray = intervals[i];
            }
        }
        list.add(curArray);
        return list.toArray(new int[list.size()][]);
    }
}