/**
 * @param {number[]} coins
 * @param {number} amount
 * @return {number}
 */
function coinChange(coins, amount) {
  var dp = [];
  dp[0] = 0;
  if (amount < 1) {
      return 0;
  }
  var result = coinNumber(coins, amount, dp);
  return result;
};

function coinNumber(coins, amount, dp) {
  if (amount < 0) return -1;
  if (amount == 0) return 0;
  for (var i = 0; i < coins.length; i++) {
    if (!dp[amount - coins[i]])
      tmp = coinNumber(coins, amount - coins[i], dp);
    else
      tmp = dp[amount - coins[i]];
    if (tmp == -1) {
      if (!dp[amount]) {
        dp[amount] = -1;
        continue;
      }
    } else {
      if (dp[amount] == -1 || !dp[amount]) {
        dp[amount] = tmp + 1;
      } else
        dp[amount] = Math.min(dp[amount], tmp + 1);
    }
  }
  return dp[amount];
}
