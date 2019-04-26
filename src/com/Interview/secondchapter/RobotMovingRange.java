package com.Interview.secondchapter;

public class RobotMovingRange {
    public int movingCount(int threshold, int rows, int cols){
        if (threshold < 0){
            return 0;
        }
        boolean[] visit = new boolean[rows*cols];
        int count = movingCountCore(threshold, rows, cols, 0, 0, visit);
        return count;
    }
    /**
     * 计算可到达格子数量之和
     * @param threshold
     * @param rows
     * @param cols
     * @param row
     * @param col
     * @param visit
     * @return
     */
    private int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[] visit){
        int count = 0;
        if (check(threshold, rows, cols, row, col, visit)){
            visit[row*cols + col] = true;
            //这里row、col做减法好像没有必要
            count = 1 + movingCountCore(threshold, rows, cols, row+1, col, visit)
                      + movingCountCore(threshold, rows, cols, row-1, col, visit)
                      + movingCountCore(threshold, rows, cols, row, col+1, visit)
                      + movingCountCore(threshold, rows, cols, row, col-1, visit);
        }
        return count;
    }
    /**
     * 判断是否满足条件
     * @param threshold
     * @param rows
     * @param cols
     * @param row
     * @param col
     * @param visit
     * @return
     */
    public boolean check(int threshold, int rows, int cols, int row, int col, boolean[] visit){
        if (row >= 0 && row < rows && col >= 0 && col < cols && visit[row*cols + col] == false && getDigitSum(col) + getDigitSum(row) <= threshold){
            return true;
        }
        return false;
    }
    /**
     * 计算位数之和
     * @param n
     * @return
     */
    private int getDigitSum(int n){
        int sum = 0;
        while (n != 0){
            sum += n%10;
            n = n/10;
        }
        return sum;
    }

    public static void main(String[] args){
        RobotMovingRange movingRange = new RobotMovingRange();
        int count = movingRange.movingCount(2, 3, 3);
        System.out.println(count);
    }
}
