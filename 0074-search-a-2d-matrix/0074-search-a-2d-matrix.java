class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low1=0;
        int high1=matrix.length-1;
        while(low1<=high1){
            int mid1= low1+(high1-low1)/2;
            int low2=0;
            int high2=matrix[mid1].length-1;
            if(target<matrix[mid1][low2]){
                high1=mid1-1;
            }else if(target>matrix[mid1][high2]){
                low1=mid1+1;
            }else{
                while(low2<=high2){
                    int mid2=(high2+low2)/2;
                    if(target==matrix[mid1][mid2]){
                        return true;
                    }else if(target<matrix[mid1][mid2]){
                        high2=mid2-1;
                    }else{
                        low2=mid2+1;
                    }
                }
                return false;
            }
        }
        return false;
    }
}