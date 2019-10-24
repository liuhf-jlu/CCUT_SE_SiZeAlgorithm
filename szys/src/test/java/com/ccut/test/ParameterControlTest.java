package com.ccut.test;

import com.ccut.domain.ParameterControl;
import org.junit.Test;

public class ParameterControlTest {
    public ParameterControl parameterControl_1=new ParameterControl();
    public ParameterControl parameterControl_2=new ParameterControl(100,true,true,1000);

    @Test
    public void test_is_create(){
        parameterControl_1.toString();
        parameterControl_2.toString();
    }

}
