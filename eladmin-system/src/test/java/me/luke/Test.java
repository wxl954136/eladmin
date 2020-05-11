package me.luke;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Test {
    public static void main(String args[]){
        System.out.println("1=====" + new DecimalFormat("#.##").format(123.40));
        NumberFormat nf   =   NumberFormat.getPercentInstance();
        nf.setMinimumFractionDigits(7);
        Bean x = new Bean();
        x.setId(1L);

        x.setB(new BigDecimal(11133));
        x.setA("aaa");
        System.out.println(x.toString());



    }
}
