// User function Template for Java
//understand the intuition frrom striver cnt inversion of an  array question
class Solution {
   static int ans;
    static void combine(int low,int mid,int high,int[] arr){
      ArrayList<Integer> temp = new ArrayList<>(); // temporary array
        int left = low;      // starting index of left half of arr
        int right = mid + 1;   // starting index of right half of arr

        //storing elements in the temporary array in a sorted manner//

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                ans+=mid-left+1;
                right++;
            }
        }

        // if elements on the left half are still left //

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        //  if elements on the right half are still left //
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // transfering all elements from temporary to arr //
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    
        
    }
    static void merge(int[] arr,int left,int right){
        if(left>=right)return;
        int mid = (left+right)/2;
        merge(arr,left,mid);
        merge(arr,mid+1,right);
        combine(left,mid,right,arr);
        
    }
    // Function to count inversions in the array.
    static int inversionCount(int arr[]) {
        ans=0;
        int n = arr.length-1;
        
        
        merge(arr,0,n);
        return ans;
        
    }
}