package 合并区间;

public class QuickSort {
    public void QuickSort(int[][] num,int left,int right){
        //当左端大于等于右端时，该字段排列结束
        if (left>=right){
            return ;
        }
        int[] key = num[left];//确定比较键；
        int i = left,j=right;
        //当右端大于左端时，循环比较
        while (j>i){
            //搜寻右边有值小key
            while (j>i&&num[j][0]>=key[0]){
                j--;
            }
            //存在右边有值小key
            if (i<j){
                //将查询到的位置的值付给左边标记处
                num[i]=num[j];
                //减少遍历次数
                i++;
            }
            //搜寻左边有值大于key
            while (j>i&&num[i][0]<=key[0]){
                i++;
            }
            //存在左边有值大于key
            if (i<j){
                //将查询到的位置的值付给右边标记处
                num[j]=num[i];
                //减少遍历次数
                j--;
            }
        }
        num[i] = key;
        QuickSort(num,left,i-1);
        QuickSort(num,i+1,right);
    }
}
