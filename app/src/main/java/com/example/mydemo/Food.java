package com.example.mydemo;

public class Food {
    private String name;
    private boolean sour, sweet, bitter, hot, salt, light;
    private int price;
    private int pic;

    public Food() {
    }

    public Food(String name, boolean sour, boolean sweet, boolean bitter, boolean hot, boolean salt, boolean light, int price, int pic) {
        this.name = name;
        this.sour = sour;
        this.sweet = sweet;
        this.bitter = bitter;
        this.hot = hot;
        this.salt = salt;
        this.light = light;
        this.price = price;
        this.pic = pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSour() {
        return sour;
    }

    public void setSour(boolean sour) {
        this.sour = sour;
    }

    public boolean isSweet() {
        return sweet;
    }

    public void setSweet(boolean sweet) {
        this.sweet = sweet;
    }

    public boolean isBitter() {
        return bitter;
    }

    public void setBitter(boolean bitter) {
        this.bitter = bitter;
    }

    public boolean isHot() {
        return hot;
    }

    public void setHot(boolean hot) {
        this.hot = hot;
    }

    public boolean isSalt() {
        return salt;
    }

    public void setSalt(boolean salt) {
        this.salt = salt;
    }

    public boolean isLight() {
        return light;
    }

    public void setLight(boolean light) {
        this.light = light;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", sour=" + sour +
                ", sweet=" + sweet +
                ", bitter=" + bitter +
                ", hot=" + hot +
                ", salt=" + salt +
                ", light=" + light +
                ", price=" + price +
                ", pic=" + pic +
                '}';
    }
}