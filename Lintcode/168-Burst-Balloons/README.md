
Reference: https://www.hrwhisper.me/leetcode-burst-balloons/

最后的剩下一个气球为i的时候，可以获得的分数为：nums[-1]*nums[i]*nums[n].
那么介于i,j之间的x，有： dp[i][j] = max(dp[i][j], dp[i][x – 1] + nums[i – 1] * nums[x] * nums[j + 1] + dp[x + 1](j));
这里，为了方便代码书写，我在首尾插入了两个1，所以答案是 dp[1](n) (n为原来的长度)
可以用记忆化搜索也可以直接迭代DP,当然，记忆化搜索更好理解一点。

 