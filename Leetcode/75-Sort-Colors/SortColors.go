func sortColors(nums []int)  {
    if nums == nil || len(nums)<2 {
        return
    }
    cur:=0
    left:=0
    length:=len(nums)
    right:=length-1
    for left<length {
        for left<length && nums[left]==cur{
            left+=1
        }
        for right>=0 && nums[right]!=cur{
            right-=1
        }
        if left<right{
            swap(nums, left, right)
            left+=1
            right-=1
        } else {
            right = length-1
            cur+=1
        }
    }
}

func swap(nums []int, i int, j int) {
    nums[i], nums[j] = nums[j], nums[i]
}
