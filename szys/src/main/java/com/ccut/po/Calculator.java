package com.ccut.po;

import com.ccut.domain.ParameterControl;
import com.sun.xml.internal.ws.commons.xmlutil.Converter;

import java.util.List;

/**
 * 计算类
 */
public class Calculator {
    private ParameterControl parameterControl;  //参数控制器

    public Calculator(ParameterControl parameterControl){
        this.parameterControl=parameterControl;
    }
    public ParameterControl getParameterControl() {
        return parameterControl;
    }

    public void setParameterControl(ParameterControl parameterControl) {
        this.parameterControl = parameterControl;
    }

    @Override
    public String toString() {
        return "Calculator{" +
                "parameterControl=" + parameterControl +
                '}';
    }

    public String[][] CreateQuestion(){
        List<String> equations=null; //生成的算式列表
        int num1,num2,result;
        int type;
        int count = 0;
        String[][] Question_Answer = new String[99999][2];
        while (true) {
            if (count >= parameterControl.getNum()){
                break;
            }
            if (parameterControl.isIs_include_negative()) {
                num1 = GetRandomNegativeNumber(parameterControl.getInterval_number());
                num2 = GetRandomNegativeNumber(parameterControl.getInterval_number());
            } else {
                num1 = GetRandomPositiveNumber(parameterControl.getInterval_number());
                num2 =GetRandomPositiveNumber(parameterControl.getInterval_number());
            }
            if (!parameterControl.isIs_include_negative())
                if (num1 < 0 || num2 < 0)
                    continue;
            type = 1 + (int) (Math.random() * 4);
            if (type == 1) {
                result = num1 + num2;
                if (result < 100) {
                    Question_Answer[count][0] = "("+num1+")" + " + " +"("+ num2+")" + " =";
                    Question_Answer[count][1] = result+"";
                    count++;
                }
            } else if (type == 2) {
                result = num1 - num2;
                if (result < 100) {
                    Question_Answer[count][0] = "("+num1+")" + " - " +"("+ num2+")" + " =";
                    Question_Answer[count][1] = result+"";
                    count++;
                }
            } else if (type == 3 && parameterControl.isIs_include_multiplication_division()) {
                result = num1 * num2;
                if (result < 100) {
                    Question_Answer[count][0] = "("+num1+")" + " × " +"("+ num2+")" + " =";
                    Question_Answer[count][1] = result+"";
                    count++;
                }
            } else if (type == 4 && parameterControl.isIs_include_multiplication_division()) {
                Double result_;
                if (num2 == 0)
                    continue;
                result_ = (double) num1 / num2;
                if (result_ < 100) {
                    Question_Answer[count][0] = "("+num1+")" + " ÷ " +"("+ num2+")" + " =";
                    Question_Answer[count][1] = String.format("%.2f", result_); // 精度控制
                    count++;
                }
            }
        }
        return Question_Answer;
    }

    private int GetRandomNegativeNumber(int interval_number){
        int random_negative_number=0;
        random_negative_number = (int) ((Math.random() * interval_number) - 50);
        return random_negative_number;
    }

    private int GetRandomPositiveNumber(int interval_number){
        int random_positive_number=0;
        random_positive_number=(int) ((Math.random() * interval_number) - 50);
        return random_positive_number;
    }

}
