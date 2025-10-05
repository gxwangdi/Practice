
The max profit can be achieved by separate the array into two parts, 0...i, i+1....len-1.  

Define dp[i] = maxProfit(0,..., i) + maxProfit(i+1, ..., len-1).  

Then the answer is max (dp[0], dp[1]....dp[len-1]).   

Space O(n),  Time O(n2).  


http://blog.csdn.net/fightforyourdream/article/details/14503469
O(n^2)的算法很容易想到：
找寻一个点j，将原来的price[0..n-1]分割为price[0..j]和price[j..n-1]，分别求两段的最大profit。
进行优化：
对于点j+1，求price[0..j+1]的最大profit时，很多工作是重复的，在求price[0..j]的最大profit中已经做过了。
类似于Best Time to Buy and Sell Stock，可以在O(1)的时间从price[0..j]推出price[0..j+1]的最大profit。
但是如何从price[j..n-1]推出price[j+1..n-1]？反过来思考，我们可以用O(1)的时间由price[j+1..n-1]推出price[j..n-1]。
最终算法：
数组l[i]记录了price[0..i]的最大profit，
数组r[i]记录了price[i..n]的最大profit。
已知l[i]，求l[i+1]是简单的，同样已知r[i]，求r[i-1]也很容易。
最后，我们再用O(n)的时间找出最大的l[i]+r[i]，即为题目所求。

 这有点像不用除法 求数组乘积  除掉目标位置元素的那题～ 