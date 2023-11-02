package com.BigProject1.domain;

/**
 * ClassName: Designer
 * Package:com.BigProject1.domain
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/12 11:22
 */
public class Designer extends Programmer {
    private double bonus;

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    public Designer() {
    }

    @Override
    public String toString() {
        return getDetails() + "\t设计师\t" + getStatus() + "\t" + getBonus() + "\t\t\t\t\t" + getEquipment().getDescription();
    }
}
