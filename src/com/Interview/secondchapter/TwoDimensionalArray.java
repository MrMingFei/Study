package com.Interview.secondchapter;

public class TwoDimensionalArray {
    /**
     * 二维数组中的查找
     * @param matrix
     * @param rows
     * @param columns
     * @param number
     * @return
     */
    public static boolean find(int[][] matrix, int rows, int columns, int number){
        boolean found = false;
        if (matrix != null && rows > 0 && columns > 0){
            for (int row = 0, column = columns-1; row < rows && column >= 0;){
                if (matrix[row][column] == number){
                    found = true;
                    break;
                }else if (matrix[row][column] > number){
                    column--;
                }else {
                    row++;
                }
            }
        }
        return found;
    }

    public static void main(String[] args){
        int[][] matrix = {{1, 2, 8, 9},{2, 4, 9, 12},{3, 7, 10, 13}};//,{6, 8, 11, 15}
        boolean result = find(matrix, 3, 4, 3);
        System.out.println(result);
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
    }
}
