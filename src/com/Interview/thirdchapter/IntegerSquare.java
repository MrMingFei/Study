package com.Interview.thirdchapter;

public class IntegerSquare {
    public double power(double base, int exponent){
        if (equal(base, 0.0) && exponent < 0){
            throw new RuntimeException("while exponent is minus,the base can't be zero");
        }
        int absExponent = exponent;
        if (exponent < 0){
            //absExponent = ~exponent + 1;
            absExponent = Math.abs(exponent);
        }
        double result = powerWithUnsignedExponent_V2(base, absExponent);
        if (exponent < 0){
            result = 1.0/result;
        }
        return result;
    }

    /**
     * 指数非负的时候求乘方运算，连乘
     * @param base
     * @param absExponent
     * @return
     */
    private double powerWithUnsignedExponent(double base, int absExponent){
        double result = 1.0;
        for (int i = 0; i < absExponent; i++){
            result = result*base;
        }
        return result;
    }

    /**
     * 指数非负的时候求乘方运算，高效
     * @param base
     * @param absExponent
     * @return
     */
    private double powerWithUnsignedExponent_V2(double base, int absExponent){
        if (absExponent == 0){
            return 1.0;
        }
        if (absExponent == 1){
            return base;
        }
        double result = powerWithUnsignedExponent_V2(base, absExponent >> 1);
        result = result*result;
        if((absExponent&0x1)==1)
            result=result*base;
        return result;
    }

    /**
     * 浮点数由于精度问题不能用==进行判断
     * @param num1
     * @param num2
     * @return
     */
    private boolean equal(double num1, double num2){
        if ((num1-num2) > -0.0000001 && (num1-num2) < 0.0000001){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        IntegerSquare integerSquare = new IntegerSquare();
        System.out.println(integerSquare.power(2.0, 9));
    }
}
