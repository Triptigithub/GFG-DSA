class Solution {
public int upperBound(int i, int tar , int[][] arr){
    int s = 0;
    int e = arr[i].length - 1;
    while(s <= e){
        int mid = s + (e - s) / 2;
        if(arr[i][mid] <= tar){
            s = mid + 1;   // move right
        } else {
            e = mid - 1;   // move left
        }
    }
    return s; // index of first > tar (== count of ≤ tar)
}





    public int solver(int mid,int[][] arr){
        //for each row of matrix find upper bound
        int ans = 0;
        for(int i=0; i<arr.length; i++){
            ans += upperBound(i,mid,arr);
        }
        
        return ans;
        
    }
    public int median(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int space = n*m/2;
       int s = Integer.MAX_VALUE;
       //loop over first col to find min value;
        for(int i=0;i<mat.length;i++){
            if(mat[i][0] < s){
                s = mat[i][0];
            }}
            
            int e = Integer.MIN_VALUE;
            for(int i=0;i<mat.length;i++){
                if(mat[i][m-1] >e){
                    e = mat[i][m-1];
                }}
                
                
                
        //now applly binary search
        while(s<=e){
            int mid = s+(e-s)/2;
            int cntofValuesSmallerthanEqualMid = solver(mid,mat);
            
            if(cntofValuesSmallerthanEqualMid <= space){
                s = mid+1;
            }else{
                e = mid-1;
            }
            
            
         }
         return s;
    }
}