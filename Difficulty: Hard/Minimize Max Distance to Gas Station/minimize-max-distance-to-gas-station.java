class Solution {
    public double minMaxDist(int[] arr, int k) {
        int n = arr.length;
        
        // search space: from 0.0 to maxGap
        double s = 0.0;
        double e = arr[n - 1] - arr[0];
        
        while (e - s > 1e-6) {
            double mid = s + (e - s) / 2.0;
            
            if (canPlace(arr, k, mid)) {
                e = mid;  // try smaller distance 
                //means 
            } else {
                s = mid;  // need bigger distance
            }
        }
        
        return s;
    }
    
    // Check if we can ensure max distance <= dist with at most k stations
    private boolean canPlace(int[] arr, int k, double dist) {
        int used = 0;
        
        for (int i = 0; i < arr.length - 1; i++) {
            double gap = arr[i + 1] - arr[i];
            used += (int)(gap / dist);  // stations needed in this gap *************************
        }
        
        return used <= k;
    }
}
