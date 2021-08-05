package com.hwj.arr;

public class Solution240 {

    public boolean searchMatrix(int[][] matrix, int target) {

        //找左下角的元素和target相比较
        int i = matrix.length-1,j=0;
        while(i>=0 && j<matrix[0].length) {

            if(target == matrix[i][j]) {

                return true;
            }
            else if(target > matrix[i][j]) {

                j++;
            }
            else if(target < matrix[i][j]) {

                i--;
            }
        }
        return false;
    }
}
