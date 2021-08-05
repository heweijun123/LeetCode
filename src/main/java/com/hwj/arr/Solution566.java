package com.hwj.arr;

public class Solution566 {

    public int[][] matrixReshape(int[][] mat, int r, int c) {

        int a = mat.length;
        int b = mat[0].length;
        if(a*b!=r*c) {

            return mat;
        }
        int[][] rtn = new int[r][c];
        int count=0;
        for (int i = 0; i < r; i++) {

            for (int j = 0; j < c; j++) {

                rtn[i][j] = mat[count / b][count % b];
                count++;
            }
        }
        return rtn;
    }
}
