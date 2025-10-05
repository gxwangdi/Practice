/**
 * @param {number} n
 * @return {number}
 */
var integerReplacement = function(n) {
    let dp = []

    function solve(num) {
        if(num==1) {
            return 0
        }
        if(dp[num]) {
            return dp[num]
        }
        if(num%2==0) {
            dp[num] = solve(num/2)+1
        } else {
            // odd number
            let a = solve(num-1) +1
            let b = solve((num+1)/2)+2
            dp[num] = Math.min(a,b)
        }
        return dp[num]
    }

    return solve(n)
};

// TLE
// var integerReplacement = function(n) {
//     var count = 0
//     while (n!=1) {
//         var small = n&(n-1)
//         var big = n&(n+1)
//         if ((n&1)==0) {
//             n>>=1
//         } else if ((small&(small-1)) <= (big&(big-1))) {
//             n-=1
//         } else {
//             n+=1
//         }
//         count+=1
//     }
//     return count
// };
