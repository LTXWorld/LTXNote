package com.BigProject1.service;

import com.BigProject1.domain.*;

import static com.BigProject1.service.Data.EMPLOYEES;
import static com.BigProject1.service.Data.EQUIPMENTS;

/**
 * ClassName: NameListService
 * Package:com.BigProject1.service
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/12 15:29
 */
public class NameListService {
    private Employee[] employees;
    public NameListService(){
        employees = new Employee[EMPLOYEES.length];
        for (int i = 0; i < employees.length; i++) {
            int type = Integer.parseInt(EMPLOYEES[i][0]);
            //获取通用属性
            int id = Integer.parseInt(EMPLOYEES[i][1]);
            String name = EMPLOYEES[i][2];
            int age = Integer.parseInt(EMPLOYEES[i][3]);
            double salary = Double.parseDouble(EMPLOYEES[i][4]);
            //判断员工类型是哪一种
            Equipment equipment;
            double bonus;
            int stock;
            switch (type){
                case Data.EMPLOYEE :
                    employees[i] = new Employee(id,name,age,salary);
                    break;
                case  Data.PROGRAMMER:
                    equipment = createEquipment(i);
                    employees[i] = new Programmer(id,name,age,salary,equipment);
                    break;
                case Data.DESIGNER:
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    employees[i] = new Designer(id,name,age,salary,equipment,bonus);
                    break;
                case Data.ARCHITECT:
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    stock = Integer.parseInt(EMPLOYEES[i][6]);
                    employees[i] = new Architect(id,name,age,salary,equipment,bonus,stock);
                    break;
            }
        }
    }
    private Equipment createEquipment(int index){
        int equipmentType = Integer.parseInt(EQUIPMENTS[index][0]);
        //获取Equipment里面各属性
        String modelOrName = EQUIPMENTS[index][1];
        String priceDisplay = EQUIPMENTS[index][2];
        switch (equipmentType){
            case Data.PC:
                return new PC(modelOrName,priceDisplay);
            case Data.NOTEBOOK:
                double price = Double.parseDouble(priceDisplay);
                return new Notebook(modelOrName,price);
            case Data.PRINTER:
                return new Printer(modelOrName,priceDisplay);
        }
        return null;
    }
    public Employee[] getAllEmployees(){
        return employees;
    }

    /**
     * 获取指定id的员工
     * @param id
     * @return
     */
    public Employee getEmployee(int id) throws TeamException{
        for (int i = 0; i < employees.length; i++) {
            if (id == employees[i].getId()){
                return employees[i];
            }
        }
        //找了一遍没有找到
        throw new TeamException("找不到指定员工，请检查id");
    }
}
