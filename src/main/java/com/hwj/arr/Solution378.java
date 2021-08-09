package com.hwj.arr;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution378  {

    //利用PriorityQueue实现n个数组归并排序
    public int kthSmallest(int[][] matrix, int k) {

        int n = matrix.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < n; i++) {

            queue.add(new int[]{matrix[i][0], i, 0});
        }
        int count = 0;
        int[] item = queue.poll();
        while (item != null) {

            count++;
            if (count == k) {

                return item[0];
            }
            if (item[2] + 1 < n) {

                queue.add(new int[]{matrix[item[1]][item[2] + 1], item[1], item[2] + 1});
            }
            item = queue.poll();
        }
        return -5;
    }

    //二分法
    public int kthSmallest2(int[][] matrix, int k) {

        int min = matrix[0][0];
        int max = matrix[matrix.length-1][matrix[0].length-1];
        while(min<=max) {

            int middle = min + (max - min) / 2;
            int x = matrix.length-1;
            int y = 0;
            int count=0;
            while(x>=0 && x<= matrix.length-1 && y>=0&& y<=matrix[0].length-1) {

                if(matrix[x][y]<middle) {

                    count+=x+1;
                    y+=1;
                }
                else {

                    x-=1;
                }
            }
            if(count<k) {

                min = middle+1;
            }
            else {

                max = middle-1;
            }
        }
        return min;
    }
}
