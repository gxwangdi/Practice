func uniquePaths(m int, n int) int {
    if n<=0 || m<=0 {
        return 0
    }
    N := float64(n+m-2)
    k := float64(m-1)
    res := float64(1.0)
    for i:=1.0; i<=k; i++ {
        res = res * (N - k + i) / i
    }
    return int(res)
}
