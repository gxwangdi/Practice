
class Findpeakelement {
//     public int findPeakElement(int[] nums) {
//         return search(nums, 0, nums.length - 1);
//     }

//     private int search(int[] nums, int l, int r) {
//         if (l == r) {
//             return l;
//         }
//         int mid = l + (r-l) / 2;
//         if (nums[mid] > nums[mid + 1])
//             return search(nums, l, mid);
//         return search(nums, mid + 1, r);
//     }

    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r-l) / 2;
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}
