package com.BigProject1.domain;

/**
 * ClassName: PC
 * Package:com.BigProject1.domain
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/12 11:09
 */
public class PC implements Equipment{
    private String model;
    private String display;

    public PC() {
    }

    public PC(String model, String display) {
        this.model = model;
        this.display = display;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    @Override
    public String getDescription() {
        return model + "(" + display + ")";
    }
}