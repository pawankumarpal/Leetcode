class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      int arr[] = new int [nums1.length+nums2.length];
      int count = 0;
      for (int i=0;i<nums1.length;i++){
        arr[i]= nums1[i];
        count++;
      }

      for(int j =0;j<nums2.length;j++){
        arr[count] = nums2[j];
        count++;
      }
      Arrays.sort(arr);
        int arrLength = arr.length;
        double median= 0d;
        if(arrLength%2==0){
         median = (arr[(arrLength/2)-1]+arr[arrLength/2])/2d;
        }else{
            median = arr[arrLength/2];
        }

        return median;
  
    }
}