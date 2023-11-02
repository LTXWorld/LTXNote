package com.BigProject1.domain;

/**
 * ClassName: Architect
 * Package:com.BigProject1.domain
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/12 15:27
 */
public class Architect extends Designer{
    private int stock;

    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Architect() {
    }
    public String toString() {
        return getDetails() + "\t架构师\t" + getStatus() + "\t" + getBonus() + "\t" +getStock() + "\t" + getEquipment().getDescription();
    }
}
