class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        if(nums.length==0 || k==0 || multiplier ==0){
            return nums;
        }
		if(k!=0) {
			int length = nums.length-1;
			int min= nums[0];
			int index=0;
			for(int i=1;i<=length;i++) {
				if(nums[i]<min) {
					min= nums[i];
					index =i;
				}
			}
			nums[index]=min*multiplier;
			
			getFinalState(nums, k-1, multiplier);
		}
        return nums;
    }
}