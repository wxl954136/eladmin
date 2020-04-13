package me.luke.utils;

/**
 * 系统状态字典
 * @author luke
 * @date 2018/08/01 16:45:43
 */
public enum  SysStatusEnum {

    /** 成本讲价方式 */
    COST_AVER("加权平均", 1),
    COST_SINGLE("个别计价",2),

    CLOSED("交易关闭", "TRADE_CLOSED");

    private String value;
    private int index;


    SysStatusEnum(String name, String value) {
        this.value = value;
    }
    SysStatusEnum(String name, int index) {
        this.index = index;
    }

    public void setValue(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
