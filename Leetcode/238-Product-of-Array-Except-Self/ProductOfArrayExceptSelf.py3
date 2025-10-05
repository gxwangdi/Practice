class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        res=[]
        p=1
        res.append(1)
        for i in range(1, len(nums), 1):
            p*=nums[i-1]
            res.append(p)

        p=1
        for i in range(len(nums)-2, -1, -1):
            p *= nums[i+1]
            res[i] *= p
        return res

        
