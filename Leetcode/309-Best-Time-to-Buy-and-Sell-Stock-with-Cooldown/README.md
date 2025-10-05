Do not have any idea at this time. Reference a posting in discuss:
https://discuss.leetcode.com/topic/30431/easiest-java-solution-with-explanations/2   

Basically the solution needs two dp array.  Well, this is the trick. Normally I suppose only one dp array  can persist all the partial result.  

1. Define States

To represent the decision at index i:

buy[i]: Max profit till index i. The series of transaction is ending with a buy.
sell[i]: Max profit till index i. The series of transaction is ending with a sell.
To clarify:

Till index i, the buy / sell action must happen and must be the last action. It may not happen at index i. It may happen at i - 1, i - 2, ... 0.
In the end n - 1, return sell[n - 1]. Apparently we cannot finally end up with a buy. In that case, we would rather take a rest at n - 1.
For special case no transaction at all, classify it as sell[i], so that in the end, we can still return sell[n - 1]. Thanks @alex153 @kennethliaoke @anshu2.
2. Define Recursion

buy[i]: To make a decision whether to buy at i, we either take a rest, by just using the old decision at i - 1, or sell at/before i - 2, then buy at i, We cannot sell at i - 1, then buy at i, because of cooldown.
sell[i]: To make a decision whether to sell at i, we either take a rest, by just using the old decision at i - 1, or buy at/before i - 1, then sell at i.
So we get the following formula:

buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);   
sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);   

 