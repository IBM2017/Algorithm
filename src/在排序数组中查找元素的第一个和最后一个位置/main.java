package 在排序数组中查找元素的第一个和最后一个位置;

public class main {
    public static void main(String[] a){
        Solution solution = new Solution();
        int[] save = solution.searchRange(new int[]{1,1,1,1,3,3,3},2);
        System.out.println(save[0]+" "+save[1]);
        ;
    }
}
