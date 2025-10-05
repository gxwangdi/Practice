/**
 * @param {string} s1
 * @param {string} s2
 * @param {string} s3
 * @return {boolean}
 */
var isInterleave = function(s1, s2, s3) {
    let dp = [];
    const len1 = s1.length;
    const len2 = s2.length;
    const len3 = s3.length;

    if (len1 + len2 !== len3) {
        return false;
    }

    for (let i = 0; i <= len1; i++) {
        const arr = new Array(len2 + 1).fill(false);
        dp.push(arr);
    }

    dp[0][0] = true;

    for (let i = 1; i <= len1; i++) {
        dp[i][0] = s1.charAt(i - 1) === s3.charAt(i - 1);

        if (!dp[i][0]) {
            break;
        }
    }

    for (let j = 1; j <= len2; j++) {
        dp[0][j] = s2.charAt(j - 1) === s3.charAt(j - 1);

        if (!dp[0][j]) {
            break;
        }
    }

    for (let i = 1; i <= len1; i++) {
        for (let j = 1; j <= len2; j++) {
            let k = i + j - 1;

            dp[i][j] = (dp[i][j - 1] && (s2.charAt(j - 1) === s3.charAt(k))) || (dp[i - 1][j] && (s1.charAt(i - 1) === s3.charAt(k)));
        }
    }

    return dp[len1][len2];
};
