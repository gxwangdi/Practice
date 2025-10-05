
class 132Pattern {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        if (n<3) {
            return false;
        }
        var stack = new Stack<Integer>();
        int ls = Integer.MIN_VALUE;
        for (int i=n-1; i>=0; i--) {
            if (nums[i] < ls) {
                return true;
            }
            while (!stack.isEmpty() && nums[i]>stack.peek()) {
                ls = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }

    // public boolean find132pattern(int[] nums) {
    //     int n=nums.length;
    //     if (n<3) return false;
    //     int minLeft=nums[0];
    //     for (int j=0; j<n; j++)
    //     {
    //         minLeft = Math.min(minLeft, nums[j]);
    //         if (minLeft==nums[j]) continue;
    //         for (int k=n-1; k>j; k--)
    //             if (nums[k]>minLeft && nums[k]<nums[j])
    //                 return true;
    //     }
    //     return false;
    // }

//     public boolean find132pattern(int[] nums) {
//         if(nums == null || nums.length < 3) {
//             return false;
//         }
//         int i=nums.length-2;
//         int min = nums[nums.length-1];
//         int max = nums[nums.length-1];
//         while (i>0) {
//             if (nums[i] <= min) {
//                 i--;
//                 continue;
//             }
//             // nums[i] > min
//             max = nums[i];
//             break;

//         }
//         if (i==0) {
//             return false;
//         }
//         i -=1;
//         // System.out.println("min:" + min);
//         // System.out.println("max:" + max);
//         while (i>=0) {
//             if (nums[i] < min) {
//                 return true;
//             }
//             if (nums[i] > max) {
//                 min = max;
//                 max = nums[i];
//             }
//             i--;
//         }
//         return false;
//     }


    // public boolean find132pattern(int[] nums) {
    //     if(nums == null || nums.length < 3) {
    //         return false;
    //     }
    //     var isUp = nums[1] > nums[0]? true : false;
    //     for(int i =2; i<nums.length; i++) {
    //         if (nums[i] > nums[i-1]) {
    //             isUp = true;
    //             continue;
    //         }
    //         // nums[i] < nums[i-1]
    //         if (nums[i] > nums[i-2] && isUp) {
    //             return true;
    //         }
    //         isUp = false;
    //     }
    //     return false;
    // }
}
