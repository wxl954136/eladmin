package me.luke;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Bean {
    private Long id;
    private String a;
    private BigDecimal b;

    public Bean() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public BigDecimal getB() {
        return b;
    }

    public void setB(BigDecimal b) {
        this.b = b;
    }

    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this);
        Field[] fields = this.getClass().getDeclaredFields();

        try {
            for (Field f : fields) {
                f.setAccessible(true);
                System.out.println("x=====" + f.getName()  + "------------------" + f.getType() + "=-====" + f.getType().getTypeName());
                if (f.getType().getTypeName().equalsIgnoreCase("java.math.BigDecimal")){
                    //f.get(this)
                    System.out.println("y===" + f.get(this));

                    System.out.println("z===" + new DecimalFormat("00.0000000").format(Double.parseDouble(f.get(this).toString())));
                }
                builder.append(f.getName(), f.get(this)).append("\n");

            }
        } catch (Exception e) {

        }
            return builder.toString();
    }
}
