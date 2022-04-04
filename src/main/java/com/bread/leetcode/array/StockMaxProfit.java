package com.bread.leetcode.array;

/**
 * @program: leet-code-notes
 * @description: 122题  买股票的最佳方案
 * @author: LiuTuo
 * @create: 2022-04-04 16:49
 **/
public class StockMaxProfit {
    public int maxProfit(int[] prices) {
        int profit=0;
        if(prices.length<2){
            return profit;
        }
        for(int i=1;i<prices.length;i++){
            int tmp=prices[i]-prices[i-1];
            if(tmp>0){
                profit+=tmp;
            }
        }
        return profit;
    }
}
