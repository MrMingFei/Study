package com.Interview.secondchapter;

public class MatrixPath {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        if (matrix == null || rows < 1 || cols < 1 || str == null){
            return false;
        }
        boolean[] visit = new boolean[rows*cols];
        int pathLength = 0;

        for (int row = 0; row < rows; row++){
            for (int col = 0; col < cols; col++){
                if (hasPathCore(matrix, rows, cols, row, col, str, pathLength, visit))
                    return true;
            }
        }
        return false;
    }

    public boolean hasPathCore(char[] matrix, int rows, int cols, int row, int col, char[] str, int pathLength, boolean[] visit){
        if (pathLength == str.length){
            return true;
        }
        if (row >= 0 && row < rows && col >= 0 && col < cols && matrix[row*cols + col] == str[pathLength] && visit[row*cols + col] == false){
            visit[row*cols + col] = true;
            pathLength++;
            if (hasPathCore(matrix, rows, cols, row+1, col, str, pathLength, visit)
                    || hasPathCore(matrix, rows, cols, row-1, col, str, pathLength, visit)
                    || hasPathCore(matrix, rows, cols, row, col+1, str, pathLength, visit)
                    || hasPathCore(matrix, rows, cols, row, col-1, str, pathLength, visit)){
                return true;
            }
            visit[row*cols + col] = false;
            pathLength--;
        }
        return false;
    }
    public static void main(String[] args){
        char[] matrix = {'a', 'b', 't', 'g', 'c', 'f', 'c', 's', 'j', 'd', 'e', 'h'};
        String str = "abtp";
        MatrixPath matrixPath = new MatrixPath();

        System.out.println(matrixPath.hasPath(matrix, 3, 4, str.toCharArray()));
    }
}
