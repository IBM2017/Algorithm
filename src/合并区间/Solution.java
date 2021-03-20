package 合并区间;

public class Solution {
    public static int[][] merge(int[][] intervals) {
        int length = intervals.length;
        if (length<2) return intervals;
        QuickSort test = new QuickSort();
        test.QuickSort(intervals,0,length-1);
        for (int i = 1;i<intervals.length;i++){
            if (intervals[i][0]<=intervals[i-1][1]){
                if (intervals[i][1]<intervals[i-1][1])
                    intervals[i][1]=intervals[i-1][1];
                intervals[i][0]=intervals[i-1][0];
                intervals[i-1][0]=-1;
                length--;
            }
        }
        int[][] newNums = new int[length][];
        int k=0;
        for (int i=0;i<intervals.length;i++){
            if (intervals[i][0]!=-1){
                newNums[k++]=intervals[i];
            }
        }
        return newNums;
    }
    public static void main(String[] a){
        int[][] nums ={{12,14},{5,9},{0,1},{3,4},{2,4},{7,9}};
        nums = merge(nums);
        for (int i=0;i<nums.length;i++){
            System.out.print("["+nums[i][0]+","+nums[i][1]+"],");
        }
    }
}
