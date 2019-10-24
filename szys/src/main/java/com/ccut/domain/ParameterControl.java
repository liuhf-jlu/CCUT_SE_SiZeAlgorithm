package com.ccut.domain;

/**
 * 输入参数控制类
 */
public class ParameterControl {
    private int num;    //要生成习题的数量
    private boolean is_include_multiplication_division; //是否包含乘除法
    private boolean is_include_negative;    //是否包含负数
    private int interval_number; //区间数

    /**
     * 默认的控制参数，输出20道不包含乘除不包含负数的100以内的算式
     */
    public ParameterControl(){
        this.num=20;
        this.is_include_multiplication_division=false;
        this.is_include_negative=false;
        this.interval_number=100;
    }

    /**
     * 给定初始的控制参数
     * @param num
     * @param is_include_multiplication_division
     * @param is_include_negative
     * @param interval_number
     */
    public ParameterControl(int num,boolean is_include_multiplication_division,boolean is_include_negative,int interval_number){
        this.num=num;
        this.is_include_multiplication_division=is_include_multiplication_division;
        this.is_include_negative=is_include_negative;
        this.interval_number=interval_number;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public boolean isIs_include_multiplication_division() {
        return is_include_multiplication_division;
    }

    public void setIs_include_multiplication_division(boolean is_include_multiplication_division) {
        this.is_include_multiplication_division = is_include_multiplication_division;
    }

    public boolean isIs_include_negative() {
        return is_include_negative;
    }

    public void setIs_include_negative(boolean is_include_negative) {
        this.is_include_negative = is_include_negative;
    }

    public int getInterval_number() {
        return interval_number;
    }

    public void setInterval_number(int interval_number) {
        this.interval_number = interval_number;
    }

    @Override
    public String toString() {
        return "ParameterControl{" +
                "num=" + num +
                ", is_include_multiplication_division=" + is_include_multiplication_division +
                ", is_include_negative=" + is_include_negative +
                ", interval_number=" + interval_number +
                '}';
    }
}
