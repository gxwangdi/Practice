func groupAnagrams(strs []string) [][]string {
    m := make(map[string][]string, 0)
    res := make([][]string, 0)
    for _, val := range strs {
        strArr := strings.Split(val, "")
        sort.Strings(strArr)
        sortedStr := strings.Join(strArr, "")
        m[sortedStr] = append(m[sortedStr], val)
    }
    for _, val := range m {
        res = append(res, val)
    }
    return res
}
