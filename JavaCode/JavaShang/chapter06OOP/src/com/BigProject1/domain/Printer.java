package com.BigProject1.domain;

/**
 * ClassName: Printer
 * Package:com.BigProject1.domain
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/12 11:13
 */
public class Printer implements Equipment {
    private String name;
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Printer(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public Printer() {
    }

    @Override
    public String getDescription() {
        return name + "(" + type + " )";
    }
}
