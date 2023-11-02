package com.ltx.oop02.thisProject.exer;

/**
 * ClassName: Girl
 * Package:com.ltx.oop02.thisProject.exer
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/1 15:20
 */
public class Girl {
    private String name;
    private int age;

    public Girl(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void marry(Boy boy){
        System.out.println("Marry" + boy.getName());

        boy.marry(this);//表示当前这个调用marry方法的女生对象
    }

    /**
     *比较两个Girl对象的大小
     * @param girl 另外一个女孩对象
     * @return 比较两个对象的大小，肯定是比较对象的属性大小
     */
    public int compare(Girl girl){
        if(this.age > girl.age){
            return 1;
        }else if (this.age < girl.age){
            return 0;
        }else {
            return -1;
        }
    }
}
