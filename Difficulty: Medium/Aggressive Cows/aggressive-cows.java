class Solution {
    public int aggressiveCows(int[] stalls, int k) {
        // code here
        Arrays.sort(stalls);
        int min =stalls[0];
        int max =stalls[stalls.length-1];
        int s = 1;
        int e = max;
        int ans = 0;
        
        while(s<=e){
            int mid  = s+(e-s)/2;
            if(canweplace(mid,k,stalls) == true){
                ans = mid;
                s = mid+1;
            }else{
                e = mid-1;
            }
        }
        return ans;
    }
    
    public boolean canweplace(int dist,int cows,int[]arr){
        int newcow = 1;
        int prevcow = arr[0];
        
        for(int i=1; i<arr.length;i++){
            if(arr[i] - prevcow >= dist){
                newcow++;
                prevcow = arr[i];
            }
            
            if(newcow>= cows)return true;
        }
        
        return false;
    }
}