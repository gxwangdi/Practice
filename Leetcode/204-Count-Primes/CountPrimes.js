/**
 * @param {number} n
 * @return {number}
 */
var countPrimes = function(n) {
    if (n<3) {
        return 0
    }
    var primes = new Array(n).fill(true)
    primes[0] = false
    primes[1] = false
    for(var i=2; i*i<n; i++) {
        if (primes[i]) {
            for (var j=i+i; j<n; j+=i) {
                primes[j] = false
            }
        }
    }
    var count = 0
    for (var i=0; i<n; i++) {
        if (primes[i]) {
            count++
        }
    }
    return count
};
