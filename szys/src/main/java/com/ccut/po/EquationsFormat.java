package com.ccut.po;

/**
 * 算式格式化类
 */
public class EquationsFormat {

    public static String EquationFormat(String [][] equations_and_answer,int lines,int rows){
        String eq_header,eq_footer,an_header,an_footer;
        String equastion_format;

        //算式首部
        eq_header="*--*--*--*--*--*--*--*-  四  则  算  术  题  -*--*--*--*--*--*--*--*--*--*--*--*\r\n";

        //算式尾部
        eq_footer="*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*-\r\n";

        //算式首部
        an_header="*--*--*--*--*--*--*--*-  答              案  -*--*--*--*--*--*--*--*--*--*--*--*\r\n";

        //算式尾部
        an_footer="*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*-\r\n";

        //算式主体
        String str_question = "";
        int c_question = 0;  //题目编号
        for (int i = 0; i < lines ; i++) {  //题目数
            for (int j = 0; j < rows; j++) {    //列
                if (equations_and_answer[c_question][0] == null) // 如果处算式为空，则表明到了算式尾，结束拼接
                    break;
                str_question +=(c_question+1)+"、" + equations_and_answer[c_question][0] + "____\t"; // 将一行算式拼接，指定rows列
                c_question++;
            }
            str_question += "\r\n";
            if (c_question >= lines)
                break;
        }

        //答案主体
        String str_answer = "";
        int c_answer=0; //答案编号
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < 5; j++) {
                if (equations_and_answer[c_answer][1] == null)
                    break;
                str_answer += (c_answer+1)+ "、"+equations_and_answer[c_answer][1] + "\t";
                c_answer++;
            }
            str_answer += "\r\n";
            if (c_answer >= lines)
                break;
        }

        //组合
        equastion_format=eq_header+str_question+eq_footer+an_header+str_answer+an_footer;

        //返回格式化后的算式
        return equastion_format;
    }



}
