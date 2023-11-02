package com.BigProject1.service;

import com.BigProject1.domain.Architect;
import com.BigProject1.domain.Designer;
import com.BigProject1.domain.Employee;
import com.BigProject1.domain.Programmer;

/**
 * ClassName: TeamService
 * Package:com.BigProject1.service
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/12 16:42
 */
public class TeamService {
    private static int counter = 1;//对memberid进行自动赋值的基数

    private final int Max_MEMBER = 5;//开发团队最大接受人数
    private Programmer[] team = new Programmer[Max_MEMBER];//这里已经限制了团队最少是programmer
    private int total;//记录此时开发团队中人数

    /**
     * 返回当前团队的所有对象,只有三个人的话，就返回只有三个人的
     * @return 需要新造数组存放
     */
    public Programmer[] getTeam(){
        Programmer[] teamAppend = new Programmer[total];
        for (int i = 0; i < total; i++) {
            teamAppend[i] = this.team[i];
        }
        return teamAppend;
    }

    /**
     * 增加成员
     * @param e
     */
    public void addMember(Employee e) throws TeamException{
        //成员已满无法添加
        if (total >= Max_MEMBER){
            throw new TeamException("成员已满，无法添加");
        }
        //不是开发人员，无法添加
        if (!(e instanceof Programmer)){
            throw new TeamException("不是开发人员，无法添加");
        }
        //已是某团队的成员了
        Programmer p = (Programmer) e;
        Status status = p.getStatus();
        switch (status){
            case BUSY :
                throw new TeamException("已是某团队成员了");
            case VOCATION:
                throw new TeamException("已经在休假了");

        }
        //
        boolean isExist = isExist(p);
        if (isExist){
            throw new TeamException("该员工已在本开发团队中");
        }
        //至多只能有一个架构师
        int ProNum =0, DesNum = 0, ArcNum = 0;
        for (int i = 0; i < total; i++) {
            if (team[i] instanceof Architect){
                ArcNum ++;
            } else if (team[i] instanceof Designer) {
                DesNum ++;
            }else {
                ProNum ++;
            }
        }
        if (p instanceof Architect){
            if (ArcNum >= 1){
                throw new TeamException("架构师人数已经足够");
            }//注意外面的if进来后如果里面的if不满足直接跳出控制流
        }else if (p instanceof Designer){
            if (DesNum >= 2){
                throw new TeamException("设计师人数已经足够");
            }
        }else {
            if (ProNum >= 3){
                throw new TeamException("程序员已经够了");
            }
        }
        //走到这里意味着p可以正常添加,上面全是不满足的条件
        team[total ++] = p;
        p.setMemberId(counter ++);
        p.setStatus(Status.BUSY);

    }

    /**
     * 判断p对象是否存在于当前开发团队中
     * @param p
     * @return
     */
    private boolean isExist(Programmer p) {
        for (int i = 0; i < total; i++) {
            if (team[i].getId() == p.getId()){
                return true;
            }
        }
        return false;
    }

    /**
     * 移除成员
     * @param memberID
     */
    public void removeMember(int  memberID) throws TeamException{
        int i = 0;
        for (; i < total; i++) {

            if (team[i].getMemberId() == memberID){
                //找到员工，调整属性
                team[i].setStatus(Status.FREE);
                //移动以完成删除,写在下面的方法
                break;
            }
        }

        //没找到
        if (i == total){
            throw new TeamException("找不到指定员工，删除失败");
        }
        //
        for (int j = i; j < total - 1 ; j++) {//这个取值范围
            team[j] = team[j + 1];
        }
        team[-- total] = null;

    }
}
