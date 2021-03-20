package 下一个排列;

public class main {
    public static void main(String[] se){
        int[] test =new  int[]{1,2,3};
        Solution solution = new Solution();
        solution.nextPermutation(test);
        for (int j=0;j<test.length;j++){
            System.out.print(test[j]+",");
        }
    }
}
