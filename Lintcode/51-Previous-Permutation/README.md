This is pretty much like next permutation, just change the condition as:

for (int i=nums.lenth-2; i>=0; i--)

if (nums[i] > nums[i+1]) break;

for (int j=i; j<num.length-1; j++)

if (nums[j+1]>=nums[i]) break;   

