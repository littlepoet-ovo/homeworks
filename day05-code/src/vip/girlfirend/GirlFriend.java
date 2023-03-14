package vip.girlfirend;

public class GirlFriend {
    private String name;
    private double high;

    public GirlFriend() {
    }

    public GirlFriend(String name, double high) {
        this.name = name;
        this.high = high;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return high
     */
    public double getHigh() {
        return high;
    }

    /**
     * 设置
     * @param high
     */
    public void setHigh(double high) {
        this.high = high;
    }

    public String toString() {
        return "GirlFriend{name = " + name + ", high = " + high + "}";
    }
}
