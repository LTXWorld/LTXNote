package com.BigProject1.domain;

import com.BigProject1.service.Status;

/**
 * ClassName: Programmer
 * Package:com.BigProject1.domain
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/12 11:16
 */
public class Programmer extends Employee{
    private int memberId;
    private Status status = Status.FREE;
    private Equipment equipment;

    public Programmer() {
    }

    /**
     * 只需要从自己属性中添加一个即可，有两个已经确定了或者加入才给
     * @param id
     * @param name
     * @param age
     * @param salary
     * @param equipment
     */

    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }
    public String toString() {
        return getDetails() + "\t程序员\t" + status +"\t\t\t\t\t" + equipment.getDescription();
    }
}
