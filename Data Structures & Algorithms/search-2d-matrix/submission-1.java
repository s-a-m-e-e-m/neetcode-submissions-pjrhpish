class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int targetRow = -1;

        for(int i=0;i<m;i++){
            if(matrix[i][0]<=target && matrix[i][n-1]>=target) 
                targetRow = i;
        }

        if(targetRow==-1) return false;

        int lo = 0, hi = n-1;
        while(lo<=hi){
            int mid = lo + (hi-lo)/2;
            if(matrix[targetRow][mid]==target) return true;
            else if(matrix[targetRow][mid] < target) lo = mid+1;
            else hi = mid-1;
        }

        return false;
    }
}
