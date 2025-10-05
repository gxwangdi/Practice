
public class MaximumGap {
	/*
     * @param nums: an array of integers
     * @return: the maximun difference
     */
    public int maximumGap(int[] nums) {
        if(null == nums || nums.length < 2)
        {
            return 0;
        }

        int length = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;   

        for(int i = 0;i < length;i++)
        {
            if(nums[i] < min)
            {
                min = nums[i];
            }

            if(nums[i] > max)
            {
                max = nums[i];
            }
        }
        
        int bucketCapacity = (max - min) / length + 1;
        int bucketNumber = (max - min) / bucketCapacity + 1;
        int[] minBuckets = new int[bucketNumber];
        int[] maxBuckets = new int[bucketNumber];
        int maxDistance = 0;

        for(int i = 0;i < bucketNumber;i++)
        {
            minBuckets[i] = Integer.MAX_VALUE;
            maxBuckets[i] = Integer.MIN_VALUE;
        }

        for(int i = 0;i < length;i++)
        {
            int index = (nums[i] - min) / bucketCapacity;
            if(minBuckets[index] > nums[i])
            {
                minBuckets[index] = nums[i];
            }

            if(maxBuckets[index] < nums[i])
            {
                maxBuckets[index] = nums[i];
            }
        }

        int pre = 0;
        for(int i = 1;i < bucketNumber;i++)
        {
            if(minBuckets[i] == Integer.MAX_VALUE && maxBuckets[i] == Integer.MIN_VALUE)
                continue;
            if(minBuckets[i] - maxBuckets[pre] > maxDistance)
            {
                maxDistance = minBuckets[i] - maxBuckets[pre]; 
            }
            pre = i;
        }
        return  maxDistance;
    }
}
