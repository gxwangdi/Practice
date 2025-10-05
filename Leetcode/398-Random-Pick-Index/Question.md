# 398. Random Pick Index

[Original Page](https://leetcode.com/problems/random-pick-index/)

Given an array of integers with possible duplicates, randomly output the index of a given target number. You can assume that the given target number must exist in the array.

**Note:**  
The array size can be very large. Solution that uses too much extra space will not pass the judge.

**Example:**

<pre>int[] nums = new int[] {1,2,3,3,3};
Solution solution = new Solution(nums);

// pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
solution.pick(3);

// pick(1) should return 0\. Since in the array only nums[0] is equal to 1.
solution.pick(1);
</pre>

<div>

[Subscribe](/subscribe/) to see which companies asked this question

</div>

<div>

<div id="tags" class="btn btn-xs btn-warning">Show Tags</div>

<span class="hidebutton" style="display: none;">[Reservoir Sampling](/tag/reservoir-sampling/)</span></div>

<div>

<div id="similar" class="btn btn-xs btn-warning">Show Similar Problems</div>

<span class="hidebutton">[(M) Linked List Random Node](/problems/linked-list-random-node/)</span></div>