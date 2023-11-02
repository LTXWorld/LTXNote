package com.ltx.lectureOctober.StudentExperiment;

/**
 * ClassName: MyGroup
 * Package:com.ltx.lectureOctober.E2
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/17 14:08
 */
public interface MyGroup {
    boolean isEmpty();
    boolean addStu(Student x);
    Student removeStu(int index);
    void sort(int x);
    void print();

}
