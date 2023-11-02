package com.BigProject1.junit;

import com.BigProject1.domain.Employee;
import com.BigProject1.service.NameListService;
import com.BigProject1.service.TeamException;
import org.junit.Test;

/**
 * ClassName: NameListServiceTest
 * Package:com.BigProject1.junit
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/12 16:22
 */
public class NameListServiceTest {
    @Test
    public void test1(){
        NameListService nameListService = new NameListService();

        Employee[] allEmployees = nameListService.getAllEmployees();
        for (int i = 0; i < allEmployees.length; i++) {
            System.out.println(allEmployees[i]);
        }
    }
    @Test
    public void test2(){
        try {
            NameListService nameListService = new NameListService();
            int id = 13;
            Employee employee = nameListService.getEmployee(id);
            System.out.println(employee);
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }
    }
}
