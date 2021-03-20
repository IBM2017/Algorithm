package 插入区间;

public class Solution {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int length = intervals.length;
        for (int i =0; i<intervals.length;i++){
            System.out.println("test"+i);
            if (newInterval[0]<intervals[i][0]){
                //插入区间与当前区间毫无关联
                if (intervals[i][0]>newInterval[1]){
                    if(i!=0&&intervals[i-1][1]<newInterval[1]&&intervals[i-1][1]>=newInterval[0]){
                        intervals[i-1][1]=newInterval[1];
                        return intervals;
                    }else if (i!=0&&intervals[i-1][1]>=newInterval[1]&&intervals[i-1][1]>=newInterval[0]){
                        return intervals;
                    }else {//与前面一个区间也毫无关联，或者前面无区间
                        return insert(intervals,newInterval,i);//在当前前面插入
                    }
                }
                //插入区间与当前区间有关联
                else{
                    intervals[i][0]=newInterval[0];
                    if (intervals[i][1]<newInterval[1]){
                        intervals[i][1]=newInterval[1];
                    }
                    int begin;
                    if (i==0) begin=1;
                    else begin = i;
                    System.out.println("i+"+begin);
                    for (int j = begin;j<intervals.length;j++){
                        if (intervals[j][0]<=intervals[j-1][1]){
                            if (intervals[j][1]<intervals[j-1][1])
                                intervals[j][1]=intervals[j-1][1];
                            intervals[j][0]=intervals[j-1][0];
                            intervals[j-1][0]=-1;
                            length--;
                        }
                    }
                    int[][] newNums = new int[length][];
                    int k=0;
                    for (int j=0;j<intervals.length;j++){
                        if (intervals[j][0]!=-1){
                            newNums[k++]=intervals[j];
                        }
                    }
                    return newNums;
                }

            }

        }
        System.out.println(length);
        if (length==0){
            return new int[][]{newInterval};
        }
        if (intervals[length-1][1]>=newInterval[0]){
            if (intervals[length-1][1]<newInterval[1])
                intervals[length-1][1]=newInterval[1];
            return intervals;
        }
        return insert(intervals,newInterval,length);
    }

    public static int[][] insert(int[][] intervals, int[] newInterval,int where){
        int[][] newNums = new int[intervals.length+1][];
        for (int i=0,j=0;i<newNums.length&&j<intervals.length;i++,j++){
            if (i==where){
                newNums[i]=newInterval;
                i++;
            }
            newNums[i]=intervals[j];
        }
        if (where==intervals.length){
            newNums[intervals.length]=newInterval;
        }
        return newNums;
    }

    public static void main(String[] a){
        int[][] nums ={{1,5},{6,8},{6,7},{12,16}};
        int[] num = {5,6};
        nums = insert(nums,num);
        for (int i=0;i<nums.length;i++){
            System.out.print("["+nums[i][0]+","+nums[i][1]+"],");
        }
    }
}
