package com.BigProject1.domain;

/**
 * ClassName: Notebook
 * Package:com.BigProject1.domain
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/12 11:12
 */
public class Notebook implements Equipment{
    private String model;
    private double price;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Notebook(String model, double price) {
        this.model = model;
        this.price = price;
    }

    public Notebook() {
    }

    @Override
    public String getDescription() {
        return model + "(" + price + ")";
    }
}
