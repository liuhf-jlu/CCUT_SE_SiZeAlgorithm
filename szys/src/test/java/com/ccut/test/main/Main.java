package com.ccut.test.main;

import com.ccut.domain.ParameterControl;
import com.ccut.po.Calculator;
import com.ccut.po.EquationsFormat;
import com.ccut.po.Output;

import java.io.IOException;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        ParameterControl parameterControl_default=new ParameterControl();   //默认输出控制
        ParameterControl parameterControl=new ParameterControl(1000,true,true,1000);
        Calculator calculator=new Calculator(parameterControl);
        String output=EquationsFormat.EquationFormat(calculator.CreateQuestion(),parameterControl.getNum(),5);
        System.out.println(output);
        LocalDate data=LocalDate.now();
        try {
            Output.createTxt("src/suanshi/", "四则运算"+data, output);
        }catch (IOException ex) {
            System.out.println(ex.getMessage());
        }finally {
            System.out.println("四则运算"+data+".txt "+"导出到txt完成");
        }
    }
}
