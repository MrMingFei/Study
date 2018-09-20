package com.Interview.fourthchapter;

import java.util.ArrayList;

public class ClockwisePrintMatrix {
    public static ArrayList<Integer> printMatrix(int[][] matrix){
        ArrayList<Integer> list = new ArrayList<Integer>();
        int start = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (matrix == null|| rows <= 0 || cols <= 0)
            return null;
        while (cols > start*2 && rows > start*2){
            printMatrixCircle(list, matrix, rows, cols, start);
            start++;
        }
        return list;
    }
    public static void printMatrixCircle(ArrayList<Integer> list, int[][] matrix, int rows, int cols, int start){
        int endX = cols - 1 - start;
        int endY = rows - 1 - start;
        //从左到右打印一行
        for (int i = start; i <= endX; i++){
            int number = matrix[start][i];
            list.add(number);
        }
        //从上到下打印一列
        if (start < endY){
            for (int i = start+1; i <= endY; i++){
                int number = matrix[i][endX];
                list.add(number);
            }
        }
        //从右到左打印一行
        if (start < endY && start < endX){
            for (int i = endX-1; i >= start; i--){
                int number = matrix[endY][i];
                list.add(number);
            }
        }
        //从下到上打印一样
        if (start < endX && start < endY-1){
            for (int i = endY-1; i >= start+1; i--){
                int number = matrix[i][start];
                list.add(number);
            }
        }
    }
    public static void main(String[] args){
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        ArrayList<Integer> list = printMatrix(matrix);
        System.out.println(list);
    }
}
