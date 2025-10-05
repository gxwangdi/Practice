func twoSum(nums []int, target int) []int {
    hashMap := make(map[int]int)
    for index, value := range nums {
        key := target - nums[index]
        if priorIndex, ok := hashMap[key]; ok {
            return []int{priorIndex, index}
        }
        hashMap[value] = index
    }
    return nil
}
