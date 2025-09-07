class Solution {
       static int nextGap(int gap) {
        if (gap <= 1) return 0;
        return (gap / 2) + (gap % 2); // ceil(gap/2)
    }

    // Merge function using Hive (Gap) method
    static void merge(int arr1[], int arr2[], int n, int m) {
        int gap = n + m;  // combined length

        for (gap = nextGap(gap); gap > 0; gap = nextGap(gap)) {
            int i, j;

            // Case 1: Compare elements in arr1
            for (i = 0; i + gap < n; i++) {
                if (arr1[i] > arr1[i + gap]) {
                    int temp = arr1[i];
                    arr1[i] = arr1[i + gap];
                    arr1[i + gap] = temp;
                }
            }

            // Case 2: Compare elements between arr1 and arr2
            for (j = (gap > n ? gap - n : 0); i < n && j < m; i++, j++) {
                if (arr1[i] > arr2[j]) {
                    int temp = arr1[i];
                    arr1[i] = arr2[j];
                    arr2[j] = temp;
                }
            }

            // Case 3: Compare elements in arr2
            if (j < m) {
                for (j = 0; j + gap < m; j++) {
                    if (arr2[j] > arr2[j + gap]) {
                        int temp = arr2[j];
                        arr2[j] = arr2[j + gap];
                        arr2[j + gap] = temp;
                    }
                }
            }
        }
    }



    public int kthElement(int a[], int b[], int k) {
        merge(a, b, a.length, b.length);
    
    // k is 1-based, convert to 0-based
    int index = k - 1;  
    
    if (index < a.length) {
        return a[index];
    } 
        return b[index - a.length];
    

        
    }
}