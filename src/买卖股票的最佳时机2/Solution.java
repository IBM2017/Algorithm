package 买卖股票的最佳时机2;

public class Solution {
    public int maxProfit(int[] prices) {
        int saves = 0;
        int location = prices[0];
        for (int i=1 ;i<prices.length;i++){
            if (prices[i-1]>prices[i]){
                saves +=prices[i-1]-location;
                location = prices[i];
            }
        }
        saves+=prices[prices.length-1]-location;
        return saves;
    }
}
